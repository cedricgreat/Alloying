package com.cedricgreat.alloying.block;

import com.cedricgreat.alloying.Alloying;
import com.cedricgreat.alloying.init.ModBlocks;
import com.cedricgreat.alloying.init.ModItems;
import com.cedricgreat.alloying.utility.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;


public class BlockBase extends Block implements IHasModel
{

    public BlockBase(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        //TODO Create own creative tab!
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels()
    {
        Alloying.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
