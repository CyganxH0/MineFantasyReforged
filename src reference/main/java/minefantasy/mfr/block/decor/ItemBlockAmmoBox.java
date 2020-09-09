package minefantasy.mfr.block.decor;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import minefantasy.mfr.MineFantasyReborn;
import minefantasy.mfr.api.helpers.CustomToolHelper;
import minefantasy.mfr.api.material.CustomMaterial;
import minefantasy.mfr.api.tool.IStorageBlock;
import minefantasy.mfr.tile.decor.TileEntityAmmoBox;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemBlockAmmoBox extends ItemBlock implements IStorageBlock {
    public ItemBlockAmmoBox(Block base) {
        super(base);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (item.hasTagCompound() && item.getTagCompound().hasKey(BlockAmmoBox.NBT_Ammo) && item.getTagCompound().hasKey(BlockAmmoBox.NBT_Stock)) {
            ItemStack ammo = new ItemStack(item.getTagCompound().getCompoundTag(BlockAmmoBox.NBT_Ammo));
            int stock = item.getTagCompound().getInteger(BlockAmmoBox.NBT_Stock);
            if (ammo != null) {
                tooltip.add(ammo.getDisplayName() + " x" + stock);
            }
        }
        CustomMaterial material = CustomMaterial.getMaterialFor(item, CustomToolHelper.slot_main);
        if (material != null) {
            tooltip.add(I18n.translateToLocalFormatted("attribute.box.capacity.name",
                    TileEntityAmmoBox.getCapacity(material.tier)));
        }
    }

    @Override
    public void getSubItems(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        if (MineFantasyReborn.isDebug()) {
            ArrayList<CustomMaterial> wood = CustomMaterial.getList("wood");
            Iterator iteratorWood = wood.iterator();
            while (iteratorWood.hasNext()) {
                CustomMaterial customMat = (CustomMaterial) iteratorWood.next();
                items.add(this.construct(customMat.name));
            }
        } else {
            items.add(this.construct("RefinedWood"));
        }
    }

    private ItemStack construct(String name) {
        return CustomToolHelper.constructSingleColoredLayer(this, name, 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getItemStackDisplayName(ItemStack item) {
        return CustomToolHelper.getLocalisedName(item, this.getUnlocalizedNameInefficiently(item) + ".name");
    }
}
