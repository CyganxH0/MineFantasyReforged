package minefantasy.mfr.client.render.entity;

import minefantasy.mfr.api.helpers.TextureHelperMFR;
import minefantasy.mfr.entity.EntityDragonBreath;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderDragonBreath extends Render<EntityDragonBreath> {

    public RenderDragonBreath(RenderManager renderManager) {
		super(renderManager);
	}

    /**
     * Actually renders the given argument. This is a synthetic bridge method,
     * always casting down its argument and then handing it off to a worker function
     * which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void
     * func_76986_a(T entity, double d, double d1, double d2, float f, float f1).
     * But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityDragonBreath entity, double x, double y, double z, float f, float f1) {
        if (entity.isInvisible())
            return;

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x, (float) y, (float) z);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        float baseSize = 1.0F;
        GL11.glScalef(baseSize + entity.width, baseSize + entity.height, baseSize + entity.width);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glColor3f(1, 1, 1);
        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureHelperMFR.getResource(entity.getTextureName() + ".png"));
        GL11.glDepthMask(false);
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        this.renderImg(entity, bufferBuilder);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glColor3f(1, 1, 1);
        GL11.glPopMatrix();
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDragonBreath entity) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }

    private void renderImg(EntityDragonBreath breath, BufferBuilder bufferBuilder) {
        float x1 = 0;
        float x2 = 1;
        float y1 = 0;
        float y2 = 1;
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(breath.ticksExisted * 36, 0.0F, 0.0F, 0.1F);
        bufferBuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.putNormal(0.0F, 1.0F, 0.0F);
        bufferBuilder.pos(0.0F - f5, 0.0F - f6, 0.0D).tex(x1, y2);
        bufferBuilder.pos(f4 - f5, 0.0F - f6, 0.0D).tex(x2, y2);
        bufferBuilder.pos(f4 - f5, f4 - f6, 0.0D).tex(x2, y1);
        bufferBuilder.pos(0.0F - f5, f4 - f6, 0.0D).tex(x1, y1);
        bufferBuilder.finishDrawing();
    }
}