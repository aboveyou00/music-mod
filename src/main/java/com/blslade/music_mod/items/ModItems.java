package com.blslade.music_mod.items;

import com.blslade.music_mod.MusicMod;
import com.blslade.music_mod.items.tools.GuitarSword;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(MusicMod.MODID)
public class ModItems
{
	public ModItems()
	{
		
	}

	@ObjectHolder(GuitarSword.name)
    public static Item guitarSword;
    
    public static void register(IForgeRegistry<Item> registry)
    {
		registry.registerAll(
				new GuitarSword()
		);
	}

	public static void registerModels(ModelRegistryEvent e)
	{
		ModelLoader.setCustomModelResourceLocation(guitarSword, 0, new ModelResourceLocation(guitarSword.getRegistryName(), "inventory"));
	}
}
