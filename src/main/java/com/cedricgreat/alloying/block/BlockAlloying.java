package com.cedricgreat.alloying.block;


import com.cedricgreat.alloying.Alloying;
import com.cedricgreat.alloying.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockAlloying extends Block
{
    public BlockAlloying(final Material material, final MapColor mapColor, final String blockName)
    {
        super(material, mapColor);
        setBlockName(this, blockName);
        //TODO Creative Tab
        setCreativeTab(Alloying.creativeTab);
    }

    public BlockAlloying(final Material materialIn, final String blockName)
    {
        this(materialIn, materialIn.getMaterialMapColor(), blockName);
    }

    public static void setBlockName(final Block block, final String blockName)
    {
        block.setRegistryName(Reference.MOD_ID, blockName);
        block.setUnlocalizedName(block.getRegistryName().toString());
    }
}
