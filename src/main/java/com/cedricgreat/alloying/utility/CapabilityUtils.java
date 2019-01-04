package com.cedricgreat.alloying.utility;

import com.cedricgreat.alloying.tileentity.TileEntityAlloyer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;

public class CapabilityUtils
{
    @Nullable
    public static <T> T getCapability(@Nullable final ICapabilityProvider provider, final Capability<T> capability, @Nullable final EnumFacing facing)
    {
        return provider != null && provider.hasCapability(capability, facing) ? provider.getCapability(capability, facing) : null;
    }
}
