package com.tutorials.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCookieBushEmpty extends Block
{
	public BlockCookieBushEmpty()
	{
		super(Material.plants);
		this.setTickRandomly(true); // this allows the plant to randomly update
		this.setStepSound(soundTypeGrass);
	}

	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		worldIn.setBlockState(pos, TutorialBlocks.cookieBushFull.getDefaultState());
	}

	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		return null;
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean isFullCube()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}
}
