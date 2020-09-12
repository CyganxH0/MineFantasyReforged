package minefantasy.mfr.gui;

import codechicken.lib.texture.TextureUtils;
import minefantasy.mfr.network.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import minefantasy.mfr.MineFantasyReborn;
import minefantasy.mfr.api.helpers.GuiHelper;
import minefantasy.mfr.api.knowledge.InformationBase;
import minefantasy.mfr.api.knowledge.InformationList;
import minefantasy.mfr.api.knowledge.InformationPage;
import minefantasy.mfr.api.knowledge.ResearchLogic;
import minefantasy.mfr.api.rpg.RPGElements;
import minefantasy.mfr.api.rpg.Skill;
import minefantasy.mfr.api.rpg.SkillList;
import minefantasy.mfr.init.KnowledgeListMFR;
import minefantasy.mfr.network.ResearchRequestPacket;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SideOnly(Side.CLIENT)
public class GuiKnowledge extends GuiScreen {
	private static final int columnMin = InformationList.minDisplayColumn * 24 - 112;
	private static final int rowMin = InformationList.minDisplayRow * 24 - 112;
	private static final int columnMax = InformationList.maxDisplayColumn * 24 - 77;
	private static final int rowMax = InformationList.maxDisplayRow * 24 - 77;
	private static final ResourceLocation screenTex = new ResourceLocation(MineFantasyReborn.MOD_ID, "textures/gui/knowledge/knowledge.png");
	private static final ResourceLocation buyTex = new ResourceLocation(MineFantasyReborn.MOD_ID, "textures/gui/knowledge/purchase.png");
	private static final ResourceLocation skillTex = new ResourceLocation(MineFantasyReborn.MOD_ID, "textures/gui/knowledge/skill_list.png");
	protected static int informationWidth = 256;
	protected static int informationHeight = 202;
	protected static int field_146563_h;
	protected static int field_146564_i;
	protected static float field_146570_r = 1.0F;
	protected static double field_146569_s;
	protected static double field_146568_t;
	protected static double field_146567_u;
	protected static double field_146566_v;
	protected static double field_146565_w;
	protected static double field_146573_x;
	private static int field_146554_D;
	private static boolean allDiscovered = true;
	private static int currentPage = -1;
	public int buyWidth = 225;
	public int buyHeight = 72;
	int offsetByX = 70;
	int offsetByY = 0;
	private InformationBase selected = null;
	private InformationBase highlighted = null;
	private GuiButton button;
	private LinkedList<InformationBase> informationList = new LinkedList<InformationBase>();
	private EntityPlayer player;
	private boolean hasScroll = false;
	private boolean canPurchase = false;

