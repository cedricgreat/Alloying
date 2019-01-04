package com.cedricgreat.alloying.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import javax.annotation.Nullable;

public interface CommonProxy {
    void preInit();

    void init();

    void postInit();

    void doClientRightClick();

    @Nullable
    EntityPlayer getClientPlayer();

    @Nullable
    World getClientWorld();

    IThreadListener getThreadListener(MessageContext context);

    EntityPlayer getPlayer(MessageContext context);

    void displayLockGUI(BlockPos pos, EnumFacing facing);

    class WrongSideException extends RuntimeException {
        public WrongSideException(final String message) {
            super(message);
        }

        public WrongSideException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }
}
