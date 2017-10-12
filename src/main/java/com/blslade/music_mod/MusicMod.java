package com.blslade.music_mod;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import com.blslade.music_mod.blocks.ModBlocks;
import com.blslade.music_mod.items.ModItems;
import com.blslade.music_mod.sounds.ModSounds;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;

@Mod(modid = MusicMod.MODID, version = MusicMod.VERSION)
@Mod.EventBusSubscriber
public class MusicMod
{
    public static final String MODID = "musicmod";
    public static final String VERSION = "1.0";

    public static final String PROXY_CLIENT = "com.blslade.music_mod.client.ClientProxy";
    public static final String PROXY_SERVER = "com.blslade.music_mod.CommonProxy";

    @Mod.Instance(MusicMod.MODID)
    public static MusicMod instance;

    @SidedProxy(clientSide = MusicMod.PROXY_CLIENT, serverSide = MusicMod.PROXY_SERVER)
    public static CommonProxy proxy;

    public static final String networkChannelName = "MusicModNC";
    public static SimpleNetworkWrapper network;
    
    public MusicMod()
    {
    	System.out.println("Hello, Minecraft!");
    }
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    	proxy.preInit(e);
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
    	proxy.init(e);
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
    	proxy.postInit(e);
    }

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> e) {
		ModBlocks.register(e.getRegistry());
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e) {
		ModBlocks.registerBlockItems(e.getRegistry());
		ModItems.register(e.getRegistry());
	}
	
	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> e) {
		ModSounds.register(e.getRegistry());
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent e) {
		ModBlocks.registerModels(e);
		ModItems.registerModels(e);
		proxy.registerModels(e);
	}
}
