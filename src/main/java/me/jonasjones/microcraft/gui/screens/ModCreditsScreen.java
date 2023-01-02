package me.jonasjones.microcraft.gui.screens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ConfirmLinkScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.GridWidget;
import net.minecraft.client.gui.widget.SimplePositioningWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Util;

import java.util.Iterator;

@Environment(EnvType.CLIENT)
public class ModCreditsScreen extends Screen {

    private final Screen parent;

    public ModCreditsScreen(Screen parent) {
        super(Text.of("About Microcraft"));
        this.parent = parent;
    }

    protected void init() {
        this.addDrawableChild(ButtonWidget.builder(Text.of("Modrinth"), this::openModrinthPage).dimensions(this.width / 2 - 155, this.height / 6 + 12, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("GitHub"), this::openGithubPage).dimensions(this.width / 2 - 50, this.height / 6 + 12, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Curseforge"), this::openCurseforgePage).dimensions(this.width / 2 + 55, this.height / 6 + 12, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Homepage"), this::openHomepagePage).dimensions(this.width / 2 - 155, this.height / 6 + 35, 310, 20).build());

        this.addDrawableChild(ButtonWidget.builder(ScreenTexts.DONE, (button) -> {
            this.client.setScreen(this.parent);
        }).dimensions(this.width / 2 - 100, this.height / 6 + 168, 200, 20).build());
    }

    private void openModrinthPage(ButtonWidget button) {
        this.client.setScreen(new ConfirmLinkScreen((confirmed) -> {
            if (confirmed) {
                Util.getOperatingSystem().open("http://aka.jonasjones.me/microcraft-modrinth");
            }

            this.client.setScreen(this);
        }, "http://aka.jonasjones.me/microcraft-modrinth", true));
    }

    private void openGithubPage(ButtonWidget button) {
        this.client.setScreen(new ConfirmLinkScreen((confirmed) -> {
            if (confirmed) {
                Util.getOperatingSystem().open("http://aka.jonasjones.me/microcraft-github");
            }

            this.client.setScreen(this);
        }, "http://aka.jonasjones.me/microcraft-github", true));
    }

    private void openCurseforgePage(ButtonWidget button) {
        this.client.setScreen(new ConfirmLinkScreen((confirmed) -> {
            if (confirmed) {
                Util.getOperatingSystem().open("http://aka.jonasjones.me/microcraft-curseforge");
            }

            this.client.setScreen(this);
        }, "http://aka.jonasjones.me/microcraft-curseforge", true));
    }

    private void openHomepagePage(ButtonWidget button) {
        this.client.setScreen(new ConfirmLinkScreen((confirmed) -> {
            if (confirmed) {
                Util.getOperatingSystem().open("https://jonasjones.me/microcraft");
            }

            this.client.setScreen(this);
        }, "https://jonasjones.me/microcraft", true));
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
