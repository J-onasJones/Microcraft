package me.jonasjones.microcraft.gui.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;


@Environment(EnvType.CLIENT)
public class ModSettings extends Screen {
    private final Screen parent;

    public ModSettings (Screen parent) {
        super(Component.nullToEmpty("MicrocontrollerMC Controls"));
        this.parent = parent;
    }
    protected void init() {


        this.addRenderableWidget(Button.builder(Component.nullToEmpty("Configure Microcontrollers"), (button) -> {
            this.minecraft.setScreen(new SelectDevice(this));
        }).bounds(this.width / 2 - 155, this.height / 6 + 12, 150, 20).build());

        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, (button) -> {
            this.minecraft.setScreen(this.parent);
        }).bounds(this.width / 2 - 100, this.height / 6 + 168, 200, 20).build());
    }

    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredString(matrices, this.font, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}