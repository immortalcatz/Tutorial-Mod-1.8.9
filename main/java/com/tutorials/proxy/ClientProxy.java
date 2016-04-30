package com.tutorials.proxy;

import com.tutorials.blocks.TutorialBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy 
{
	@Override
	public void registerRenders()
	{
		register(Item.getItemFromBlock(TutorialBlocks.cookieBushEmpty));
		register(Item.getItemFromBlock(TutorialBlocks.cookieBushFull));
	}
	
	private void register(Item i)
	{
		register(i, 0);
	}
	
	private void register(Item i, int meta)
	{
		register(i, meta, i.getRegistryName().toString());
	}
	
	private void register(Item i, int meta, String name)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, meta, new ModelResourceLocation(name, "inventory"));
	}
}
