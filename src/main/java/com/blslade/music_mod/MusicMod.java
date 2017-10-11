package com.blslade.music_mod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = MusicMod.MODID, version = MusicMod.VERSION)
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
    
    public MusicMod()
    {
    	System.out.println("Hello, Minecraft!");
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    	proxy.preInit(e);
    }
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	proxy.init(e);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
    	proxy.postInit(e);
    }
}
