package com.teammetallurgy.metallurgy.metals;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMetalBlock extends ItemBlock
{

    public ItemMetalBlock(int id)
    {
        super(id);
        setHasSubtypes(true);
        setUnlocalizedName("metallurgy.metal.block." + id);

    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }

    public String getUnlocalizedName(ItemStack itemStack)
    {
        Block block = Block.blocksList[this.getBlockID()];

        if (block != null)
        {
            return ((MetalBlock) block).getUnlocalizedName(itemStack.getItemDamage());
        }
        else
        {
            return getUnlocalizedName();
        }

    }

}
