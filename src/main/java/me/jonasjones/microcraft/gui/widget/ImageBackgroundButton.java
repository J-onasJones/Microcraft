package me.jonasjones.microcraft.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

// todo: change everythign to spruceUI one day :P
public class ImageBackgroundButton extends ImageButton {
    private final ResourceLocation resourceLocation;
    private final int textureWidth;
    private final int textureHeight;

    public ImageBackgroundButton(int x, int y, int width, int height, ResourceLocation resourceLocation,
                                 int textureWidth, int textureHeight, OnPress onPress) {
        super(x, y, width, height, 0, 0, 0, resourceLocation, textureWidth, textureHeight, onPress);
        this.resourceLocation = resourceLocation;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
    }

    @Override
    public void renderButton(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, WIDGETS_LOCATION);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();

        int i = this.getYImage(this.isHoveredOrFocused());

        this.blit(poseStack, this.getX(), this.getY(), 0, 46 + i * 20, this.width / 2, this.height);
        this.blit(poseStack, this.getX() + this.width / 2, this.getY(), 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);

        this.renderBg(poseStack, minecraft, mouseX, mouseY);

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, this.resourceLocation);

        RenderSystem.enableDepthTest();
        blit(poseStack, this.getX(), this.getY(), 0, (float) 0, this.width, this.height,
             this.textureWidth, this.textureHeight);
    }
}
