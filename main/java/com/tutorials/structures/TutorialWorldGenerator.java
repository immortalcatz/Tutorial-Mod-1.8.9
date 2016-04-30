package com.tutorials.structures;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TutorialWorldGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		// these are important!
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;
		// generate differently based on dimension
		switch(world.provider.getDimensionId())
		{
		case -1: generateNether(world, random, blockX, blockZ);
		break;
		case 0: generateOverworld(world, random, blockX, blockZ);
		break;
		case 1: generateEnd(world, random, blockX, blockZ);
		break;
		}
		
	}

	private void generateNether(World world, Random rand, int blockX, int blockZ) 
	{
		// leaving blank for now		
	}

	private void generateOverworld(World world, Random rand, int blockX, int blockZ) 
	{
		// make a world generator to use
		WorldGenCookieBushes genCookieBushes = new WorldGenCookieBushes();
		// get the biome. I used 64 for Y, but you can use anything between 0 and 255
		BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(blockX, 64, blockZ));
		// check that it's a Plains biome
		// we could also use: if(biome instanceof BiomeGenPlains)
		if(biome == BiomeGenBase.plains)
		{
			// how many we want to make per chunk
			// let's make it random between MIN and MAX
			int MIN = 4;
			int MAX = 12;
			int numBushes = MIN + rand.nextInt(MAX - MIN);
			// now let's generate the bushes
			for(int i = 0; i < numBushes; i++)
			{
				// get a random position in the chunk
				int randX = blockX + rand.nextInt(16);
				int randZ = blockZ + rand.nextInt(16);
				// the y-value we pass here will be used as minimum spawn height
				genCookieBushes.generate(world, rand, new BlockPos(randX, 24, randZ));
			}
		}
	}

	private void generateEnd(World world, Random rand, int blockX, int blockZ) 
	{
		// leaving blank for now
	}
}