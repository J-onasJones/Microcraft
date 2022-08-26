package me.jonasjones.microcraft.gui.screens.board;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class AdvancedSettingsScreen extends Screen {

    private final Screen parent;

    public AdvancedSettingsScreen(Screen parent) {
        super(Text.of("Advanced Board Settings"));
        this.parent = parent;
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
