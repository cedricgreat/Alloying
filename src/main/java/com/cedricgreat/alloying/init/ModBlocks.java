package com.cedricgreat.alloying.init;


import com.cedricgreat.alloying.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block SMART_ALLOYER_BLOCK = new BlockBase("smart_alloyer_block", Material.IRON);
}
