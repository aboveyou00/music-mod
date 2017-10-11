package com.blslade.music_mod;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class CommonProxy
{
	public CommonProxy()
	{
		
	}

	public void preInit(FMLPreInitializationEvent e)
	{
		System.out.println("In CommonProxy.preInit");
	}
	public void init(FMLInitializationEvent e)
	{
		System.out.println("In CommonProxy.init");
	}
	public void postInit(FMLPostInitializationEvent e)
	{
		System.out.println("In CommonProxy.postInit");
	}
}
