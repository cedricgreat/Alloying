package com.cedricgreat.alloying.network;

import com.cedricgreat.alloying.Alloying;
import com.cedricgreat.alloying.block.BlockAlloyer;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import javax.annotation.Nullable;

public class MessageFluidTankContents implements IMessage
{

    private IFluidTankProperties[] fluidTankProperties;

    @SuppressWarnings("unused")
    public MessageFluidTankContents() {
    }

    public MessageFluidTankContents(final IFluidTankProperties[] fluidTankProperties) {
        this.fluidTankProperties = fluidTankProperties;
    }

    @Override
    public void fromBytes(final ByteBuf buf) {
        final int numProperties = buf.readInt();
        fluidTankProperties = new IFluidTankProperties[numProperties];

        for (int i = 0; i < numProperties; i++) {
            final NBTTagCompound tagCompound = ByteBufUtils.readTag(buf);
            final FluidStack contents = FluidStack.loadFluidStackFromNBT(tagCompound);

            final int capacity = buf.readInt();

            fluidTankProperties[i] = new FluidTankProperties(contents, capacity);
        }
    }

    @Override
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(fluidTankProperties.length);

        for (final IFluidTankProperties properties : fluidTankProperties) {
            final FluidStack contents = properties.getContents();
            final NBTTagCompound tagCompound = new NBTTagCompound();

            if (contents != null) {
                contents.writeToNBT(tagCompound);
            }

            ByteBufUtils.writeTag(buf, tagCompound);

            buf.writeInt(properties.getCapacity());
        }
    }

    public static class Handler implements IMessageHandler<MessageFluidTankContents, IMessage>
    {

        @Nullable
        @Override
        public IMessage onMessage(final MessageFluidTankContents message, final MessageContext ctx) {
            Alloying.proxy.getThreadListener(ctx).addScheduledTask(() -> {
                final EntityPlayer player = Alloying.proxy.getPlayer(ctx);

                BlockAlloyer.getFluidDataForDisplay(message.fluidTankProperties).forEach(player::sendMessage);
            });

            return null;
        }
    }
}