	public GuiKnowledge(EntityPlayer user) {
		this.player = user;
		short short1 = 141;
		short short2 = 141;
		GuiKnowledge.field_146569_s = GuiKnowledge.field_146567_u = GuiKnowledge.field_146565_w = KnowledgeListMFR.gettingStarted.displayColumn
				* 24 - short1 / 2 - 12;
		GuiKnowledge.field_146568_t = GuiKnowledge.field_146566_v = GuiKnowledge.field_146573_x = KnowledgeListMFR.gettingStarted.displayRow
				* 24 - short2 / 2;
		informationList.clear();
		for (Object achievement : InformationList.knowledgeList) {
			if (!InformationPage.isInfoInPages((InformationBase) achievement)) {
				informationList.add((InformationBase) achievement);
			}
		}
		for (Object base : InformationList.knowledgeList.toArray()) {
			if (!ResearchLogic.hasInfoUnlocked(user, (InformationBase) base)) {
				allDiscovered = false;
				break;
			}
		}
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@Override
	public void initGui() {
		int i1 = (this.width - GuiKnowledge.informationWidth) / 2 + offsetByX;
		int j1 = (this.height - GuiKnowledge.informationHeight) / 2 + offsetByY;

		this.buttonList.clear();
		this.buttonList
				.add(new GuiOptionButton(1, this.width / 2 + 24, this.height / 2 + 101, I18n.format("gui.done")));
		this.buttonList.add(button = new GuiButton(2, (width - informationWidth) / 2 + 24, height / 2 + 101, 125, 20,
				InformationPage.getTitle(currentPage)));

		int purchasex = i1 + (informationWidth - buyWidth) / 2;
		int purchasey = j1 + (informationHeight - buyHeight) / 2;
		// PURCHASE SCREEN
		this.buttonList.add(
				new GuiOptionButton(3, purchasex + 19, purchasey + 47, I18n.format("gui.purchase")));
		this.buttonList
				.add(new GuiOptionButton(4, purchasex + 125, purchasey + 47, I18n.format("gui.cancel")));
	}

	@Override
	protected void mouseClicked(int x, int y, int button) throws IOException {
		if (selected == null && button == 0 && highlighted != null) {
			if (ResearchLogic.hasInfoUnlocked(player, highlighted) && !highlighted.getPages().isEmpty()) {
				player.openGui(MineFantasyReborn.INSTANCE, NetworkHandler.GUI_RESEARCH_BOOK, player.world, 0, highlighted.ID, 0);
			} else if (highlighted.isEasy() && ResearchLogic.canPurchase(player, highlighted)) {
				selected = highlighted;
				setPurchaseAvailable(player);
			}
		}
		super.mouseClicked(x, y, button);
	}

	@Override
	protected void actionPerformed(GuiButton p_146284_1_) {
		if (p_146284_1_.id == 1) {
			this.mc.displayGuiScreen((GuiScreen) null);
		}

		if (selected == null && p_146284_1_.id == 2) {
			currentPage++;

			if (currentPage >= InformationPage.getInfoPages().size()) {
				currentPage = -1;
			}
			button.displayString = InformationPage.getTitle(currentPage);
		}

		if (p_146284_1_.id == 3 && selected != null) {
			NetworkHandler.sendToPlayer((EntityPlayerMP) player, new ResearchRequestPacket(player, selected.ID));
			selected = null;
		}
		if (p_146284_1_.id == 4 && selected != null) {
			selected = null;
		}
	}

	/**
	 * Fired when a key is typed. This is the equivalent of
	 * KeyListener.keyTyped(KeyEvent e).
	 */
	@Override
	protected void keyTyped(char p_73869_1_, int p_73869_2_) throws IOException {
		if (p_73869_2_ == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
			this.mc.displayGuiScreen((GuiScreen) null);
			this.mc.setIngameFocus();
		} else {
			super.keyTyped(p_73869_1_, p_73869_2_);
		}
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int mx, int my, float f) {
		{
			int k;

			if (selected == null && Mouse.isButtonDown(0)) {
				k = (this.width - GuiKnowledge.informationWidth) / 2 + offsetByX;
				int l = (this.height - GuiKnowledge.informationHeight) / 2 + offsetByY;
				int i1 = k + 8;
				int j1 = l + 17;

				if ((GuiKnowledge.field_146554_D == 0 || GuiKnowledge.field_146554_D == 1) && mx >= i1 && mx < i1 + 224
						&& my >= j1 && my < j1 + 155) {
					if (GuiKnowledge.field_146554_D == 0) {
						GuiKnowledge.field_146554_D = 1;
					} else {
						GuiKnowledge.field_146567_u -= (mx - GuiKnowledge.field_146563_h) * GuiKnowledge.field_146570_r;
						GuiKnowledge.field_146566_v -= (my - GuiKnowledge.field_146564_i) * GuiKnowledge.field_146570_r;
						GuiKnowledge.field_146565_w = GuiKnowledge.field_146569_s = GuiKnowledge.field_146567_u;
						GuiKnowledge.field_146573_x = GuiKnowledge.field_146568_t = GuiKnowledge.field_146566_v;
					}

					GuiKnowledge.field_146563_h = mx;
					GuiKnowledge.field_146564_i = my;
				}
			} else {
				GuiKnowledge.field_146554_D = 0;
			}

			k = Mouse.getDWheel();
			float f4 = GuiKnowledge.field_146570_r;

			if (k < 0) {
				GuiKnowledge.field_146570_r += 0.25F;
			} else if (k > 0) {
				GuiKnowledge.field_146570_r -= 0.25F;
			}

			GuiKnowledge.field_146570_r = MathHelper.clamp(GuiKnowledge.field_146570_r, 1.0F, 3.0F);

			if (GuiKnowledge.field_146570_r != f4) {
				float f6 = f4 - GuiKnowledge.field_146570_r;
				float f5 = f4 * GuiKnowledge.informationWidth;
				float f1 = f4 * GuiKnowledge.informationHeight;
				float f2 = GuiKnowledge.field_146570_r * GuiKnowledge.informationWidth;
				float f3 = GuiKnowledge.field_146570_r * GuiKnowledge.informationHeight;
				GuiKnowledge.field_146567_u -= (f2 - f5) * 0.5F;
				GuiKnowledge.field_146566_v -= (f3 - f1) * 0.5F;
				GuiKnowledge.field_146565_w = GuiKnowledge.field_146569_s = GuiKnowledge.field_146567_u;
				GuiKnowledge.field_146573_x = GuiKnowledge.field_146568_t = GuiKnowledge.field_146566_v;
			}

			if (GuiKnowledge.field_146565_w < columnMin) {
				GuiKnowledge.field_146565_w = columnMin;
			}

			if (GuiKnowledge.field_146573_x < rowMin) {
				GuiKnowledge.field_146573_x = rowMin;
			}

			if (GuiKnowledge.field_146565_w >= columnMax) {
				GuiKnowledge.field_146565_w = columnMax - 1;
			}

			if (GuiKnowledge.field_146573_x >= rowMax) {
				GuiKnowledge.field_146573_x = rowMax - 1;
			}

			GL11.glDisable(GL11.GL_DEPTH_TEST);
			this.drawDefaultBackground();
			this.renderMainPage(mx, my, f);
			this.drawOverlay();
		}
		if (buttonList.get(2) != null) {
			((GuiButton) buttonList.get(2)).visible = selected != null;
			((GuiButton) buttonList.get(2)).enabled = selected != null && canPurchase;
			((GuiButton) buttonList.get(3)).visible = selected != null;
		}
	}

	/**
	 * Called from the main game loop to update the screen.
	 */
	@Override
	public void updateScreen() {
		{
			GuiKnowledge.field_146569_s = GuiKnowledge.field_146567_u;
			GuiKnowledge.field_146568_t = GuiKnowledge.field_146566_v;
			double d0 = GuiKnowledge.field_146565_w - GuiKnowledge.field_146567_u;
			double d1 = GuiKnowledge.field_146573_x - GuiKnowledge.field_146566_v;

			if (d0 * d0 + d1 * d1 < 4.0D) {
				GuiKnowledge.field_146567_u += d0;
				GuiKnowledge.field_146566_v += d1;
			} else {
				GuiKnowledge.field_146567_u += d0 * 0.85D;
				GuiKnowledge.field_146566_v += d1 * 0.85D;
			}
		}
	}

	protected void drawOverlay() {
		int i = (this.width - GuiKnowledge.informationWidth) / 2 + offsetByX;
		int j = (this.height - GuiKnowledge.informationHeight) / 2 + offsetByY;

		this.fontRenderer.drawString(I18n.format("gui.information"), i + 15, j + 5, 4210752);
	}

	protected void renderMainPage(int mx, int my, float f) {
		int k = MathHelper
				.floor(GuiKnowledge.field_146569_s + (GuiKnowledge.field_146567_u - GuiKnowledge.field_146569_s) * f);
		int l = MathHelper
				.floor(GuiKnowledge.field_146568_t + (GuiKnowledge.field_146566_v - GuiKnowledge.field_146568_t) * f);

		if (k < columnMin) {
			k = columnMin;
		}

		if (l < rowMin) {
			l = rowMin;
		}

		if (k >= columnMax) {
			k = columnMax - 1;
		}

		if (l >= rowMax) {
			l = rowMax - 1;
		}

		int i1 = (this.width - GuiKnowledge.informationWidth) / 2 + offsetByX;
		int j1 = (this.height - GuiKnowledge.informationHeight) / 2 + offsetByY;
		int k1 = i1 + 16;
		int l1 = j1 + 17;
		this.zLevel = 0.0F;
		GL11.glDepthFunc(GL11.GL_GEQUAL);
		GL11.glPushMatrix();
		GL11.glTranslatef(k1, l1, -200.0F);
		GL11.glScalef(1.0F / GuiKnowledge.field_146570_r, 1.0F / GuiKnowledge.field_146570_r, 0.0F);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);

		int i2 = k + 288 >> 4;
		int j2 = l + 288 >> 4;
		int k2 = (k + 288) % 16;
		int l2 = (l + 288) % 16;
		boolean flag = true;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4 = true;
		Random random = new Random();
		float f1 = 16.0F / GuiKnowledge.field_146570_r;
		float f2 = 16.0F / GuiKnowledge.field_146570_r;
		int i3;
		int j3;
		int k3;

		for (i3 = 0; i3 * f1 - l2 < 155.0F; ++i3) {
			float f3 = 0.6F - (j2 + i3) / 25.0F * 0.3F;
			GL11.glColor4f(f3, f3, f3, 1.0F);

			for (j3 = 0; j3 * f2 - k2 < 224.0F; ++j3) {
				TextureAtlasSprite sprite = TextureUtils.getBlockTexture("planks_oak");

				this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
				this.drawTexturedModalRect(j3 * 16 - k2, i3 * 16 - l2, sprite, 16, 16);
			}
		}

		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		this.mc.getTextureManager().bindTexture(screenTex);
		int researchVisibility;
		int j4;
		int l4;

		List<InformationBase> achievementList = (currentPage == -1 ? informationList
				: InformationPage.getInfoPage(currentPage).getInfoList());
		for (i3 = 0; i3 < achievementList.size(); ++i3) {
			InformationBase achievement1 = achievementList.get(i3);

			if (achievement1.parentInfo != null && achievementList.contains(achievement1.parentInfo)) {
				j3 = achievement1.displayColumn * 24 - k + 11;
				k3 = achievement1.displayRow * 24 - l + 11;
				l4 = achievement1.parentInfo.displayColumn * 24 - k + 11;
				int l3 = achievement1.parentInfo.displayRow * 24 - l + 11;
				boolean flag5 = ResearchLogic.hasInfoUnlocked(player, achievement1);
				boolean flag6 = ResearchLogic.canUnlockInfo(player, achievement1);
				researchVisibility = ResearchLogic.func_150874_c(player, achievement1);
				j4 = -16777216;

				if (flag5) {
					j4 = -6250336;
				} else if (flag6) {
					j4 = -16711936;
				}
				if (researchVisibility <= getVisibleRange()[0] && k3 >= -24 && j3 >= -24
						&& k3 <= GuiKnowledge.informationHeight && j3 <= GuiKnowledge.informationWidth && l4 <= GuiKnowledge.informationHeight && j4 <= GuiKnowledge.informationWidth) {

					this.drawHorizontalLine(j3, l4, k3, j4);
					this.drawVerticalLine(l4, k3, l3, j4);

					if (j3 > l4) {
						this.drawTexturedModalRect(j3 - 11 - 7, k3 - 5, 114, 234, 7, 11);
					} else if (j3 < l4) {
						this.drawTexturedModalRect(j3 + 11, k3 - 5, 107, 234, 7, 11);
					} else if (k3 > l3) {
						this.drawTexturedModalRect(j3 - 5, k3 - 11 - 7, 96, 234, 11, 7);
					} else if (k3 < l3) {
						this.drawTexturedModalRect(j3 - 5, k3 + 11, 96, 241, 11, 7);
					}
				}
			}
		}

		InformationBase achievement = null;
		RenderItem renderitem = Minecraft.getMinecraft().getRenderItem();
		float f4 = (mx - k1) * GuiKnowledge.field_146570_r;
		float f5 = (my - l1) * GuiKnowledge.field_146570_r;
		RenderHelper.enableGUIStandardItemLighting();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		int i5;
		int j5;

		for (l4 = 0; l4 < achievementList.size(); ++l4) {
			InformationBase achievement2 = achievementList.get(l4);
			i5 = achievement2.displayColumn * 24 - k;
			j5 = achievement2.displayRow * 24 - l;

			if (i5 >= -24 && j5 >= -24 && i5 <= 224.0F * GuiKnowledge.field_146570_r
					&& j5 <= 155.0F * GuiKnowledge.field_146570_r) {
				researchVisibility = ResearchLogic.func_150874_c(player, achievement2);
				float f6;

				if (ResearchLogic.hasInfoUnlocked(player, achievement2)) {
					f6 = 0.75F;
					GL11.glColor4f(f6, f6, f6, 1.0F);
				} else if (ResearchLogic.canUnlockInfo(player, achievement2)) {
					f6 = 1.0F;
					GL11.glColor4f(0.5F, 1.0F, 0.5F, 1.0F);
				} else if (researchVisibility < getVisibleRange()[1]) {
					f6 = 0.3F;
					GL11.glColor4f(f6, f6, f6, 1.0F);
				} else if (researchVisibility == getVisibleRange()[1]) {
					f6 = 0.2F;
					GL11.glColor4f(f6, f6, f6, 1.0F);
				} else {
					if (researchVisibility != getVisibleRange()[2]) {
						continue;
					}

					f6 = 0.1F;
					GL11.glColor4f(f6, f6, f6, 1.0F);
				}

				this.mc.getTextureManager().bindTexture(screenTex);

				GL11.glEnable(GL11.GL_BLEND);// Forge: Specifically enable blend because it is needed here. And we fix
				// Generic RenderItem's leakage of it.
				if (achievement2.getSpecial()) {
					this.drawTexturedModalRect(i5 - 2, j5 - 2, 26, 202, 26, 26);
				} else if (achievement2.getPerk()) {
					this.drawTexturedModalRect(i5 - 2, j5 - 2, 52, 202, 26, 26);
				} else {
					this.drawTexturedModalRect(i5 - 2, j5 - 2, 0, 202, 26, 26);
				}
				GL11.glDisable(GL11.GL_BLEND); // Forge: Cleanup states we set.

				if (!ResearchLogic.canUnlockInfo(player, achievement2)) {
					f6 = 0.1F;
					GL11.glColor4f(f6, f6, f6, 1.0F);
				}

				GL11.glEnable(GL11.GL_CULL_FACE);
				renderitem.renderItemAndEffectIntoGUI(achievement2.theItemStack, i5 + 3, j5 + 3);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

				if (f4 >= i5 && f4 <= i5 + 22 && f5 >= j5 && f5 <= j5 + 22) {
					achievement = achievement2;
				}
			}
		}

		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(screenTex);
		this.drawTexturedModalRect(i1, j1, 0, 0, GuiKnowledge.informationWidth, GuiKnowledge.informationHeight);

		this.zLevel = 0.0F;
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);

