package me.jonasjones.microcraft.gui.screens.board;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class AdvancedSettingsScreen extends Screen {

    private final Screen parent;

    public AdvancedSettingsScreen(Screen parent) {
        super(Component.nullToEmpty("Advanced Board Settings"));
        this.parent = parent;
    }

    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredString(matrices, this.font, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
