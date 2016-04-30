package com.tutorials.main;

import com.tutorials.blocks.TutorialBlocks;
import com.tutorials.proxy.CommonProxy;
import com.tutorials.structures.TutorialWorldGenerator;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = TutorialMain.MODID, name = TutorialMain.MOD_NAME, version = TutorialMain.VERSION, acceptedMinecraftVersions = TutorialMain.MC_VERSION)
public class TutorialMain 
{
	public static final String MODID = "tutorials";
	public static final String MOD_NAME = "Tutorials";
	public static final String VERSION = "1.0";
	public static final String MC_VERSION = "1.8.9";
	
	@SidedProxy(clientSide = "com." + MODID + ".proxy.ClientProxy", serverSide = "com." + MODID + ".proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		TutorialBlocks.mainRegistry();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{    
		// register the structure generation class
		GameRegistry.registerWorldGenerator(new TutorialWorldGenerator(), 10);
		
		if(event.getSide() == Side.CLIENT)
		{
			proxy.registerRenders();
		}
	}
}