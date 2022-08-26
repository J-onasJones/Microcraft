package me.jonasjones.microcraft.gui.screens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class ModCreditsScreen extends Screen {

    private final Screen parent;

    public ModCreditsScreen(Screen parent) {
        super(Text.of("About Microcraft"));
        this.parent = parent;
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
