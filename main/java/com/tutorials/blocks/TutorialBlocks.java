package com.tutorials.blocks;

import com.tutorials.main.TutorialMain;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialBlocks 
{
	public static Block cookieBushFull;
	public static Block cookieBushEmpty;
	
	public static void mainRegistry()
	{
		init();
		register();
	}
	
	private static void init()
	{
		cookieBushFull = new BlockCookieBushFull();
		cookieBushEmpty = new BlockCookieBushEmpty();
	}
	
	private static void register()
	{
		register(cookieBushFull, "cookie_bush_full");
		register(cookieBushEmpty, "cookie_bush_empty");
	}
	
	private static void register(Item item, String name)
	{
		item.setUnlocalizedName(name).setRegistryName(TutorialMain.MODID, name);
		GameRegistry.registerItem(item, item.getRegistryName().toString());
	}
	
	private static void register(Block block, String name)
	{
		block.setUnlocalizedName(name).setRegistryName(TutorialMain.MODID, name);
		GameRegistry.registerBlock(block, block.getRegistryName().toString());
	}
}
