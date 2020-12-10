package minefantasy.mfr.recipe;

import minefantasy.mfr.item.ItemArmourMFR;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class RecipeArmourDyeMF implements IRecipe {
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(InventoryCrafting matrix, World world) {
        ItemStack itemstack = null;
        ArrayList arraylist = new ArrayList();

        for (int i = 0; i < matrix.getSizeInventory(); ++i) {
            ItemStack itemstack1 = matrix.getStackInSlot(i);

            if (itemstack1 != null) {
                if (itemstack1.getItem() instanceof ItemArmourMFR) {
                    ItemArmourMFR itemarmor = (ItemArmourMFR) itemstack1.getItem();

                    if (!itemarmor.canColour() || itemstack != null) {
                        return false;
                    }

                    itemstack = itemstack1;
                } else {
                    if (itemstack1.getItem() != Items.DYE) {
                        return false;
                    }

                    arraylist.add(itemstack1);
                }
            }
        }

        return itemstack != null && !arraylist.isEmpty();
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    @Override
    public ItemStack getCraftingResult(InventoryCrafting matrix) {
        ItemStack itemstack = null;
        int[] aint = new int[3];
        int i = 0;
        int j = 0;
        ItemArmourMFR itemarmor = null;
        int k;
        int l;
        float f;
        float f1;
        int l1;

        for (k = 0; k < matrix.getSizeInventory(); ++k) {
            ItemStack itemstack1 = matrix.getStackInSlot(k);

            if (itemstack1 != null) {
                if (itemstack1.getItem() instanceof ItemArmourMFR) {
                    itemarmor = (ItemArmourMFR) itemstack1.getItem();

                    if (!itemarmor.canColour() || itemstack != null) {
                        return null;
                    }

                    itemstack = itemstack1.copy();
                    itemstack.setCount(1);

                    if (itemarmor.hasColor(itemstack1)) {
                        l = itemarmor.getColor(itemstack);
                        f = (l >> 16 & 255) / 255.0F;
                        f1 = (l >> 8 & 255) / 255.0F;
                        float f2 = (l & 255) / 255.0F;
                        i = (int) (i + Math.max(f, Math.max(f1, f2)) * 255.0F);
                        aint[0] = (int) (aint[0] + f * 255.0F);
                        aint[1] = (int) (aint[1] + f1 * 255.0F);
                        aint[2] = (int) (aint[2] + f2 * 255.0F);
                        ++j;
                    }
                } else {
                    if (itemstack1.getItem() != Items.DYE) {
                        return null;
                    }

                    float[] afloat = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(k));
                    int j1 = (int) (afloat[0] * 255.0F);
                    int k1 = (int) (afloat[1] * 255.0F);
                    l1 = (int) (afloat[2] * 255.0F);
                    i += Math.max(j1, Math.max(k1, l1));
                    aint[0] += j1;
                    aint[1] += k1;
                    aint[2] += l1;
                    ++j;
                }
            }
        }

        if (itemarmor == null) {
            return null;
        } else {
            k = aint[0] / j;
            int i1 = aint[1] / j;
            l = aint[2] / j;
            f = (float) i / (float) j;
            f1 = Math.max(k, Math.max(i1, l));
            k = (int) (k * f / f1);
            i1 = (int) (i1 * f / f1);
            l = (int) (l * f / f1);
            l1 = (k << 8) + i1;
            l1 = (l1 << 8) + l;
            itemarmor.setColor(itemstack, l1);
            return itemstack;
        }
    }

    @Override
    public boolean canFit(int width, int height) {
        return width >= 5 && height >= 5;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }

    @Override
    public IRecipe setRegistryName(ResourceLocation name) {
        return null;
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return null;
    }

    @Override
    public Class<IRecipe> getRegistryType() {
        return null;
    }
}