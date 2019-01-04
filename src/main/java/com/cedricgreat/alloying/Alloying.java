package com.cedricgreat.alloying;


import com.cedricgreat.alloying.proxy.CommonProxy;
import com.cedricgreat.alloying.reference.Reference;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import java.util.UUID;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Alloying
{
    public static final CreativeTabAlloying creativeTab = new CreativeTabAlloying();

    @Mod.Instance(Reference.MOD_ID)
    public static Alloying instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static SimpleNetworkWrapper network;
    static
    {
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        Logger.setLogger(event.getModLog());

        FMLLog.bigWarning("Random UUID: {}", UUID.randomUUID().toString());

        network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

        proxy.preInit();
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        //TODO guiHandler https://github.com/Choonster-Minecraft-Mods/TestMod3/blob/1.12.2/src/main/java/choonster/testmod3/client/gui/GuiHandler.java
       //NetworkRegistry.INSTANCE.registerGuiHandler(this, new guiHandler());

        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
}
