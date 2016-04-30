package com.tutorials.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockCookieBushFull extends BlockCookieBushEmpty
{
	public BlockCookieBushFull() 
	{
		super();
		this.setTickRandomly(false);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		// make the cookie item to give the player
		if(!worldIn.isRemote)
		{
			EntityItem cookie = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(Items.cookie));
			cookie.setNoPickupDelay();
			worldIn.spawnEntityInWorld(cookie);
		}
		// replace this block with a non-cookie bush
		worldIn.setBlockState(pos, TutorialBlocks.cookieBushEmpty.getDefaultState(), 2);
        return true;
    }
}
