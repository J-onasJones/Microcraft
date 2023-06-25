package me.jonasjones.microcraft.gui.screens.board;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class AdvancedPinMappingScreen extends Screen {

    private final Screen parent;

    public AdvancedPinMappingScreen(Screen parent) {
        super(Component.nullToEmpty("Advanced Pin Mapping"));
        this.parent = parent;
    }

    protected void init() {
    }

    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredString(matrices, this.font, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
