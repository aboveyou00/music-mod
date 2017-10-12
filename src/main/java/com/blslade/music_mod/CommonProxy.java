package com.blslade.music_mod;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.blslade.music_mod.blocks.ModBlocks;
import com.blslade.music_mod.network.PacketPlaySound;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy
{
	public CommonProxy()
	{
		
	}

	public void preInit(FMLPreInitializationEvent e)
	{
		System.out.println("In CommonProxy.preInit");
		
		ModBlocks.registerTileEntities();
		this.initializeNetwork();
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
	
	public void initializeNetwork() {
        MusicMod.network = NetworkRegistry.INSTANCE.newSimpleChannel(MusicMod.networkChannelName);
        MusicMod.network.registerMessage(PacketPlaySound.Handler.class, PacketPlaySound.class, 2, Side.CLIENT);
	}
}
