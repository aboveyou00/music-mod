package com.blslade.musicmod.network;

import com.blslade.musicmod.sounds.ModSounds;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketPlaySound implements IMessage
{
	public PacketPlaySound()
	{
		
    }
    public PacketPlaySound(double x, double y, double z, String sound, String category, float volume, float pitch, boolean distanceDelay)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.sound = sound;
        this.category = category;
        this.volume = volume;
        this.pitch = pitch;
        this.distanceDelay = distanceDelay;
    }
    
    public double x;
    public double y;
    public double z;
    public String sound;
    public String category;
    public float volume;
    public float pitch;
    public boolean distanceDelay;

    @Override
    public void toBytes(ByteBuf bytes)
    {
        bytes.writeFloat((float) x);
        bytes.writeFloat((float) y);
        bytes.writeFloat((float) z);
        ByteBufUtils.writeUTF8String(bytes, sound);
        ByteBufUtils.writeUTF8String(bytes, category);
        bytes.writeFloat(volume);
        bytes.writeFloat(pitch);
        bytes.writeBoolean(distanceDelay);
    }

    @Override
    public void fromBytes(ByteBuf bytes)
    {
        x = bytes.readFloat();
        y = bytes.readFloat();
        z = bytes.readFloat();
        sound = ByteBufUtils.readUTF8String(bytes);
        category = ByteBufUtils.readUTF8String(bytes);
        volume = bytes.readFloat();
        pitch = bytes.readFloat();
        distanceDelay = bytes.readBoolean();
    }

    public static class Handler extends MessageHandlerWrapper<PacketPlaySound, IMessage>
    {
        @Override
        public IMessage handleMessage(PacketPlaySound message, MessageContext ctx) {
        	//TODO: actually get the correct sound here
            SoundEvent event = ModSounds.soundJumpRope; //DESoundHandler.getSound(message.sound);
            SoundCategory category = SoundCategory.getByName(message.category);

            if (event != null) {
            	Minecraft.getMinecraft().world.playSound(message.x, message.y, message.z, event, category, message.volume, message.pitch, message.distanceDelay);
            }
            else {
                System.err.println("Unable to find sound in vanilla or DE's sound events [" + message.sound + "]");
            }
            return null;
        }
    }
}
