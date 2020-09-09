package minefantasy.mfr.network;

import net.minecraftforge.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import minefantasy.mfr.tile.decor.TileEntityWoodDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class WoodDecorPacket extends PacketMF {
    public static final String packetName = "MF2_WdDecorPkt";
    private int[] coords = new int[3];
    private String materialName;

    public WoodDecorPacket(TileEntityWoodDecor tile) {
        this.coords = new int[]{tile.xCoord, tile.yCoord, tile.zCoord};
        this.materialName = tile.getMaterialName();
    }

    public WoodDecorPacket() {
    }

    @Override
    public void process(ByteBuf packet, EntityPlayer player) {
        coords = new int[]{packet.readInt(), packet.readInt(), packet.readInt()};
        TileEntity entity = player.worldObj.getTileEntity(coords[0], coords[1], coords[2]);
        materialName = ByteBufUtils.readUTF8String(packet);

        if (entity != null && entity instanceof TileEntityWoodDecor) {
            TileEntityWoodDecor tile = (TileEntityWoodDecor) entity;
            tile.trySetMaterial(materialName);
        }
    }

    @Override
    public String getChannel() {
        return packetName;
    }

    @Override
    public void write(ByteBuf packet) {
        for (int a = 0; a < coords.length; a++) {
            packet.writeInt(coords[a]);
        }
        ByteBufUtils.writeUTF8String(packet, materialName);
    }
}