		if (selected != null) {
			int purchasex = i1 + (informationWidth - buyWidth) / 2;
			int purchasey = j1 + (informationHeight - buyHeight) / 2;
			renderPurchaseScreen(purchasex, purchasey, mx, my);
		}
		drawSkillList();
		super.drawScreen(mx, my, f);

		highlighted = achievement;
		if (selected == null && achievement != null) {
			String s1 = achievement.getDisplayName();
			String s2 = achievement.getDescription();
			i5 = mx + 12;
			j5 = my - 4;
			researchVisibility = ResearchLogic.func_150874_c(player, achievement);

			if (!ResearchLogic.canUnlockInfo(player, achievement)) {
				String s;
				int k4;

				if (researchVisibility == 3) {
					s1 = I18n.format("achievement.unknown");
					j4 = Math.max(this.fontRenderer.getStringWidth(s1), 120);
					s = (new TextComponentString(
							"achievement.requires" + new Object[] { achievement.parentInfo.getDisplayName() }))
									.getUnformattedText();
					k4 = this.fontRenderer.getWordWrappedHeight(s, j4);
					this.drawGradientRect(i5 - 3, j5 - 3, i5 + j4 + 3, j5 + k4 + 12 + 3, -1073741824, -1073741824);
					this.fontRenderer.drawSplitString(s, i5, j5 + 12, j4, -9416624);
				} else if (researchVisibility < 3) {
					j4 = Math.max(this.fontRenderer.getStringWidth(s1), 120);
					s = (new TextComponentString(
							"achievement.requires" + new Object[] { achievement.parentInfo.getDisplayName() }))
									.getUnformattedText();
					k4 = this.fontRenderer.getWordWrappedHeight(s, j4);
					this.drawGradientRect(i5 - 3, j5 - 3, i5 + j4 + 3, j5 + k4 + 12 + 3, -1073741824, -1073741824);
					this.fontRenderer.drawSplitString(s, i5, j5 + 12, j4, -9416624);
				} else {
					s1 = null;
				}
			} else {
				j4 = Math.max(this.fontRenderer.getStringWidth(s1), 120);
				int k5 = this.fontRenderer.getWordWrappedHeight(s2, j4);

				if (ResearchLogic.hasInfoUnlocked(player, achievement)
						|| ResearchLogic.canUnlockInfo(player, achievement)) {
					k5 += 12;
				}

				this.drawGradientRect(i5 - 3, j5 - 3, i5 + j4 + 3, j5 + k5 + 3 + 12, -1073741824, -1073741824);
				this.fontRenderer.drawSplitString(s2, i5, j5 + 12, j4, -6250336);

				if (ResearchLogic.hasInfoUnlocked(player, achievement)) {
					this.fontRenderer.drawStringWithShadow(I18n.format("information.discovered"), i5,
							j5 + k5 + 4, -7302913);
				} else if (InformationBase.easyResearch && ResearchLogic.canUnlockInfo(player, achievement)) {
					this.fontRenderer.drawStringWithShadow(
							I18n.format("information.buy"), i5,
							j5 + k5 + 4, -7302913);
				}
			}

			if (s1 != null) {
				this.fontRenderer.drawStringWithShadow(s1, i5, j5,
						ResearchLogic.canUnlockInfo(player, achievement) ? (achievement.getSpecial() ? -128 : -1)
								: (achievement.getSpecial() ? -8355776 : -8355712));
			}
		}

