package me.jonasjones.microcraft.gui.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.Util;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

@Environment(EnvType.CLIENT)
public class ModCreditsScreen extends Screen {

    private final Screen parent;

    public ModCreditsScreen(Screen parent) {
        super(Component.nullToEmpty("About Microcraft"));
        this.parent = parent;
    }

    protected void init() {
        this.addRenderableWidget(Button.builder(Component.nullToEmpty("Modrinth"), this::openModrinthPage).bounds(this.width / 2 - 155, this.height / 6 + 12, 100, 20).build());
        this.addRenderableWidget(Button.builder(Component.nullToEmpty("GitHub"), this::openGithubPage).bounds(this.width / 2 - 50, this.height / 6 + 12, 100, 20).build());
        this.addRenderableWidget(Button.builder(Component.nullToEmpty("Curseforge"), this::openCurseforgePage).bounds(this.width / 2 + 55, this.height / 6 + 12, 100, 20).build());
        this.addRenderableWidget(Button.builder(Component.nullToEmpty("Homepage"), this::openHomepagePage).bounds(this.width / 2 - 155, this.height / 6 + 35, 310, 20).build());

        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, (button) -> {
            this.minecraft.setScreen(this.parent);
        }).bounds(this.width / 2 - 100, this.height / 6 + 168, 200, 20).build());
    }

    private void openModrinthPage(Button button) {
        this.minecraft.setScreen(new ConfirmLinkScreen((confirmed) -> {
            if (confirmed) {
                Util.getPlatform().openUri("http://aka.jonasjones.me/microcraft-modrinth");
            }

            this.minecraft.setScreen(this);
        }, "http://aka.jonasjones.me/microcraft-modrinth", true));
    }

    private void openGithubPage(Button button) {
        this.minecraft.setScreen(new ConfirmLinkScreen((confirmed) -> {
            if (confirmed) {
                Util.getPlatform().openUri("http://aka.jonasjones.me/microcraft-github");
            }

            this.minecraft.setScreen(this);
        }, "http://aka.jonasjones.me/microcraft-github", true));
    }

    private void openCurseforgePage(Button button) {
        this.minecraft.setScreen(new ConfirmLinkScreen((confirmed) -> {
            if (confirmed) {
                Util.getPlatform().openUri("http://aka.jonasjones.me/microcraft-curseforge");
            }

            this.minecraft.setScreen(this);
        }, "http://aka.jonasjones.me/microcraft-curseforge", true));
    }

    private void openHomepagePage(Button button) {
        this.minecraft.setScreen(new ConfirmLinkScreen((confirmed) -> {
            if (confirmed) {
                Util.getPlatform().openUri("https://jonasjones.me/microcraft");
            }

            this.minecraft.setScreen(this);
        }, "https://jonasjones.me/microcraft", true));
    }

    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredString(matrices, this.font, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
