package minefantasy.mfr.item;

import minefantasy.mfr.mechanics.worldGen.structure.WorldGenAncientAlter;
import minefantasy.mfr.mechanics.worldGen.structure.WorldGenAncientForge;
import minefantasy.mfr.mechanics.worldGen.structure.WorldGenStructureBase;
import minefantasy.mfr.mechanics.worldGen.structure.dwarven.WorldGenDwarvenStronghold;
import minefantasy.mfr.util.MFRLogUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWorldGenPlacer extends ItemBaseMFR {
    private static final String[] types = new String[]{"AncientForge", "AncientAlter", "DwarvenStronghold"};

    public ItemWorldGenPlacer() {
        super("place_world_gen_mf");
        this.setCreativeTab(CreativeTabs.MISC);

        this.setHasSubtypes(true);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer user, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack item = user.getHeldItem(hand);
        if (!user.canPlayerEdit(pos, facing, item)) {
            return EnumActionResult.FAIL;
        } else {
            if (!world.isRemote) {
                WorldGenStructureBase wg = getWorldGen(item.getItemDamage());
                if (wg instanceof WorldGenDwarvenStronghold) {
                    WorldGenDwarvenStronghold ds = (WorldGenDwarvenStronghold) wg;
                    MFRLogUtil.logDebug("DS: Try Cliff Build");
                    if (!ds.generate(world, itemRand, pos)) {
                        MFRLogUtil.logDebug("Failed... DS: Try Surface Build");
                        ds.setSurfaceMode(true);
                        if (ds.generate(world, itemRand, pos)) {
                            MFRLogUtil.logDebug("Success... DS: Placed Surface Build");
                        } else {
                            MFRLogUtil.logDebug("Failed... DS: No Build Placed");
                        }
                    } else {
                        MFRLogUtil.logDebug("Success... DS: Placed Cliff Build");
                    }
                } else {
                    wg.generate(world, itemRand, pos);
                }
            }
            return EnumActionResult.PASS;
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack item) {
        int d = MathHelper.clamp(item.getItemDamage(), 0, types.length - 1);
        return "World Gen " + types[d];
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!isInCreativeTab(tab)) {
            return;
        }
        for (int id = 0; id < types.length; id++)
            items.add(items.get(id));
    }

    private WorldGenStructureBase getWorldGen(int meta) {
        if (meta == 1) {
            return new WorldGenAncientAlter();
        }
        if (meta == 2) {
            return new WorldGenDwarvenStronghold();
        }
        return new WorldGenAncientForge();
    }

    @Override
    public void registerClient() {
       // TODO: fixme -> getSubItems
    }
}
