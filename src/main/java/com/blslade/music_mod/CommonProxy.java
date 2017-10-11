package com.blslade.music_mod;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.blslade.music_mod.blocks.ModBlocks;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
	public CommonProxy()
	{
		
	}

	public void preInit(FMLPreInitializationEvent e)
	{
		System.out.println("In CommonProxy.preInit");
		
		ModBlocks.registerTileEntities();
	}
	public void init(FMLInitializationEvent e)
	{
		System.out.println("In CommonProxy.init");
	}
	public void postInit(FMLPostInitializationEvent e)
	{
		System.out.println("In CommonProxy.postInit");
	}
	
	public void registerModels(ModelRegistryEvent e)
	{
		System.out.println("In CommonProxy.registerModels");
	}
}
