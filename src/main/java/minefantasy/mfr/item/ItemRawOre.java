package minefantasy.mfr.item;

import minefantasy.mfr.init.MineFantasyTabs;

public class ItemRawOre extends ItemComponentMFR {
    public ItemRawOre(String name, int rarity) {
        super(name, rarity);
        this.setCreativeTab(MineFantasyTabs.tabMaterials);
    }
}
