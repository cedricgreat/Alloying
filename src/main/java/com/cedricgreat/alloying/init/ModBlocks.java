package com.cedricgreat.alloying.init;


import com.cedricgreat.alloying.block.BlockAlloyer;
import com.cedricgreat.alloying.reference.Reference;
import com.cedricgreat.alloying.tileentity.TileEntityAlloyer;
import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

import static com.cedricgreat.alloying.utility.InjectionUtil.Null;

@ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockAlloyer<TileEntityAlloyer> ALLOYER = Null();

    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    public static class RegistrationHandler
    {
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            final IForgeRegistry<Block> registry = event.getRegistry();

            final Block[] blocks = {
                    ALLOYER,
            };

            registry.registerAll(blocks);

        }

        @SubscribeEvent
        public static void registerItemBlocks(final RegistryEvent.Register<Item> event)
        {
            final ItemBlock[] items = {
                    new ItemBlock(ALLOYER),
            };

            final IForgeRegistry<Item> registry = event.getRegistry();

            for (final ItemBlock item : items)
            {
                final Block block = item.getBlock();
                final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
                registry.register(item.setRegistryName(registryName));
                ITEM_BLOCKS.add(item);
            }

            registerTileEntities();
        }
    }

    public static void registerTileEntities()
    {
        registerTileEntity(TileEntityAlloyer.class, "alloyer");
    }

    public static void registerTileEntity(final Class<? extends TileEntity> tileEntityClass, final String name)
    {
        //TODO fix depreciated registerTileEntity for 1.13
        GameRegistry.registerTileEntity(tileEntityClass, Reference.RESOURCE_PREFIX + name);
    }

}