		GL11.glEnable(GL11.GL_DEPTH_TEST);
		RenderHelper.disableStandardItemLighting();
	}

	/**
	 * Returns true if this GUI should pause the game when it is displayed in
	 * single-player
	 */
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	private int[] getVisibleRange() {
		return new int[] { 1, 2, 3 };
	}

	private void renderPurchaseScreen(int x, int y, int mx, int my) {
		if (selected != null) {
			String[] requirements = selected.getRequiredSkills();
			int size = 0;
			if (requirements != null) {
				size = requirements.length;
			}
			this.mc.getTextureManager().bindTexture(buyTex);
			this.drawTexturedModalRect(x, y, 0, 0, buyWidth, 27);// Top
			for (int a = 0; a < size; a++) {
				this.drawTexturedModalRect(x, y + 27 + (a * 19), 0, 27, buyWidth, 19);// Middle
			}
			this.drawTexturedModalRect(x, y + 27 + (size * 19), 0, 46, buyWidth, 26);// Bottom

			if (buttonList.get(2) != null && buttonList.get(3) != null) {
				int j1 = (this.height - GuiKnowledge.informationHeight) / 2;
				int purchasey = j1 + (informationHeight - buyHeight) / 2;

				int offset = -19;
				if (requirements != null) {
					offset += (19 * requirements.length);
				}
				((GuiButton) buttonList.get(2)).y = purchasey + 47 + offset;
				((GuiButton) buttonList.get(3)).y = purchasey + 47 + offset;
			}
			int red = GuiHelper.getColourForRGB(220, 0, 0);
			int white = 16777215;
			mc.fontRenderer.drawString(selected.getDisplayName(), x + 22, y + 12, white, false);

			if (hasScroll) {
				mc.fontRenderer.drawStringWithShadow(
						I18n.format("knowledge.has_scroll"), x + 20,
						y + 32, red);
			} else {
				for (int a = 0; a < requirements.length; a++) {
					boolean isUnlocked = selected.isUnlocked(a, mc.player);
					String text = requirements[a];
					mc.fontRenderer.drawStringWithShadow(text, x + 20, y + 32 + (a * 19), isUnlocked ? white : red);
				}
			}
		}
		GL11.glColor3f(255, 255, 255);
	}

	private void setPurchaseAvailable(EntityPlayer user) {
		if (selected != null) {
			canPurchase = selected.hasSkillsUnlocked(user);
		} else {
			canPurchase = false;
		}
	}

	protected void drawSkillList() {
		GL11.glPushMatrix();

		int skillWidth = 143;
		int skillHeight = 156;
		int x = (this.width - GuiKnowledge.informationWidth) / 2 - skillWidth + offsetByX;
		int y = (this.height - GuiKnowledge.informationHeight) / 2 + offsetByY;
		this.mc.getTextureManager().bindTexture(skillTex);

		this.drawTexturedModalRect(x, y, 0, 0, skillWidth, skillHeight);

		drawSkill(x + 20, y + 20, SkillList.artisanry);
		drawSkill(x + 20, y + 44, SkillList.construction);
		drawSkill(x + 20, y + 68, SkillList.provisioning);
		drawSkill(x + 20, y + 92, SkillList.engineering);
		drawSkill(x + 20, y + 116, SkillList.combat);

		drawSkillName(x + 20, y + 20, SkillList.artisanry);
		drawSkillName(x + 20, y + 44, SkillList.construction);
		drawSkillName(x + 20, y + 68, SkillList.provisioning);
		drawSkillName(x + 20, y + 92, SkillList.engineering);
		drawSkillName(x + 20, y + 116, SkillList.combat);

		GL11.glPopMatrix();
	}

	protected void drawSkill(int x, int y, Skill skill) {
		if (skill != null) {
			int level = RPGElements.getLevel(mc.player, skill);
			int xp = skill.getXP(player)[0];
			int max = skill.getXP(player)[1];
			if (xp > max)
				xp = max;

			float scale = (float) xp / (float) max;
			this.drawTexturedModalRect(x + 22, y + 13, 0, 156, (int) (78F * scale), 5);

			// mc.fontRenderer.drawString(skill.getDisplayName(), x+2, y+1, 0);
			// mc.fontRenderer.drawString(""+level, x+1, y+10, 0);
		}
	}

	protected void drawSkillName(int x, int y, Skill skill) {
		if (skill != null) {
			int level = RPGElements.getLevel(mc.player, skill);
			mc.fontRenderer.drawString(skill.getDisplayName(), x + 2, y + 1, 0);
			mc.fontRenderer.drawString("" + level, x + 1, y + 10, 0);
		}
	}
}