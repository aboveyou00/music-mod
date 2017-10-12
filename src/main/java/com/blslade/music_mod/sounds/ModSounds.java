package com.blslade.music_mod.sounds;

import com.blslade.music_mod.MusicMod;
import com.blslade.music_mod.network.PacketPlaySound;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class ModSounds
{
	public ModSounds()
	{
		
	}
	
	public static SoundEvent soundJumpRope;

    public static void register(IForgeRegistry<SoundEvent> registry)
    {
    	registry.registerAll(
    			soundJumpRope = newSoundEvent("jump_rope")
		);
	}
    
    private static SoundEvent newSoundEvent(String name)
    {
    	ResourceLocation location = new ResourceLocation(MusicMod.MODID, name);
    	SoundEvent sound = new SoundEvent(location);
    	sound.setRegistryName(location);
    	return sound;
    }
    
    public static void playSoundFromServer(World world, double x, double y, double z, SoundEvent soundIn, SoundCategory category, float volume, float pitch, boolean distanceDelay, double range)
    {
        Object o = ReflectionHelper.getPrivateValue(SoundEvent.class, soundIn, "field_187506_b", "soundName");

        if (o instanceof ResourceLocation) o = o.toString();

        if (o instanceof String)
        {
            String soundId = (String) o;
            String categoryName = category.getName();
            MusicMod.network.sendToAllAround(new PacketPlaySound(x, y, z, soundId, categoryName, volume, pitch, distanceDelay), new NetworkRegistry.TargetPoint(world.provider.getDimension(), x, y, z, range));
        }
    }
}
