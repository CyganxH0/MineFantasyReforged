package minefantasy.mfr.material;

import minefantasy.mfr.api.MineFantasyRebornAPI;
import minefantasy.mfr.api.material.CustomMaterial;
import minefantasy.mfr.init.ComponentListMFR;
import minefantasy.mfr.util.MFRLogUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class MetalMaterial extends CustomMaterial {
    public MetalMaterial(String name, int tier, float hardness, float durability, float flexibility, float sharpness, float resistance, float density) {
        super(name, "metal", tier, hardness, durability, flexibility, resistance, sharpness, density);
        setArmourStats(1.0F, flexibility, 1F / flexibility);// Harder materials absorb blunt less but resist cutting and piercing more
    }
    /**
     * Adds a new metal
     *
     * @param name        The name, and register for the metal
     * @param tier        What tier the metal is
     * @param durability    How hard the material is to break
     * @param flexibility How well the metal can bend
     * @param sharpness   How well the metal can be sharpened
     * @param resistance  The resistance to elements such as fire and corrosion, right now
     *                    its just 0-100 for armour resistance against elements
     * @param density     The overall mass (Kg) for an ingot
     */

    public static CustomMaterial getOrAddMetal(String name, int tier, float durability, float flexibility, float sharpness, float resistance, float density, int red, int green, int blue) {
        if (getMaterial(name) != null) {
            return CustomMaterial.getMaterial(name);
        }
        float hardness = ((sharpness + 5F) / 2F) - 1F;
        return new MetalMaterial(name, tier, hardness, durability, flexibility, sharpness, resistance, density).setColour(red, green, blue).register();
    }

    public static CustomMaterial getOrAddMetal(String name, int tier, float hardness, float durability,
            float flexibility, float sharpness, float resistance, float density, int red, int green, int blue) {
        if (getMaterial(name) != null) {
            return CustomMaterial.getMaterial(name);
        }
        return new MetalMaterial(name, tier, hardness, durability, flexibility, sharpness, resistance, density)
                .setColour(red, green, blue).register();
    }

    public static void init() {
        /*
         * BaseMaterialMF WOOD(0, 59, 2.0F, 0.0F, 15), STONE(1, 131, 4.0F, 1.0F, 5),
         * IRON(2, 250, 6.0F, 2.0F, 14), EMERALD(3, 1561, 8.0F, 3.0F, 10), GOLD(0, 32,
         * 12.0F, 0.0F, 22);
         */

        // Weak Mats Name T Dur Flx Shp Rst Wg
        getOrAddMetal("tin", 0, 1.0F, 0.5F, 0.0F, 10F, 2.0F, 164, 177, 177).setRarity(-1).setMeltingPoint(900);
        getOrAddMetal("copper", 0, 1.0F, 1.0F, 0.0F, 50F, 3.0F, 255, 132, 66).setMeltingPoint(1000);

        // Standard Mats Name T Dur Flx Shp Rst Wg
        getOrAddMetal("bronze", 1, 1.5F, 1.0F, 1.5F, 20F, 3.0F, 207, 165, 118).setCrafterTiers(1).setMeltingPoint(1200);
        getOrAddMetal("iron", 2, 2.0F, 1.0F, 2.0F, 20F, 2.5F, 140, 120, 100).setCrafterTiers(2).setMeltingPoint(1200)
                .setArmourStats(1.0F, 1.0F, 1.0F);// Standard
        getOrAddMetal("pig_iron", 2, 2.0F, 0.8F, 2.0F, 20F, 2.5F, 120, 95, 95).setCrafterTiers(2).setMeltingPoint(1200)
                .setArmourStats(1.1F, 0.8F, 1.1F);// Less Blunt for more cutting/piercing
        getOrAddMetal("steel", 3, 3.0F, 1.0F, 2.5F, 30F, 2.5F, 168, 168, 168).setCrafterTiers(3).setMeltingPoint(1500);
        getOrAddMetal("encrusted", 4, 8.0F, 1.0F, 3.0F, 35F, 3.0F, 64, 255, 255).setCrafterTiers(3)
                .setMeltingPoint(1800).setArmourStats(1.0F, 1.0F, 1.2F);// Better Piercing
        getOrAddMetal("obsidian", 4, 8.0F, 1.0F, 3.0F, 35F, 3.0F, 90, 45, 90).setCrafterTiers(3).setMeltingPoint(2000)
                .setArmourStats(1.0F, 1.3F, 1.0F);// Better Blunt
        getOrAddMetal("tungsten", 4, 8.0F, 0.8F, 3.0F, 35F, 4.0F, 66, 86, 65).setCrafterTiers(3).setMeltingPoint(2000)
                .setArmourStats(1.3F, 1.0F, 1.3F);// Better Cutting/Piercing
        getOrAddMetal("black_steel", 5, 6.0F, 1.0F, 4.0F, 50F, 3.0F, 80, 80, 80).setCrafterTiers(4).setMeltingPoint(2000)
                .setArmourStats(1.0F, 1.0F, 1.0F);// Standard
        getOrAddMetal("blue_steel", 6, 7.0F, 1.2F, 5.0F, 65F, 2.0F, 28, 31, 159).setCrafterTiers(5).setMeltingPoint(2000)
                .setArmourStats(1.0F, 1.2F, 0.8F);// Better Blunt and Resist
        getOrAddMetal("red_steel", 6, 8.0F, 0.8F, 6.0F, 50F, 3.5F, 219, 56, 56).setCrafterTiers(5).setMeltingPoint(2000)
                .setArmourStats(0.9F, 0.9F, 1.2F);// Better AC and Piercing

        // Precious Mats
        getOrAddMetal("silver", 0, 2.5F, 1.0F, 0.0F, 40F, 3.5F, 155, 206, 205).setMeltingPoint(1200);
        getOrAddMetal("gold", 0, 2.0F, 1.0F, 0.0F, 40F, 3.5F, 243, 222, 49).setMeltingPoint(1200);

        // Mythic Mats Name T Dur Flx Shp Rst Wg
        getOrAddMetal("mithril", 7, 10.0F, 0.8F, 7.0F, 90F, 2.0F, 250, 180, 250).setMeltingPoint(2500)
                .setCrafterTiers(6).setRarity(1);
        getOrAddMetal("adamantium", 7, 12.0F, 0.8F, 8.0F, 80F, 3.5F, 100, 200, 100).setMeltingPoint(2500)
                .setCrafterTiers(6).setRarity(1);
        getOrAddMetal("mithium", 8, 15.0F, 0.8F, 10.0F, 95F, 2.0F, 60, 200, 255).setMeltingPoint(2500)
                .setCrafterTiers(7).setRarity(2).setUnbreakable();
        getOrAddMetal("ignotumite", 8, 15.0F, 0.8F, 14.0F, 85F, 3.5F, 20, 255, 100).setMeltingPoint(3000)
                .setCrafterTiers(7).setRarity(2).setUnbreakable();
        getOrAddMetal("ender", 8, 15.0F, 0.8F, 12.0F, 90F, 3.0F, 255, 63, 243).setMeltingPoint(3000).setCrafterTiers(7)
                .setRarity(2).setUnbreakable();

        // Non-MF
        getOrAddMetal("stainless_steel", 3, 5.0F, 1.0F, 2.5F, 40F, 2.5F, 188, 188, 198).setMeltingPoint(1600).setCrafterTiers(3);
        getOrAddMetal("titanium", 6, 10.0F, 1.0F, 4.0F, 50F, 1.0F, 190, 190, 160).setMeltingPoint(2000).setCrafterTiers(3);

        getOrAddMetal("thaumium", 4, 4.0F, 1.0F, 3.0F, 65F, 2.5F, 115, 65, 183).setMeltingPoint(1500).setCrafterTiers(3);
        getOrAddMetal("void", 4, 10.0F, 2.0F, 4.0F, 75F, 1.0F, 75, 45, 75).setMeltingPoint(1800).setCrafterTiers(3);
        getOrAddMetal("manasteel", 2, 3.0F, 1.0F, 2.0F, 40F, 2.5F, 88, 195, 231).setMeltingPoint(1500)
                .setArmourStats(1.0F, 1.2F, 1.0F).setCrafterTiers(2);// More Resistant, Stronger than iron
        getOrAddMetal("elven_elementium", 3, 4.0F, 1.0F, 2.5F, 40F, 2.5F, 235, 108, 235).setMeltingPoint(1800)
                .setArmourStats(1.1F, 1.0F, 1.1F).setCrafterTiers(2);// Similar to Manasteel, Slightly stronger
        getOrAddMetal("terrasteel", 4, 6.0F, 1.0F, 4.0F, 40F, 2.5F, 88, 250, 150).setMeltingPoint(1500)
                .setArmourStats(1.0F, 0.9F, 1.0F).setCrafterTiers(3);

        // Alloy
        getOrAddMetal("composite_alloy", 4, 4.5F, 10.0F, 1.0F, 2.5F, 75F, 4.0F, 65, 75, 65).setMeltingPoint(2500)
                .setRarity(1).setCrafterTiers(3).modifyCraftTime(5.0F);// Powerful All-Rounder
    }

    public static void addHeatables() {
        ArrayList<CustomMaterial> metal = CustomMaterial.getList("metal");
        for (CustomMaterial customMat : metal) {
            int[] stats = customMat.getHeatableStats();
            MFRLogUtil.logDebug(
                    "Set Heatable Stats for " + customMat.name + ": " + stats[0] + "," + stats[1] + "," + stats[2]);

            MineFantasyRebornAPI.setHeatableStats("ingot" + customMat.name, stats[0], stats[1], stats[2]);
            MineFantasyRebornAPI.setHeatableStats("hunk" + customMat.name, stats[0], stats[1], stats[2]);
        }

        MineFantasyRebornAPI.setHeatableStats(ComponentListMFR.RIVET, 1000, 2000, 3000);
        MineFantasyRebornAPI.setHeatableStats(ComponentListMFR.METAL_HUNK, -1, -1, -1);
        MineFantasyRebornAPI.setHeatableStats(ComponentListMFR.BAR, -1, -1, -1);
    }

    @Override
    public ItemStack getItemStack() {
        NonNullList<ItemStack> list = OreDictionary.getOres("ingot" + name);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return ItemStack.EMPTY;
    }
}
