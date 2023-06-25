package me.jonasjones.microcraft.gui.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class TestDevScreen extends Screen {
    public TestDevScreen() {
        super(Component.literal("Test Dev Screen"));
    }

    @Override
    protected void init() {
        super.init();

        Button testButton = new Button.Builder(Component.literal("Test Button 1"), (button) -> {
            System.out.println("Test Button Pressed");
        }).bounds(20, this.height - 40, 80, 20).build();

        Button testButton2 = new Button.Builder(Component.literal("Test Button 2"), (button) -> {
            System.out.println("Test Button Pressed");
        }).bounds(120, this.height - 40, 80, 20).build();

        Button testButton3 = new Button.Builder(Component.literal("Test Button 3"), (button) -> {
            System.out.println("Test Button Pressed");
        }).bounds(220, this.height - 40, 80, 20).build();

        Button testButton4 = new Button.Builder(Component.literal("Test Button 4"), (button) -> {
            System.out.println("Test Button Pressed");
        }).bounds(320, this.height- 40 , 80, 20).build();

        this.addRenderableWidget(testButton);
        this.addRenderableWidget(testButton2);
        this.addRenderableWidget(testButton3);
        this.addRenderableWidget(testButton4);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
    }
}
