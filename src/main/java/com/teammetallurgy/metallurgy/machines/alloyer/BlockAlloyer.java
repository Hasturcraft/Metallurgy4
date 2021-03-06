package com.teammetallurgy.metallurgy.machines.alloyer;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.teammetallurgy.metallurgy.Metallurgy;
import com.teammetallurgy.metallurgy.lib.GUIIds;
import com.teammetallurgy.metallurgy.machines.BlockMetallurgy;

public class BlockAlloyer extends BlockMetallurgy
{

    private String topTexture = "metallurgy:machines/alloyer_top";
    private String sideTexture = "metallurgy:machines/alloyer_side";
    private String frontTexture = "metallurgy:machines/alloyer_front";
    private String bottomTexture = "metallurgy:machines/alloyer_bottom";

    private IIcon topIcon;
    private IIcon sideIcon;
    private IIcon frontIcon;
    private IIcon bottomIcon;
    
    public BlockAlloyer()
    {
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityAlloyer();
    }

    @Override
    protected void doOnActivate(World world, int x, int y, int z, EntityPlayer player, int side, float xOffset, float yOffset, float zOffset)
    {
        player.openGui(Metallurgy.instance, GUIIds.ALLOYER, world, x, y, z);
    }
    
    @Override
    public void onBlockPlacedBy(World world, int coordX, int coordY, int coordZ, EntityLivingBase livingEntity, ItemStack blockItemStack)
    {
        int l = MathHelper.floor_double((double) (livingEntity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(coordX, coordY, coordZ, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(coordX, coordY, coordZ, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(coordX, coordY, coordZ, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(coordX, coordY, coordZ, 4, 2);
        }

    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if (side == meta) { return this.frontIcon; }

        switch (side)
        {
            case 0:
                return this.bottomIcon;
            case 1:
                return this.topIcon;
            default:
                return this.sideIcon;
        }
    }
    
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        this.bottomIcon = register.registerIcon(this.bottomTexture);
        this.topIcon = register.registerIcon(this.topTexture);
        this.sideIcon = register.registerIcon(this.sideTexture);
        this.frontIcon = register.registerIcon(this.frontTexture);
    }

}
