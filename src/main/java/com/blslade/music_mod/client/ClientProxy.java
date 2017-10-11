package com.blslade.music_mod.client;

import com.blslade.music_mod.CommonProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy extends CommonProxy
{
	public ClientProxy()
	{
		super();
	}

	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
		System.out.println("In ClientProxy.preInit");
	}
	public void init(FMLInitializationEvent e)
	{
		super.init(e);
		System.out.println("In ClientProxy.init");	
	}
	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
		System.out.println("In ClientProxy.postInit");
	}
	
	public void registerModels(ModelRegistryEvent e)
	{
		super.registerModels(e);
		System.out.println("In ClientProxy.registerModels");
	}
}
