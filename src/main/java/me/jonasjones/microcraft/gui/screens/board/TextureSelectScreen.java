package me.jonasjones.microcraft.gui.screens.board;

import me.jonasjones.microcraft.gui.screens.ModSettings;
import me.jonasjones.microcraft.gui.screens.SelectDevice;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class TextureSelectScreen extends Screen {
    private final Screen parent;

    public TextureSelectScreen(Screen parent) {
        super(Text.of("Microcraft Configuration"));
        this.parent = parent;
    }
    protected void init() {


        this.addDrawableChild(new ButtonWidget(this.width / 2 - 155, this.height / 6 + 12, 150, 20, Text.of("Configure Microcontrollers"), (button) -> {
            this.client.setScreen(new SelectDevice(this));
        }));
        this.addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 12, 150, 20, Text.of("Configure Microcraft"), (button) -> {
            this.client.setScreen(new ModSettings(this));
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 168, 200, 20, ScreenTexts.DONE, (button) -> {
            this.client.setScreen(this.parent);
        }));
        this.addDrawableChild(new net.minecraft.client.gui.widget.CheckboxWidget(50, 50, 100, 20, Text.of("uwu checkbox"), false));
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}