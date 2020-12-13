package minefantasy.mfr.client;

import minefantasy.mfr.api.knowledge.client.EntryPage;
import minefantasy.mfr.api.knowledge.client.EntryPageBlastFurnace;
import minefantasy.mfr.api.knowledge.client.EntryPageCrucible;
import minefantasy.mfr.api.knowledge.client.EntryPageGrind;
import minefantasy.mfr.api.knowledge.client.EntryPageImage;
import minefantasy.mfr.api.knowledge.client.EntryPageRecipeAnvil;
import minefantasy.mfr.api.knowledge.client.EntryPageRecipeBase;
import minefantasy.mfr.api.knowledge.client.EntryPageRecipeBloom;
import minefantasy.mfr.api.knowledge.client.EntryPageRecipeCarpenter;
import minefantasy.mfr.api.knowledge.client.EntryPageSmelting;
import minefantasy.mfr.api.knowledge.client.EntryPageText;
import minefantasy.mfr.config.ConfigHardcore;
import minefantasy.mfr.init.ComponentListMFR;
import minefantasy.mfr.init.FoodListMFR;
import minefantasy.mfr.init.KnowledgeListMFR;
import minefantasy.mfr.init.MineFantasyBlocks;
import minefantasy.mfr.recipe.ForgingRecipes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KnowledgePageRegistry {
    public static void registerPages() {
        ItemStack pig_iron = ComponentListMFR.bar("pig_iron");
        ItemStack black = ComponentListMFR.bar("black_steel");
        ItemStack red = ComponentListMFR.bar("red_steel");
        ItemStack blue = ComponentListMFR.bar("blue_steel");
        if (ConfigHardcore.HCCallowRocks) {
            KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.hcc"),
                    new EntryPageRecipeBase(KnowledgeListMFR.CARPENTER_RECIPE),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.dirtRockR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.stonePickR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneHammerR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.sharpRocksR));
            KnowledgeListMFR.gettingStarted.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneSpearR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneAxeR));
        }
        KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.1"),
                new EntryPageText("knowledge.gettingStarted.2"));

        KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.carpenter"),
                new EntryPageRecipeBase(KnowledgeListMFR.CARPENTER_RECIPE));
        KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.fire"),
                new EntryPageRecipeBase(KnowledgeListMFR.FIREPIT_RECIPE),
                new EntryPageRecipeBase(KnowledgeListMFR.DRYROCKS_RECIPE));
        KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.food"),
                new EntryPageRecipeBase(KnowledgeListMFR.STOVE_RECIPE),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneovenRecipe));
        KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.tanning"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.tannerRecipe),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneKnifeR));
        KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.forging"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneAnvilRecipe),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.forgeRecipe),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneHammerR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneTongsR),
                new EntryPageRecipeBase(KnowledgeListMFR.DRYROCKS_RECIPE),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.apronRecipe));
        KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.forgingbars"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.barR));
        KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.flux"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.fluxR));
        KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.3"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.shearsR), new EntryPageText("knowledge.gettingStarted.4"),
                new EntryPageText("knowledge.gettingStarted.5"), new EntryPageRecipeAnvil(KnowledgeListMFR.hammerR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.tongsR), new EntryPageText("knowledge.gettingStarted.6"));
        KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.upgrade"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.researchTableRecipe),
                new EntryPageText("knowledge.gettingStarted.7"));
        KnowledgeListMFR.gettingStarted.addPages(new EntryPageText("knowledge.gettingStarted.10"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.potRecipe),
                new EntryPageSmelting(ComponentListMFR.CLAY_POT_UNCOOKED, ComponentListMFR.CLAY_POT),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.quernR), new EntryPageText("knowledge.gettingStarted.11"),
                new EntryPageText("knowledge.gettingStarted.12"));
        KnowledgeListMFR.gettingStarted.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.bSalvageR),
                new EntryPageText("knowledge.gettingStarted.13"));

        KnowledgeListMFR.research.addPages(new EntryPageText("knowledge.research.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.researchTableRecipe),
                new EntryPageText("knowledge.research.2"));

        //IDKH to make it look not ugly without significant code changes
        KnowledgeListMFR.talisman.addPages(new EntryPageText("knowledge.talisman.1"));
        if (!ConfigHardcore.HCCRemoveTalismansCraft) {
            KnowledgeListMFR.talisman.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.talismanRecipe));
        }
        if (!ConfigHardcore.HCCRemoveBooksCraft) {
            KnowledgeListMFR.talisman.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.artBookR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.conBookR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.proBookR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.engBookR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.comBookR));
        }
        KnowledgeListMFR.talisman.addPages(
                new EntryPageText("knowledge.talisman.2"));
        if (!ConfigHardcore.HCCRemoveTalismansCraft) {
            KnowledgeListMFR.talisman.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.greatTalismanRecipe));
        }
        if (!ConfigHardcore.HCCRemoveBooksCraft) {
            KnowledgeListMFR.talisman.addPages(
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.artBook2R),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.conBook2R),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.proBook2R),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.engBook2R),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.comBook2R));
        }

        KnowledgeListMFR.stamina.addPages(new EntryPageText("knowledge.stamina.1"));
        KnowledgeListMFR.combat.addPages(new EntryPageText("knowledge.combat.1"),
                new EntryPageText("knowledge.parry.info"), new EntryPageText("knowledge.advparry.info"),
                new EntryPageText("knowledge.poweratt.info"), new EntryPageText("knowledge.dodge.info"),
                new EntryPageText("knowledge.armour.info"));
        KnowledgeListMFR.craftArmourBasic.addPages(new EntryPageText("knowledge.craftArmourBasic.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.hideHelmR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.hideChestR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.hideLegsR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.hideBootsR));
        KnowledgeListMFR.craftArmourBasic.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.roughHelmetR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.roughChestR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.roughLegsR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.roughBootsR));

        KnowledgeListMFR.carpenter.addPages(new EntryPageText("knowledge.carpenter.1"),
                new EntryPageRecipeBase(KnowledgeListMFR.CARPENTER_RECIPE));
        KnowledgeListMFR.salvage.addPages(new EntryPageText("knowledge.salvage.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bSalvageR), new EntryPageText("knowledge.salvage.2"));

        KnowledgeListMFR.commodities.addPages(new EntryPageText("knowledge.commodities.1"));
        KnowledgeListMFR.commodities.addPages(new EntryPageText("knowledge.commodities.plank"),
                new EntryPageRecipeBase(KnowledgeListMFR.PLANK_RECIPE),
                new EntryPageRecipeBase(KnowledgeListMFR.STICK_RECIPE));
        KnowledgeListMFR.commodities.addPages(new EntryPageText("knowledge.commodities.refinedplank"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.jugRecipe),
                new EntryPageSmelting(FoodListMFR.JUG_UNCOOKED, FoodListMFR.JUG_EMPTY),
                new EntryPageRecipeBase(KnowledgeListMFR.plantOilR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.refinedPlankR));
        KnowledgeListMFR.commodities.addPages(new EntryPageText("knowledge.commodities.flux"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.fluxR));
        KnowledgeListMFR.commodities.addPages(new EntryPageText("knowledge.bar.1"));
        KnowledgeListMFR.commodities.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.barR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.baringotR));

        KnowledgeListMFR.commodities.addPages(new EntryPageText("knowledge.commodities.hunks"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.hunkR), new EntryPageRecipeAnvil(KnowledgeListMFR.ingotR));
        KnowledgeListMFR.commodities.addPages(new EntryPageText("knowledge.commodities.nail"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.nailR));
        KnowledgeListMFR.commodities.addPages(new EntryPageText("knowledge.commodities.rivet"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.rivetR));
        KnowledgeListMFR.commodities.addPages(new EntryPageText("knowledge.commodities.leatherstrip"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.lStripsR));
        KnowledgeListMFR.commodities.addPages(new EntryPageText("knowledge.commodities.thread"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.threadR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.stringR));
        KnowledgeListMFR.commodities.addPages(new EntryPageText("knowledge.commodities.bucket"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.bucketR));

        KnowledgeListMFR.dust.addPages(new EntryPageText("knowledge.dust.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.potRecipe),
                new EntryPageSmelting(ComponentListMFR.CLAY_POT_UNCOOKED, ComponentListMFR.CLAY_POT),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.quernR), new EntryPageText("knowledge.dust.quern"));
        KnowledgeListMFR.dust.addPages(
                new EntryPageGrind(new ItemStack(Items.COAL), new ItemStack(ComponentListMFR.COAL_DUST)),
                new EntryPageGrind(new ItemStack(ComponentListMFR.KAOLINITE),
                        new ItemStack(ComponentListMFR.KAOLINITE_DUST)),
                new EntryPageGrind(new ItemStack(Items.WHEAT), new ItemStack(FoodListMFR.FLOUR)),
                new EntryPageGrind(new ItemStack(Items.DYE, 1, 3), new ItemStack(FoodListMFR.COCA_POWDER)));
        KnowledgeListMFR.dust.addPages(new EntryPageText("knowledge.dust.icing"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.spoonR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.icingRecipe));

        KnowledgeListMFR.ores.addPages(new EntryPageText("knowledge.ores.1"), new EntryPageText(""));
        KnowledgeListMFR.ores.addPages(assembleOreDescHC("copper", MineFantasyBlocks.COPPER_ORE, ComponentListMFR.COPPER_INGOT));
        KnowledgeListMFR.ores.addPages(assembleOreDescHC("tin", MineFantasyBlocks.TIN_ORE, ComponentListMFR.TIN_INGOT));
        KnowledgeListMFR.ores.addPages(assembleOreDescHC("silver", MineFantasyBlocks.SILVER_ORE, ComponentListMFR.SILVER_INGOT));
        KnowledgeListMFR.ores.addPages(assembleOreDesc("wolframite", MineFantasyBlocks.TUNGSTEN_ORE));
        KnowledgeListMFR.ores.addPages(new EntryPageCrucible(KnowledgeListMFR.wolframiteR));
        KnowledgeListMFR.ores.addPages(assembleOreDesc("mythic", MineFantasyBlocks.MYTHIC_ORE));
        KnowledgeListMFR.ores.addPages(new EntryPageText("knowledge.ores.2"));
        KnowledgeListMFR.ores.addPages(assembleMineralDesc("clay", MineFantasyBlocks.CLAY_ORE));
        KnowledgeListMFR.ores.addPages(assembleMineralDesc("kaolinite", MineFantasyBlocks.KAOLINITE_ORE));
        KnowledgeListMFR.ores.addPages(assembleMineralDesc("limestone", MineFantasyBlocks.LIMESTONE));
        KnowledgeListMFR.ores.addPages(assembleMineralDesc("borax", MineFantasyBlocks.BORAX_ORE));
        KnowledgeListMFR.ores.addPages(assembleMineralDesc("nitre", MineFantasyBlocks.NITRE_ORE));
        KnowledgeListMFR.ores.addPages(assembleMineralDesc("sulfur", MineFantasyBlocks.SULFUR_ORE));

        KnowledgeListMFR.plants.addPages(new EntryPageText("knowledge.plants.1"));
        KnowledgeListMFR.plants.addPages(assembleImgPage("berry", MineFantasyBlocks.BERRY_BUSH));
        KnowledgeListMFR.plants.addPages(new EntryPageText("knowledge.plants.2"));
        KnowledgeListMFR.plants.addPages(assembleImgPage("yew", MineFantasyBlocks.LOG_YEW));
        KnowledgeListMFR.plants.addPages(assembleImgPage("ironbark", MineFantasyBlocks.LOG_IRONBARK));
        KnowledgeListMFR.plants.addPages(assembleImgPage("ebony", MineFantasyBlocks.LOG_EBONY));

        KnowledgeListMFR.minotaurs.addPages(new EntryPageText("knowledge.minotaurs.1"),
                new EntryPageText("knowledge.minotaurs.2"), new EntryPageText("knowledge.minotaurs.3"),
                new EntryPageText("knowledge.minotaurs.4"));
        KnowledgeListMFR.minotaurs.addPages(assembleMobDesc("minotaur"));
        KnowledgeListMFR.minotaurs.addPages(assembleMobDesc("minotaur_frost"));
        KnowledgeListMFR.minotaurs.addPages(assembleMobDesc("minotaur_dread"));
        KnowledgeListMFR.minotaurs.addPages(new EntryPageText("knowledge.minotaurs.combat"));

        KnowledgeListMFR.dragons.addPages(new EntryPageText("knowledge.dragons.1"),
                new EntryPageText("knowledge.dragons.2"));
        KnowledgeListMFR.dragons.addPages(assembleMobDesc("red_dragon"));
        KnowledgeListMFR.dragons.addPages(assembleMobDesc("blue_dragon"));
        KnowledgeListMFR.dragons.addPages(assembleMobDesc("green_dragon"));
        KnowledgeListMFR.dragons.addPages(assembleMobDesc("ash_dragon"));
        KnowledgeListMFR.dragons.addPages(new EntryPageText("knowledge.dragons.combat"));

        KnowledgeListMFR.chimney.addPages(new EntryPageText("knowledge.chimney.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.chimneyRecipe), new EntryPageText("knowledge.chimney.2"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.wideChimneyRecipe),
                new EntryPageText("knowledge.chimney.3"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.extractChimneyRecipe));
        KnowledgeListMFR.chimney.addPages(new EntryPageText("knowledge.chimney.pipe"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.smokePipeR));
        KnowledgeListMFR.chimney.addPages(assembleSimpleImgPage("smoke_pipe_example", "knowledge.chimney.pipe.2"));

        KnowledgeListMFR.tanning.addPages(new EntryPageText("knowledge.tanning.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.tannerRecipe), new EntryPageText("knowledge.tanning.2"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.strongRackR));

        KnowledgeListMFR.bloomery.addPages(new EntryPageText("knowledge.bloomery.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bloomeryR), new EntryPageText("knowledge.bloomery.2"),
                new EntryPageText("knowledge.bloomery.3"));
        KnowledgeListMFR.crucible.addPages(assembleSimpleImgPage("crucible_example", "knowledge.crucible.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crucibleRecipe),
                new EntryPageText("knowledge.crucible.2"));
        if (ConfigHardcore.HCCreduceIngots) {
            KnowledgeListMFR.crucible.addPages(new EntryPageText("knowledge.crucible.hcc"),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.mouldRecipe),
                    new EntryPageSmelting(ComponentListMFR.INGOT_MOULD_UNCOOKED, ComponentListMFR.INGOT_MOULD));
        }
        KnowledgeListMFR.crucible2.addPages(assembleSimpleImgPage("fire_crucible_example", "knowledge.crucible2.1"),
                new EntryPageGrind(new ItemStack(ComponentListMFR.KAOLINITE),
                        new ItemStack(ComponentListMFR.KAOLINITE_DUST)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fireclayR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.advCrucibleRecipe),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fireBricksR),
                assembleSimpleImgPage("fire_crucible", "knowledge.crucible2.blocks"));

        KnowledgeListMFR.bar.addPages(new EntryPageText("knowledge.bar.1"));
        KnowledgeListMFR.bar.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.barR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.baringotR));
        KnowledgeListMFR.smeltCopper.addPages(new EntryPageText("knowledge.smeltCopper.1"));
        KnowledgeListMFR.smeltBronze.addPages(new EntryPageText("knowledge.smeltBronze.1"));
        if (ConfigHardcore.HCCreduceIngots) {
            KnowledgeListMFR.smeltIron.addPages(new EntryPageText("knowledge.smeltIron.1"));
            KnowledgeListMFR.smeltCopper.addPages(new EntryPageRecipeBloom(new ItemStack(MineFantasyBlocks.COPPER_ORE),
                    new ItemStack(ComponentListMFR.COPPER_INGOT)));
            KnowledgeListMFR.smeltBronze.addPages(new EntryPageRecipeBloom(new ItemStack(MineFantasyBlocks.TIN_ORE),
                    new ItemStack(ComponentListMFR.TIN_INGOT)));
        } else {
            KnowledgeListMFR.smeltCopper.addPages(new EntryPageSmelting(new ItemStack(MineFantasyBlocks.COPPER_ORE),
                    new ItemStack(ComponentListMFR.COPPER_INGOT)));
            KnowledgeListMFR.smeltBronze.addPages(
                    new EntryPageSmelting(new ItemStack(MineFantasyBlocks.TIN_ORE), new ItemStack(ComponentListMFR.TIN_INGOT)));
        }
        KnowledgeListMFR.smeltBronze.addPages(new EntryPageCrucible(KnowledgeListMFR.bronze));
        KnowledgeListMFR.smeltIron.addPages(new EntryPageText("knowledge.smeltIron.2"));
        KnowledgeListMFR.smeltPig.addPages(new EntryPageText("knowledge.smeltPig.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.ironPrepR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.ironPrepR2),
                new EntryPageBlastFurnace(ComponentListMFR.IRON_PREP, pig_iron),
                new EntryPageText("knowledge.blastfurn.9"));
        KnowledgeListMFR.smeltSteel.addPages(new EntryPageText("knowledge.smeltSteel.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.steelR));
        if (!ConfigHardcore.HCCreduceIngots) {
            KnowledgeListMFR.smeltSteel.addPages(new EntryPageCrucible(KnowledgeListMFR.steel));
        }
        KnowledgeListMFR.encrusted.addPages(new EntryPageText("knowledge.smeltEncrusted.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.diamondR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.encrustedR));
        KnowledgeListMFR.obsidian.addPages(new EntryPageText("knowledge.smeltObsidian.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.obsidianHunkR),
                new EntryPageCrucible(KnowledgeListMFR.obsidalloy));

        if (ConfigHardcore.HCCreduceIngots) {
            KnowledgeListMFR.smeltIron.addPages(
                    new EntryPageRecipeBloom(new ItemStack(Blocks.IRON_ORE), new ItemStack(Items.IRON_INGOT)));
        } else {
            KnowledgeListMFR.smeltIron
                    .addPages(new EntryPageSmelting(new ItemStack(Blocks.IRON_ORE), new ItemStack(Items.IRON_INGOT)));
        }

        KnowledgeListMFR.apron.addPages(new EntryPageText("knowledge.apron.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.apronRecipe));
        KnowledgeListMFR.bellows.addPages(new EntryPageText("knowledge.bellows.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bellowsRecipe));
        KnowledgeListMFR.trough.addPages(new EntryPageText("knowledge.trough.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.woodTroughRecipe), new EntryPageText("knowledge.trough.2"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.nailTroughR));
        KnowledgeListMFR.forge.addPages(assembleSimpleImgPage("forge_example", "knowledge.forge.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.forgeRecipe), new EntryPageText("knowledge.forge.2"),
                new EntryPageText("knowledge.forge.3"));
        KnowledgeListMFR.anvil.addPages(assembleSimpleImgPage("smithy_example", "knowledge.anvil.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneAnvilRecipe),
                new EntryPageRecipeAnvil(ForgingRecipes.recipeMap.get("anvilCrafting")),
                new EntryPageText("knowledge.anvil.2"),
                new EntryPageImage("textures/gui/knowledge/anvil_gui_example.png", 128, 128, ""),
                new EntryPageText("knowledge.anvil.3"), new EntryPageText("knowledge.anvil.4"),
                new EntryPageText("knowledge.anvil.5"));
        KnowledgeListMFR.anvil.addPages(new EntryPageText("knowledge.anvil.6"),
                new EntryPageImage("textures/gui/knowledge/quality_example.png", 128, 128, "knowledge.anvil.7"));

        KnowledgeListMFR.smeltDragonforge.addPages(new EntryPageText("knowledge.smeltDragonforge.1"),
                new EntryPageText("knowledge.smeltDragonforge.2"));
        KnowledgeListMFR.craftOrnate.addPages(new EntryPageText("knowledge.craftOrnate.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.crestR));

        KnowledgeListMFR.craftArmourLight.addPages(new EntryPageText("knowledge.craftArmourLight.1"),
                new EntryPageText("knowledge.craftArmourLight.2"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.roughHelmetR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.roughChestR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.roughLegsR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.roughBootsR));
        KnowledgeListMFR.craftArmourLight.addPages(new EntryPageText("knowledge.craftArmourLight.3"));
        KnowledgeListMFR.craftArmourLight.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.padding[0]),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.padding[1]),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.padding[2]),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.padding[3]));
        KnowledgeListMFR.craftArmourLight.addPages(new EntryPageText("knowledge.craftArmourLight.4"));
        KnowledgeListMFR.craftArmourLight.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.reHelmetR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.reChestR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.reLegsR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.reBootsR));
        KnowledgeListMFR.craftArmourLight.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.studHelmetR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.studChestR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.studLegsR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.studBootsR));
        KnowledgeListMFR.craftArmourMedium.addPages(new EntryPageText("knowledge.craftArmourMedium.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.mailRecipes),
                new EntryPageRecipeAnvil(KnowledgeListMFR.mailHelmetR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.mailChestR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.mailLegsR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.mailBootsR));
        KnowledgeListMFR.craftArmourMedium.addPages(new EntryPageText("knowledge.craftArmourMedium.scale"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.scaleRecipes),
                new EntryPageRecipeAnvil(KnowledgeListMFR.scaleHelmetR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.scaleChestR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.scaleLegsR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.scaleBootsR));
        KnowledgeListMFR.craftArmourHeavy.addPages(new EntryPageText("knowledge.craftArmourHeavy.1"),
                new EntryPageText("knowledge.craftArmourHeavy.2"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.padding));
        KnowledgeListMFR.craftArmourHeavy.addPages(new EntryPageText("knowledge.craftArmourHeavy.splint"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.splintRecipes),
                new EntryPageRecipeAnvil(KnowledgeListMFR.splintHelmetR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.splintChestR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.splintLegsR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.splintBootsR));
        KnowledgeListMFR.craftArmourHeavy.addPages(new EntryPageText("knowledge.craftArmourHeavy.plate"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.plateRecipes),
                new EntryPageRecipeAnvil(KnowledgeListMFR.plateHelmetR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.plateChestR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.plateLegsR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.plateBootsR));

        KnowledgeListMFR.coalflux.addPages(new EntryPageText("knowledge.coalflux.1"),
                new EntryPageGrind(new ItemStack(ComponentListMFR.FLUX), new ItemStack(ComponentListMFR.FLUX_POT)),
                new EntryPageRecipeAnvil(KnowledgeListMFR.coalfluxR));

        KnowledgeListMFR.bigfurn.addPages(assembleSimpleImgPage("furnace_example", "knowledge.bigfurn.1"),
                new EntryPageText("knowledge.bigfurn.2"));
        KnowledgeListMFR.bigfurn.addPages(
                new EntryPageGrind(new ItemStack(ComponentListMFR.KAOLINITE),
                        new ItemStack(ComponentListMFR.KAOLINITE_DUST)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fireclayR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fireBrickR),
                new EntryPageSmelting(new ItemStack(ComponentListMFR.FIRECLAY_BRICK),
                        new ItemStack(ComponentListMFR.STRONG_BRICK)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fireBricksR));
        KnowledgeListMFR.bigfurn.addPages(new EntryPageText("knowledge.bigfurn.heater"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.bigHeatR),
                assembleSimpleImgPage("furnace_heater", MineFantasyBlocks.FURNACE_HEATER.getUnlocalizedName() + ".name"));
        KnowledgeListMFR.bigfurn.addPages(new EntryPageText("knowledge.bigfurn.top"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.bigFurnR),
                assembleSimpleImgPage("furnace_full", "knowledge.bigfurn.structure"));

        KnowledgeListMFR.blastfurn.addPages(new EntryPageText("knowledge.blastfurn.1"),
                new EntryPageText("knowledge.blastfurn.2"));
        KnowledgeListMFR.blastfurn.addPages(
                new EntryPageGrind(new ItemStack(ComponentListMFR.KAOLINITE),
                        new ItemStack(ComponentListMFR.KAOLINITE_DUST)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fireclayR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fireBrickR),
                new EntryPageSmelting(new ItemStack(ComponentListMFR.FIRECLAY_BRICK),
                        new ItemStack(ComponentListMFR.STRONG_BRICK)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fireBricksR));
        KnowledgeListMFR.blastfurn.addPages(new EntryPageText("knowledge.blastfurn.3"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.blastChamR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.blastHeatR), new EntryPageText("knowledge.blastfurn.4"),
                new EntryPageText("knowledge.blastfurn.5"));
        KnowledgeListMFR.blastfurn.addPages(
                new EntryPageImage("textures/gui/knowledge/blast_example.png", 96, 96, "knowledge.blastfurn.6"));
        KnowledgeListMFR.blastfurn.addPages(new EntryPageText("knowledge.blastfurn.7"));
        if (ConfigHardcore.HCCreduceIngots) {
            KnowledgeListMFR.blastfurn.addPages(new EntryPageText("knowledge.blastfurn.hcc"));
        }

        KnowledgeListMFR.etools.addPages(new EntryPageText("knowledge.etools.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.spannerR), new EntryPageRecipeAnvil(KnowledgeListMFR.eatoolsR));
        KnowledgeListMFR.ecomponents.addPages(new EntryPageText("knowledge.ecomponents.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.boltR), new EntryPageText("knowledge.ecomponents.2"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.iframeR), new EntryPageRecipeAnvil(KnowledgeListMFR.bgearR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.tgearR), new EntryPageRecipeAnvil(KnowledgeListMFR.istrutR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.stubeR));
        KnowledgeListMFR.tungsten.addPages(new EntryPageText("knowledge.tungsten.1"),
                new EntryPageText("knowledge.tungsten.2"), new EntryPageText("knowledge.tungsten.3"),
                new EntryPageCrucible(KnowledgeListMFR.wolframiteR));
        KnowledgeListMFR.climber.addPages(new EntryPageText("knowledge.climber.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.climbPickbR), new EntryPageText("knowledge.climber.2"));
        KnowledgeListMFR.spyglass.addPages(new EntryPageText("knowledge.spyglass.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.spyglassR));
        KnowledgeListMFR.parachute.addPages(new EntryPageText("knowledge.parachute.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.parachuteR));
        KnowledgeListMFR.syringe.addPages(new EntryPageText("knowledge.syringe.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.syringeR));
        KnowledgeListMFR.engTanner.addPages(new EntryPageText("knowledge.engTanner.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.engTannerR));
        KnowledgeListMFR.advcrucible.addPages(
                assembleSimpleImgPage("auto_crucible_example", MineFantasyBlocks.CRUCIBLE_AUTO.getUnlocalizedName() + ".name"),
                new EntryPageText("knowledge.advcrucible.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.autoCrucibleR),
                new EntryPageText("knowledge.crucible2.blocks"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fireBricksR),
                assembleSimpleImgPage("auto_crucible", "knowledge.basicstructure"));
        KnowledgeListMFR.advforge.addPages(new EntryPageText("knowledge.advforge.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.advancedForgeR));
        KnowledgeListMFR.coke.addPages(new EntryPageText("knowledge.coke.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.coalPrepR),
                new EntryPageSmelting(ComponentListMFR.COAL_PREP, ComponentListMFR.COKE));

        KnowledgeListMFR.blackpowder.addPages(new EntryPageText("knowledge.blackpowder.1"),
                new EntryPageGrind(new ItemStack(Items.COAL), new ItemStack(ComponentListMFR.COAL_DUST)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.blackpowderRec),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crudeBombR));
        KnowledgeListMFR.advblackpowder.addPages(new EntryPageText("knowledge.advblackpowder.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.advblackpowderRec));
        KnowledgeListMFR.bombs.addPages(new EntryPageText("knowledge.bombs.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bombBenchCraft), new EntryPageText("knowledge.bombs.2"),
                new EntryPageImage("textures/gui/knowledge/bomb_gui_example.png", 128, 128, "knowledge.guiSubtitle"),
                new EntryPageText("knowledge.bombs.3"), new EntryPageText("knowledge.bombs.4"));
        KnowledgeListMFR.bpress.addPages(new EntryPageText("knowledge.bpress.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bombPressCraft));
        KnowledgeListMFR.bombarrow.addPages(new EntryPageText("knowledge.bombarrow.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.bombarrowR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.bombBoltR));
        KnowledgeListMFR.shrapnel.addPages(new EntryPageText("knowledge.shrapnel.1"),
                new EntryPageGrind(new ItemStack(Items.FLINT), new ItemStack(ComponentListMFR.SHRAPNEL)));
        KnowledgeListMFR.firebomb.addPages(new EntryPageText("knowledge.firebomb.1"),
                new EntryPageText("knowledge.firebomb.2"), new EntryPageText("knowledge.firebomb.3"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.magmaRefinedR));
        KnowledgeListMFR.bombCeramic.addPages(new EntryPageText("knowledge.bombCeramic.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bombCaseCeramicR),
                new EntryPageSmelting(ComponentListMFR.BOMB_CASING_UNCOOKED, ComponentListMFR.BOMB_CASING));
        KnowledgeListMFR.bombIron.addPages(new EntryPageText("knowledge.bombIron.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.bombCaseIronR));
        KnowledgeListMFR.bombObsidian.addPages(new EntryPageText("knowledge.bombObsidian.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.bombCaseObsidianR));
        KnowledgeListMFR.bombCrystal.addPages(new EntryPageText("knowledge.bombCrystal.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bombCaseCrystalR));

        KnowledgeListMFR.mineCeramic.addPages(new EntryPageText("knowledge.mineCeramic.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.mineCaseCeramicR),
                new EntryPageSmelting(ComponentListMFR.MINE_CASING_UNCOOKED, ComponentListMFR.MINE_CASING));
        KnowledgeListMFR.mineIron.addPages(new EntryPageText("knowledge.mineIron.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.mineCaseIronR));
        KnowledgeListMFR.mineObsidian.addPages(new EntryPageText("knowledge.mineObsidian.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.mineCaseObsidianR));
        KnowledgeListMFR.mineCrystal.addPages(new EntryPageText("knowledge.mineCrystal.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.mineCaseCrystalR));
        KnowledgeListMFR.bombFuse.addPages(new EntryPageText("knowledge.bombFuse.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bombFuseR), new EntryPageText("knowledge.bombFuse.2"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.longFuseR));
        KnowledgeListMFR.stickybomb.addPages(new EntryPageText("knowledge.stickybomb.1"),
                new EntryPageText("knowledge.stickybomb.2"));

        KnowledgeListMFR.crossbows.addPages(new EntryPageText("knowledge.crossbows.1"),
                new EntryPageText("knowledge.crossbows.2"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crossBenchCraft),
                new EntryPageText("knowledge.crossbows.3"), new EntryPageText("knowledge.crossbows.4"),
                new EntryPageText("knowledge.crossbows.5"), new EntryPageText("knowledge.crossbows.6"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.crossBoltR));
        KnowledgeListMFR.crossShafts.addPages(new EntryPageText("knowledge.crossShafts.handle"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crossHandleWoodR),
                new EntryPageText("knowledge.crossShafts.stock"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crossStockWoodR));
        KnowledgeListMFR.crossHeads.addPages(new EntryPageText("knowledge.crossHeads.light"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crossHeadLightR),
                new EntryPageText("knowledge.crossHeads.medium"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crossHeadMediumR),
                new EntryPageText("knowledge.crossHeads.heavy"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crossHeadHeavyR));
        KnowledgeListMFR.crossHeadAdvanced.addPages(new EntryPageText("knowledge.crossHeads.advanced"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crossHeadAdvancedR));
        KnowledgeListMFR.crossShaftAdvanced.addPages(new EntryPageText("knowledge.crossShafts.advanced"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crossStockIronR));
        KnowledgeListMFR.crossScope.addPages(new EntryPageText("knowledge.crossScope.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crossScopeR));
        KnowledgeListMFR.crossAmmo.addPages(new EntryPageText("knowledge.crossAmmo.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.crossAmmoR));
        KnowledgeListMFR.crossBayonet.addPages(new EntryPageText("knowledge.crossBayonet.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.crossBayonetR));

        KnowledgeListMFR.cogArmour.addPages(new EntryPageText("knowledge.cogArmour.1"),
                new EntryPageText("knowledge.cogArmour.2"));
        KnowledgeListMFR.cogArmour.addPages(new EntryPageText("knowledge.cogArmour.station"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.frameBlockR),
                assembleSimpleImgPage("cogwork_station", "knowledge.cogwork_station"));
        // EXAMPLE
        KnowledgeListMFR.cogArmour.addPages(new EntryPageText("knowledge.cogArmour.station.2"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.cogPulleyR),
                assembleSimpleImgPage("cogwork_station_2", "knowledge.rightclickspanner"));

        // RECIPE
        KnowledgeListMFR.cogArmour.addPages(new EntryPageText("knowledge.cogArmour.crafting"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.cogShaftR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.cogHelmR), new EntryPageRecipeAnvil(KnowledgeListMFR.cogChestR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.cogLegsR),
                assembleSimpleImgPage("cogwork_suit_craft", "knowledge.rightclickspanner"));

        KnowledgeListMFR.cogArmour.addPages(new EntryPageText("knowledge.cogArmour.armour"));
        KnowledgeListMFR.cogArmour.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.hugePlateR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.cogPlateR));

        KnowledgeListMFR.cogArmour.addPages(new EntryPageText("knowledge.cogArmour.advantage"),
                new EntryPageText("knowledge.cogArmour.advantage.2"),
                new EntryPageText("knowledge.cogArmour.advantage.3"));
        KnowledgeListMFR.cogArmour.addPages(new EntryPageText("knowledge.cogArmour.disadvantage"),
                new EntryPageText("knowledge.cogArmour.disadvantage.2"));
        KnowledgeListMFR.cogArmour.addPages(new EntryPageText("knowledge.cogArmour.removal"));

        KnowledgeListMFR.compPlate.addPages(new EntryPageText("knowledge.compPlate.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.compPlateR));
        // KnowledgeListMFR.craftOrnateWeapons.addPages(new
        // EntryPageText("knowledge.craftOrnateWeapons.1"));

        KnowledgeListMFR.repair_basic.addPages(new EntryPageText("knowledge.repair_basic.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.repairBasicR));
        KnowledgeListMFR.repair_advanced.addPages(new EntryPageText("knowledge.repair_advanced.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.repairAdvancedR));
        KnowledgeListMFR.repair_ornate.addPages(new EntryPageText("knowledge.repair_ornate.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.repairOrnateR));

        KnowledgeListMFR.refined_planks.addPages(new EntryPageText("knowledge.refined_planks.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.nailPlanksR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.refinedPlankBlockR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.nailStairR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.refinedStairR));
        KnowledgeListMFR.reinforced_stone.addPages(new EntryPageText("knowledge.reinforced_stone.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.obsidianHunkR),
                new EntryPageCrucible(KnowledgeListMFR.reStone));
        KnowledgeListMFR.brickworks.addPages(new EntryPageText("knowledge.brickworks.1"),
                new EntryPageRecipeBase(KnowledgeListMFR.stoneBricksR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fireBricksR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fireBrickStairR));
        KnowledgeListMFR.clay_wall.addPages(new EntryPageText("knowledge.clay_wall.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.clayWallR));
        KnowledgeListMFR.glass.addPages(new EntryPageText("knowledge.glass.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.framedGlassR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.windowR));
        KnowledgeListMFR.thatch.addPages(new EntryPageText("knowledge.thatch.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.thatchR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.thatchStairR));
        KnowledgeListMFR.bars.addPages(new EntryPageText("knowledge.bars.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.barsR));
//        KnowledgeListMFR.paint_brush.addPages(new EntryPageText("knowledge.paint_brush.1"),
//                new EntryPageRecipeAnvil(KnowledgeListMFR.brushRecipe),
//                new EntryPageRecipeCarpenter(KnowledgeListMFR.easyPaintPlank));
        KnowledgeListMFR.decorated_stone.addPages(new EntryPageText("knowledge.decorated_stone.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.framedStoneR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.iframedStoneR));

//        KnowledgeListMFR.bed_roll.addPages(new EntryPageText("knowledge.bed_roll.1"),
//                new EntryPageRecipeCarpenter(KnowledgeListMFR.bedrollR));
        KnowledgeListMFR.tool_rack.addPages(new EntryPageText("knowledge.tool_rack.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.rackRecipe),
                new EntryPageText("knowledge.tool_rack.rules"));
        KnowledgeListMFR.food_box.addPages(new EntryPageText("knowledge.food_box.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.foodboxR), new EntryPageText("knowledge.ammo_box.2"));
        KnowledgeListMFR.ammo_box.addPages(new EntryPageText("knowledge.ammo_box.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.ammoboxR), new EntryPageText("knowledge.ammo_box.2"));
        KnowledgeListMFR.big_box.addPages(new EntryPageText("knowledge.big_box.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bigboxR), new EntryPageText("knowledge.ammo_box.2"));

        KnowledgeListMFR.constructionPts.addPages(new EntryPageText("knowledge.constructionPts.1"));
        KnowledgeListMFR.constructionPts.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.sawnPlankR));
        KnowledgeListMFR.constructionPts.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.plankPaneR));
        KnowledgeListMFR.constructionPts.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.hingeRecipe));
        KnowledgeListMFR.constructionPts.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.jugRecipe),
                new EntryPageSmelting(FoodListMFR.JUG_UNCOOKED, FoodListMFR.JUG_EMPTY),
                new EntryPageRecipeBase(KnowledgeListMFR.plantOilR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.refinedPlankR));

        if (ConfigHardcore.HCCallowRocks) {
            KnowledgeListMFR.craftHCCTools.addPages(new EntryPageText("knowledge.craftHCCTools.1"),
                    new EntryPageText("knowledge.craftHCCTools.2"));
            KnowledgeListMFR.craftHCCTools.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.sharpRocksR),
                    new EntryPageText("knowledge.craftHCCTools.3"));
            KnowledgeListMFR.craftHCCTools.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.stonePickR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneSpadeR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneAxeR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneHoeR));
            KnowledgeListMFR.craftHCCTools.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneKnifeR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneHammerR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneTongsR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.boneNeedleR));
            KnowledgeListMFR.craftHCCTools.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneSwordR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneMaceR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneWarR),
                    new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneSpearR));
        }
        KnowledgeListMFR.craftTools.addPages(new EntryPageText("knowledge.craftTools.1"));
        KnowledgeListMFR.craftTools.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.pickR));
        KnowledgeListMFR.craftTools.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.axeR));
        KnowledgeListMFR.craftTools.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.spadeR));
        KnowledgeListMFR.craftTools.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.hoeR));
        KnowledgeListMFR.craftTools.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.shearsR));

        KnowledgeListMFR.craftAdvTools.addPages(new EntryPageText("knowledge.craftAdvTools.1"));
        KnowledgeListMFR.craftAdvTools.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.handpickR));
        KnowledgeListMFR.craftAdvTools.addPages(new EntryPageText("knowledge.hvypick.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.hvyPickR));
        KnowledgeListMFR.craftAdvTools.addPages(new EntryPageText("knowledge.trow.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.trowR));
        KnowledgeListMFR.craftAdvTools.addPages(new EntryPageText("knowledge.hvyshovel.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.hvyShovelR));
        KnowledgeListMFR.craftAdvTools.addPages(new EntryPageText("knowledge.scythe.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.scytheR));
        KnowledgeListMFR.craftAdvTools.addPages(new EntryPageText("knowledge.mattock.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.mattockR), new EntryPageText("knowledge.mattock.use"));
        KnowledgeListMFR.craftAdvTools.addPages(new EntryPageText("knowledge.lumber.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.lumberR));

        KnowledgeListMFR.firemaker.addPages(new EntryPageText("knowledge.dryrocks.info"),
                new EntryPageRecipeBase(KnowledgeListMFR.DRYROCKS_RECIPE));
        KnowledgeListMFR.firemaker.addPages(new EntryPageText("knowledge.tinderbox.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.tinderboxR));
        KnowledgeListMFR.firemaker.addPages(new EntryPageText("knowledge.flintsteel.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.flintAndSteelR));

        KnowledgeListMFR.craftCrafters.addPages(new EntryPageText("knowledge.craftCrafters.1"));
        KnowledgeListMFR.craftCrafters.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneHammerR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.hammerR), new EntryPageText(""));
        KnowledgeListMFR.craftCrafters.addPages(new EntryPageText("knowledge.hvyhammer.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.hvyHammerR));
        KnowledgeListMFR.craftCrafters.addPages(new EntryPageText("knowledge.tongs.info"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneTongsR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.tongsR), new EntryPageText(""));
        KnowledgeListMFR.craftCrafters.addPages(new EntryPageText("knowledge.knife.info"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneKnifeR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.knifeR), new EntryPageText(""));
        KnowledgeListMFR.craftCrafters.addPages(new EntryPageText("knowledge.saw.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.sawsR));
        KnowledgeListMFR.craftCrafters.addPages(new EntryPageText("knowledge.needle.info"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.boneNeedleR),
                new EntryPageRecipeAnvil(KnowledgeListMFR.needleR), new EntryPageText(""));
        KnowledgeListMFR.craftCrafters.addPages(new EntryPageText("knowledge.mallet.info"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.malletR));
        KnowledgeListMFR.craftCrafters.addPages(new EntryPageText("knowledge.spoon.info"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.spoonR));

        KnowledgeListMFR.craftWeapons.addPages(new EntryPageText("knowledge.craftWeapons.1"));
        KnowledgeListMFR.craftWeapons.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.daggerR));
        KnowledgeListMFR.craftWeapons.addPages(new EntryPageText("knowledge.sword.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.swordR));
        KnowledgeListMFR.craftWeapons.addPages(new EntryPageText("knowledge.waraxe.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.waraxeR));
        KnowledgeListMFR.craftWeapons.addPages(new EntryPageText("knowledge.mace.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.maceR));
        KnowledgeListMFR.craftWeapons.addPages(new EntryPageText("knowledge.spear.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.spearR));
        KnowledgeListMFR.craftWeapons.addPages(new EntryPageText("knowledge.bow.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.bowR));

        KnowledgeListMFR.craftAdvWeapons.addPages(new EntryPageText("knowledge.craftAdvWeapons.1"));
        KnowledgeListMFR.craftAdvWeapons.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.katanaR));
        KnowledgeListMFR.craftAdvWeapons.addPages(new EntryPageText("knowledge.greatsword.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.gswordR));
        KnowledgeListMFR.craftAdvWeapons.addPages(new EntryPageText("knowledge.battleaxe.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.battleaxeR));
        KnowledgeListMFR.craftAdvWeapons.addPages(new EntryPageText("knowledge.warhammer.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.whammerR));
        KnowledgeListMFR.craftAdvWeapons.addPages(new EntryPageText("knowledge.halbeard.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.halbeardR));
        KnowledgeListMFR.craftAdvWeapons.addPages(new EntryPageText("knowledge.lance.info"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.lanceR));

        KnowledgeListMFR.arrows.addPages(new EntryPageText("knowledge.arrows.1"));
        KnowledgeListMFR.arrows.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.fletchingR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.fletchingR2));
        KnowledgeListMFR.arrows.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.arrowheadR));
        KnowledgeListMFR.arrows.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.arrowR));
        KnowledgeListMFR.arrowsBodkin.addPages(new EntryPageText("knowledge.arrowsBodkin.1"));
        KnowledgeListMFR.arrowsBodkin.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.bodkinheadR));
        KnowledgeListMFR.arrowsBroad.addPages(new EntryPageText("knowledge.arrowsBroad.1"));
        KnowledgeListMFR.arrowsBroad.addPages(new EntryPageRecipeAnvil(KnowledgeListMFR.broadheadR));

        KnowledgeListMFR.smeltBlackSteel.addPages(new EntryPageText("knowledge.smeltBlackSteel.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.obsidianHunkR), new EntryPageCrucible(KnowledgeListMFR.black),
                new EntryPageBlastFurnace(ComponentListMFR.BLACK_STEEL_WEAK_INGOT, black));
        KnowledgeListMFR.smeltRedSteel.addPages(new EntryPageText("knowledge.smeltRedSteel.1"),
                new EntryPageCrucible(KnowledgeListMFR.red), new EntryPageBlastFurnace(ComponentListMFR.RED_STEEL_WEAK_INGOT, red));
        KnowledgeListMFR.smeltBlueSteel.addPages(new EntryPageText("knowledge.smeltBlueSteel.1"),
                new EntryPageCrucible(KnowledgeListMFR.blue),
                new EntryPageBlastFurnace(ComponentListMFR.BLUE_STEEL_WEAK_INGOT, blue));
        KnowledgeListMFR.smeltAdamant.addPages(new EntryPageText("knowledge.smeltAdamantium.1"),
                new EntryPageText("knowledge.smeltAdamantium.2"), new EntryPageCrucible(KnowledgeListMFR.adamantium));
        KnowledgeListMFR.smeltMithril.addPages(new EntryPageText("knowledge.smeltMithril.1"),
                new EntryPageText("knowledge.smeltMithril.2"), new EntryPageCrucible(KnowledgeListMFR.mithril));

        KnowledgeListMFR.smeltMaster.addPages(new EntryPageText("knowledge.smeltMaster.1"),
                new EntryPageText("knowledge.smeltMaster.2"), new EntryPageText("knowledge.smeltMaster.3"));
        KnowledgeListMFR.smeltMaster.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.trilogyRecipe));
        KnowledgeListMFR.smeltIgnotumite.addPages(new EntryPageText("knowledge.smeltIgnotumite.1"),
                new EntryPageCrucible(KnowledgeListMFR.ignotumite));
        KnowledgeListMFR.smeltMithium.addPages(new EntryPageText("knowledge.smeltMithium.1"),
                new EntryPageCrucible(KnowledgeListMFR.mithium));
        KnowledgeListMFR.smeltEnderforge.addPages(new EntryPageText("knowledge.smeltEnderforge.1"),
                new EntryPageCrucible(KnowledgeListMFR.enderforge));

        KnowledgeListMFR.firepit.addPages(new EntryPageText("knowledge.firepit.1"),
                new EntryPageRecipeBase(KnowledgeListMFR.FIREPIT_RECIPE));
        KnowledgeListMFR.firepit.addPages(new EntryPageText("knowledge.firepit.2"),
                new EntryPageRecipeBase(KnowledgeListMFR.STOVE_RECIPE));
        KnowledgeListMFR.firepit.addPages(new EntryPageText("knowledge.firepit.3"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.stoneovenRecipe));
        KnowledgeListMFR.firepit.addPages(new EntryPageText("knowledge.firepit.4"));

        KnowledgeListMFR.cookingutensil.addPages(new EntryPageText("knowledge.cookingutensil.1"),
                new EntryPageRecipeAnvil(KnowledgeListMFR.caketinRecipe),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.pieTrayRecipe),
                new EntryPageSmelting(ComponentListMFR.PIE_TRAY_UNCOOKED, FoodListMFR.PIE_TRAY));
        KnowledgeListMFR.salt.addPages(new EntryPageText("knowledge.salt.1"),
                new EntryPageSmelting(new ItemStack(FoodListMFR.BOWL_WATER_SALT), new ItemStack(FoodListMFR.SALT)));
        KnowledgeListMFR.jug.addPages(new EntryPageText("knowledge.jug.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.jugRecipe),
                new EntryPageSmelting(FoodListMFR.JUG_UNCOOKED, FoodListMFR.JUG_EMPTY),
                new EntryPageText("knowledge.jug.2"), new EntryPageRecipeBase(KnowledgeListMFR.waterJugR),
                new EntryPageRecipeBase(KnowledgeListMFR.milkJugR));

        KnowledgeListMFR.generic_meat.addPages(new EntryPageText("knowledge.generic_meat.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.meatRecipes),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.meatStripR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.meatHunkR),
                new EntryPageGrind(new ItemStack(FoodListMFR.GENERIC_MEAT_UNCOOKED),
                        new ItemStack(FoodListMFR.GENERIC_MEAT_MINCE_UNCOOKED)));
        KnowledgeListMFR.stew.addPages(new EntryPageText("knowledge.stew.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.stewRecipe));
        KnowledgeListMFR.jerky.addPages(new EntryPageText("knowledge.jerky.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.jerkyRecipe));
        KnowledgeListMFR.saussage.addPages(new EntryPageText("knowledge.saussage.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.gutsRecipe),
                new EntryPageGrind(new ItemStack(FoodListMFR.BREADROLL), new ItemStack(FoodListMFR.BREADCRUMBS)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.saussageR), new EntryPageSmelting(
                        new ItemStack(FoodListMFR.SAUSAGE_RAW), new ItemStack(FoodListMFR.SAUSAGE_COOKED)));
        KnowledgeListMFR.sandwitch.addPages(new EntryPageText("knowledge.sandwitch.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.breadSliceR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.sandwitchRecipe));
        KnowledgeListMFR.sandwitch_big.addPages(new EntryPageText("knowledge.sandwitch_big.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.sandwitchBigRecipe));
        KnowledgeListMFR.meatpie.addPages(new EntryPageText("knowledge.meatpie.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.meatPieRecipe),
                new EntryPageSmelting(new ItemStack(FoodListMFR.PIE_MEAT_UNCOOKED),
                        new ItemStack(FoodListMFR.PIE_MEAT_COOKED)),
                new EntryPageRecipeBase(KnowledgeListMFR.PIE_MEAT_RECIPE));
        KnowledgeListMFR.shepardpie.addPages(new EntryPageText("knowledge.shepardpie.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.shepardRecipe),
                new EntryPageSmelting(new ItemStack(FoodListMFR.PIE_SHEPARD_UNCOOKED),
                        new ItemStack(FoodListMFR.PIE_SHEPARD_COOKED)),
                new EntryPageRecipeBase(KnowledgeListMFR.PIE_SHEPARDS_RECIPE));

        KnowledgeListMFR.bread.addPages(new EntryPageText("knowledge.bread.1"),
                new EntryPageGrind(new ItemStack(Items.WHEAT), new ItemStack(FoodListMFR.FLOUR)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.doughRecipe),
                new EntryPageSmelting(new ItemStack(FoodListMFR.DOUGH), new ItemStack(FoodListMFR.BREADROLL)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.breadRecipe),
                new EntryPageSmelting(new ItemStack(FoodListMFR.RAW_BREAD), new ItemStack(Items.BREAD)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.pastryRecipe),
                new EntryPageGrind(new ItemStack(FoodListMFR.BREADROLL), new ItemStack(FoodListMFR.BREADCRUMBS)));
        KnowledgeListMFR.bread.addPages(new EntryPageText("knowledge.bread.other"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.pumpPieR),
                new EntryPageSmelting(new ItemStack(FoodListMFR.PIE_PUMPKIN_UNCOOKED),
                        new ItemStack(FoodListMFR.PIE_PUMPKIN_COOKED)),
                new EntryPageRecipeBase(KnowledgeListMFR.PIE_PUMPKIN_RECIPE));
        KnowledgeListMFR.bread.addPages(new EntryPageRecipeCarpenter(KnowledgeListMFR.simpCakeR),
                new EntryPageSmelting(new ItemStack(FoodListMFR.CAKE_SIMPLE_RAW),
                        new ItemStack(FoodListMFR.CAKE_SIMPLE_UNICED)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.simpCakeOut));

        KnowledgeListMFR.oats.addPages(new EntryPageText("knowledge.oats.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.oatsRecipe));

        KnowledgeListMFR.berry.addPages(assembleImgPage("berry", MineFantasyBlocks.BERRY_BUSH));
        KnowledgeListMFR.icing.addPages(new EntryPageText("knowledge.icing.1"),
                new EntryPageGrind(new ItemStack(Items.REEDS), new ItemStack(FoodListMFR.SUGAR_POT)),
                new EntryPageRecipeBase(KnowledgeListMFR.SUGAR_POT_RECIPE), new EntryPageText("knowledge.icing.2"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.icingRecipe));
        KnowledgeListMFR.sweetroll.addPages(new EntryPageText("knowledge.sweetroll.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.sweetrollRecipe),
                new EntryPageSmelting(new ItemStack(FoodListMFR.SWEETROLL_RAW),
                        new ItemStack(FoodListMFR.SWEETROLL_UNICED)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.iceSR));
        KnowledgeListMFR.cake.addPages(new EntryPageText("knowledge.cake.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.cakeR),
                new EntryPageSmelting(new ItemStack(FoodListMFR.CAKE_RAW), new ItemStack(FoodListMFR.CAKE_UNICED)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.cakeI));
        KnowledgeListMFR.carrotcake.addPages(new EntryPageText("knowledge.carrotcake.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.carrotCakeR),
                new EntryPageSmelting(new ItemStack(FoodListMFR.CAKE_CARROT_RAW),
                        new ItemStack(FoodListMFR.CAKE_CARROT_UNICED)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.carrotCakeI));
        KnowledgeListMFR.chococake.addPages(new EntryPageText("knowledge.chococake.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.chocoRecipe),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.chocoCakeR),
                new EntryPageSmelting(new ItemStack(FoodListMFR.CAKE_CHOC_RAW),
                        new ItemStack(FoodListMFR.CAKE_CHOC_UNICED)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.chocoCakeI));
        KnowledgeListMFR.bfcake.addPages(new EntryPageText("knowledge.bfcake.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.chocoRecipe),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bfCakeR),
                new EntryPageSmelting(new ItemStack(FoodListMFR.CAKE_BF_RAW), new ItemStack(FoodListMFR.CAKE_BF_UNICED)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bfCakeI));
        KnowledgeListMFR.berrypie
                .addPages(new EntryPageText("knowledge.berrypie.1"),
                        new EntryPageRecipeCarpenter(KnowledgeListMFR.berryR),
                        new EntryPageSmelting(new ItemStack(FoodListMFR.PIE_BERRY_UNCOOKED),
                                new ItemStack(FoodListMFR.PIE_BERRY_COOKED)),
                        new EntryPageRecipeBase(KnowledgeListMFR.PIE_BERRY_RECIPE));
        KnowledgeListMFR.applepie
                .addPages(new EntryPageText("knowledge.applepie.1"),
                        new EntryPageRecipeCarpenter(KnowledgeListMFR.appleR),
                        new EntryPageSmelting(new ItemStack(FoodListMFR.PIE_APPLE_UNCOOKED),
                                new ItemStack(FoodListMFR.PIE_APPLE_COOKED)),
                        new EntryPageRecipeBase(KnowledgeListMFR.PIE_APPLE_RECIPE));
        KnowledgeListMFR.eclair.addPages(new EntryPageText("knowledge.eclair.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.eclairDoughR),
                new EntryPageSmelting(new ItemStack(FoodListMFR.ECLAIR_RAW), new ItemStack(FoodListMFR.ECLAIR_UNICED)),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.chocoRecipe),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.eclairIceR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.custardRecipe),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.eclairFillR));

        KnowledgeListMFR.cheese.addPages(new EntryPageText("knowledge.cheese.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.curdRecipe),
                new EntryPageSmelting(new ItemStack(FoodListMFR.CURDS), new ItemStack(FoodListMFR.CHEESE_POT)),
                new EntryPageRecipeBase(KnowledgeListMFR.CHEESE_WHEEL_RECIPE));
        KnowledgeListMFR.cheeseroll.addPages(new EntryPageText("knowledge.cheeseroll.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.cheeserollR));

        KnowledgeListMFR.bandage.addPages(new EntryPageText("knowledge.bandage.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.badBandageR),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.bandageR));
        KnowledgeListMFR.bandageadv.addPages(new EntryPageText("knowledge.bandageadv.1"),
                new EntryPageRecipeCarpenter(KnowledgeListMFR.goodBandageR));

        // MASTERY
        KnowledgeListMFR.toughness.addPages(new EntryPageText("knowledge.toughness.1"));
        KnowledgeListMFR.fitness.addPages(new EntryPageText("knowledge.fitness.1"));
        KnowledgeListMFR.armourpro.addPages(new EntryPageText("knowledge.armourpro.1"));
        KnowledgeListMFR.parrypro.addPages(new EntryPageText("knowledge.parrypro.1"));
        KnowledgeListMFR.counteratt.addPages(new EntryPageText("knowledge.counteratt.1"),
                new EntryPageText("knowledge.counteratt.2"));
        KnowledgeListMFR.autoparry.addPages(new EntryPageText("knowledge.autoparry.1"));
        KnowledgeListMFR.firstaid.addPages(new EntryPageText("knowledge.firstaid.1"));
        KnowledgeListMFR.doctor.addPages(new EntryPageText("knowledge.doctor.1"));
        KnowledgeListMFR.scrapper.addPages(new EntryPageText("knowledge.scrapper.1"));
    }

    private static EntryPage[] assembleOreDesc(String orename, Block ore, Item ingot) {
        return new EntryPage[]{new EntryPageImage("textures/gui/knowledge/image/" + orename + ".png", 96, 96,
                "knowledge.ores." + orename), new EntryPageSmelting(new ItemStack(ore), new ItemStack(ingot))};
    }

    private static EntryPage[] assembleOreDescHC(String orename, Block ore, Item ingot) {
        if (ConfigHardcore.HCCreduceIngots) {
            return new EntryPage[]{
                    new EntryPageImage("textures/gui/knowledge/image/" + orename + ".png", 96, 96,
                            "knowledge.ores." + orename),
                    new EntryPageRecipeBloom(new ItemStack(ore), new ItemStack(ingot))};
        }
        return assembleOreDesc(orename, ore, ingot);
    }

    private static EntryPage[] assembleOreDesc(String orename, Block ore) {
        return new EntryPage[]{new EntryPageImage("textures/gui/knowledge/image/" + orename + ".png", 96, 96,
                "knowledge.ores." + orename)};
    }

    private static EntryPage[] assembleMineralDesc(String orename, Block ore) {
        return new EntryPage[]{new EntryPageImage("textures/gui/knowledge/image/" + orename + ".png", 96, 96,
                "knowledge.minerals." + orename)};
    }

    private static EntryPage[] assembleImgPage(String name, Block blockname) {
        return new EntryPage[]{new EntryPageImage("textures/gui/knowledge/image/" + name + ".png", 96, 96,
                "knowledge." + name + ".1")};
    }

    private static EntryPage[] assembleMobDesc(String name) {
        return new EntryPage[]{new EntryPageImage("textures/gui/knowledge/image/mob/" + name + ".png", 96, 96,
                "knowledge." + name + ".1")};
    }

    private static EntryPage assembleSimpleImgPage(String name, String text) {
        return new EntryPageImage("textures/gui/knowledge/image/" + name + ".png", 96, 96, text);
    }
}
