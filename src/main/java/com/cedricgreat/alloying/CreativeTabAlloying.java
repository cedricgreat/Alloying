package com.cedricgreat.alloying;

import com.cedricgreat.alloying.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;


public class CreativeTabAlloying extends CreativeTabs
{
    public CreativeTabAlloying()
    {
        super(Reference.MOD_ID);

    }


    @Override
    public ItemStack getTabIconItem()
    {
        return null;
    }
}
