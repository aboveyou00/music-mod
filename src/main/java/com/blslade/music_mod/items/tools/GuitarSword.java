package com.blslade.music_mod.items.tools;

import com.blslade.music_mod.sounds.ModSounds;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuitarSword extends Item
{
	public static final String name = "guitar_sword";
	
	public GuitarSword()
	{
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.attackDamage = 6;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}

    private final float attackDamage;

    public float getDamageVsEntity()
    {
        return this.attackDamage;
    }

    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Block block = state.getBlock();

        if (block == Blocks.WEB)
        {
            return 15.0F;
        }
        else
        {
            Material material = state.getMaterial();
            return material != Material.PLANTS && material != Material.VINE && material != Material.CORAL && material != Material.LEAVES && material != Material.GOURD ? 1.0F : 1.5F;
        }
    }
    
    public boolean canHarvestBlock(IBlockState blockIn)
    {
        return blockIn.getBlock() == Blocks.WEB;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    public int getItemEnchantability()
    {
        return 22;
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        @SuppressWarnings("deprecation")
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
        }

        return multimap;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
		ItemStack stack = player.getHeldItem(hand);
		if (!world.isRemote)
		{
			for (int x = 0; x < 10; x++) System.out.println("XXXXXXXXXX");
			ModSounds.playSoundFromServer(world, player.posX, player.posY, player.posZ, ModSounds.soundJumpRope, SoundCategory.MUSIC, 1.0f, 1.0f, false, 32.0f);
//			SoundHandler handler = Minecraft.getMinecraft().getSoundHandler();
//			if (musicSound == null) musicSound = new PositionedSoundRecord(ModSounds.soundJumpRope, SoundCategory.MUSIC, 1.0f, 1.0f, player.getPosition());
//			if (!handler.isSoundPlaying(musicSound)) handler.playSound(musicSound);
		}
		return new ActionResult<>(EnumActionResult.PASS, stack);
    }
}
