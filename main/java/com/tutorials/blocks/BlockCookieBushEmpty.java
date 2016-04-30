package com.tutorials.blocks;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCookieBushEmpty extends BlockBush
{
	public BlockCookieBushEmpty()
	{
		super();
		this.setTickRandomly(true); // this allows the plant to randomly update
		this.setStepSound(soundTypeGrass);
		float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.5F + f, 0.5F + f);
	}

	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.randomTick(worldIn, pos, state, rand);
		// doesn't grow with every update.
		// 40% of the time it grows
		final int GROW_CHANCE = 30;
		if(rand.nextInt(100) < GROW_CHANCE)
		{
			worldIn.setBlockState(pos, TutorialBlocks.cookieBushFull.getDefaultState());
		}
	}
}
