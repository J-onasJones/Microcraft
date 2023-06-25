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
            testFunction1();
        }).bounds(20, this.height - 40, 80, 20).build();

        Button testButton2 = new Button.Builder(Component.literal("Test Button 2"), (button) -> {
            testFunction2();
        }).bounds(120, this.height - 40, 80, 20).build();

        Button testButton3 = new Button.Builder(Component.literal("Test Button 3"), (button) -> {
            testFunction3();
        }).bounds(220, this.height - 40, 80, 20).build();

        Button testButton4 = new Button.Builder(Component.literal("Test Button 4"), (button) -> {
            testFunction4();
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

    private void testFunction1() {
        System.out.println("Test Function 1");
    }

    private void testFunction2() {
        System.out.println("Test Function 2");
    }

    private void testFunction3() {
        System.out.println("Test Function 3");
    }

    private void testFunction4() {
        System.out.println("Test Function 4");
    }
}
