package minefantasy.mfr.world.gen.structure.dwarven;

import minefantasy.mfr.init.BlockListMFR;
import minefantasy.mfr.world.gen.structure.LootTypes;
import minefantasy.mfr.world.gen.structure.StructureGenAncientForge;
import minefantasy.mfr.world.gen.structure.StructureModuleMFR;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StructureGenDSRoomSml2 extends StructureModuleMFR {
    public StructureGenDSRoomSml2(World world, StructureCoordinates position) {
        super(world, position);
    }

    protected int getHeight() {
        return 5;
    }

    protected int getDepth() {
        return 10;
    }

    protected int getWidth() {
        return 4;
    }

    @Override
    public boolean canGenerate() {
        int width = getWidth(), depth = getDepth(), height = getHeight();
        int filledSpaces = 0, emptySpaces = 0;

        for (int x = -width; x <= width; x++) {
            for (int y = 0; y <= height; y++) {
                for (int z = 1; z <= depth; z++) {
                    BlockPos pos = new BlockPos(x, y, z);
                    IBlockState state = this.getBlock(pos);
                    if (!allowBuildOverBlock(state.getBlock()) || this.isUnbreakable(pos, direction)) {
                        return false;
                    }
                    if (!state.getMaterial().isSolid()) {
                        ++emptySpaces;
                    } else {
                        ++filledSpaces;
                    }
                }
            }
        }
        if (WorldGenDwarvenStronghold.debug_air) {
            return true;
        }
        return ((float) emptySpaces / (float) (emptySpaces + filledSpaces)) < WorldGenDwarvenStronghold.maxAir;// at
        // least
        // 75%
        // full
    }

    private boolean allowBuildOverBlock(Block block) {
        if (block == BlockListMFR.REINFORCED_STONE_BRICKS || block == BlockListMFR.REINFORCED_STONE) {
            return false;
        }
        return true;
    }

    @Override
    public void generate() {
        int width = getWidth(), depth = getDepth(), height = getHeight();

        for (int x = -width; x <= width; x++) {
            for (int z = 0; z <= depth; z++) {
                Object[] blockarray;
                // FLOOR
                blockarray = getFloor(width, depth, x, z);
                if (blockarray != null) {
                    placeBlock((Block) blockarray[0], new BlockPos(x, 0, z) );
                }
                // WALLS
                for (int y = 1; y <= height; y++) {
                    blockarray = getWalls(width, depth, x, z);
                    if (blockarray != null) {
                        placeBlock((Block) blockarray[0], new BlockPos(x, y, z) );
                    }
                }
                // CEILING
                blockarray = getCeiling(width, depth, x, z);
                if (blockarray != null) {
                    int meta = (Boolean) blockarray[1] ? StructureGenAncientForge.getRandomMetadata(rand) : 0;
                    placeBlock((Block) blockarray[0], new BlockPos(x, height, z) );
                }
            }
        }
        placeBlock(Blocks.AIR, new BlockPos(0, 1, 0) );
        placeBlock(Blocks.AIR, new BlockPos(0, 2, 0) );

        placeBlock(BlockListMFR.REINFORCED_STONE_FRAMED, new BlockPos(-1, 1, -1) );
        placeBlock(BlockListMFR.REINFORCED_STONE, new BlockPos(-1, 2, -1) );
        placeBlock(BlockListMFR.REINFORCED_STONE_FRAMED_IRON, new BlockPos(-1, 3, -1) );

        placeBlock(BlockListMFR.REINFORCED_STONE_FRAMED, new BlockPos( 1, 1, -1));
        placeBlock(BlockListMFR.REINFORCED_STONE, new BlockPos(1, 2, -1) );
        placeBlock(BlockListMFR.REINFORCED_STONE_FRAMED_IRON, new BlockPos(1, 3, -1) );

        placeBlock(BlockListMFR.REINFORCED_STONE, new BlockPos(0, 3, -1) );
        placeBlock(Blocks.AIR, new BlockPos(0, 1, -1) );
        placeBlock(Blocks.AIR, new BlockPos(0, 2, -1) );

        buildHomeFurnishings(width, depth, height);
    }

    private Object[] getFloor(int width, int depth, int x, int z) {
        if (x == -(width - 1) || x == (width - 1) || z == 1 || z == depth - 1) {
            return new Object[]{BlockListMFR.REINFORCED_STONE, 0};
        }
        return new Object[]{BlockListMFR.REFINED_PLANKS, 0};
    }

    private Object[] getCeiling(int width, int depth, int x, int z) {
        if (x == -(width - 1) || x == (width - 1) || z == 1 || z == depth - 1) {
            return new Object[]{BlockListMFR.REINFORCED_STONE, false};
        }
        return new Object[]{BlockListMFR.REINFORCED_STONE_BRICKS, true};
    }

    private Object[] getWalls(int width, int depth, int x, int z) {
        if (x == -width || x == width || z == depth || z == 0) {
            if ((x == -width && (z == depth || z == 0)) || (x == width && (z == depth || z == 0))) {
                return new Object[]{BlockListMFR.REINFORCED_STONE, false};
            }

            return new Object[]{BlockListMFR.REINFORCED_STONE_BRICKS, true};
        }
        return new Object[]{Blocks.AIR, false};
    }

    private void buildHomeFurnishings(int width, int depth, int height) {
        placeBlock(Blocks.FURNACE, rotateLeft(), width, 2, 2);
        placeBlock(Blocks.DOUBLE_STONE_SLAB, 0, width - 3, 1, 1);
        placeBlock(Blocks.DOUBLE_STONE_SLAB, 0, width - 3, 1, 2);

        for (int x = width - 1; x >= (width - 4); x--) {
            placeBlock(BlockListMFR.REINFORCED_STONE_BRICKS, StructureGenAncientForge.getRandomMetadata(rand), x, 1, 5);
            placeBlock(BlockListMFR.REINFORCED_STONE_BRICKS, StructureGenAncientForge.getRandomMetadata(rand), x, 2, 5);
            placeBlock(Blocks.STONE_SLAB, 0, x, 3, 5);
        }
        placeBlock(Blocks.STONE_SLAB, 0, width - 1, 1, 7);
        placeBlock(Blocks.STONE_SLAB, 0, width - 2, 1, 7);
        placeBlock(Blocks.STONE_SLAB, 0, width - 1, 1, 8);
        placeBlock(Blocks.STONE_SLAB, 0, width - 2, 1, 8);
        placeBlock(Blocks.CAULDRON, 0, width - 2, 1, 1);

        placeBlock(Blocks.STONE_BRICK_STAIRS, this.getStairDirection(reverse()), -(width - 1), 1, 1);
        placeBlock(Blocks.STONE_SLAB, 8, -(width - 1), 1, 2);
        placeBlock(Blocks.STONE_BRICK_STAIRS, this.getStairDirection(direction), -(width - 1), 1, 3);

        placeChest(width - 3, 1, 7, rotateLeft(), LootTypes.DWARVEN_HOME_RICH);
    }

    private void placeChest(int x, int y, int z, int d, String loot) {
        placeBlock(Blocks.CHEST, d, x, y, z);
        TileEntityChest tile = (TileEntityChest) getTileEntity(x, y, z, direction);

        if (tile != null) {
            tile.setLootTable(loot, 2 + rand.nextInt(3));
        }
    }
}
