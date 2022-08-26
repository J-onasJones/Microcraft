//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.jonasjones.microcraft.gui.widget;

import me.jonasjones.microcraft.Microcraft;
import me.jonasjones.microcraft.gui.screens.ModSettings;
import me.jonasjones.microcraft.gui.screens.board.AdvancedPinMappingScreen;
import me.jonasjones.microcraft.gui.screens.board.AdvancedSettingsScreen;
import me.jonasjones.microcraft.gui.screens.board.ProfileSelectionScreen;
import me.jonasjones.microcraft.gui.screens.ModCreditsScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ScrollableWidget;

@Environment(EnvType.CLIENT)
public class ArduinoNanoWidget extends Screen {

    private final Screen parent;

    Identifier BOARD_TEXTURE = new Identifier(Microcraft.MOD_ID, "textures/boards/arduino-nano.png");

    public ArduinoNanoWidget (Screen parent) {
        super(Text.of("Microcraft Configuration"));
        this.parent = parent;
    }
    protected void init() {
        //TODO: get current profile
        addDrawableChild(new ButtonWidget(this.width / 2 - 100, 40, 200, 20, Text.of("[Profile]"), (buttonWidget) -> this.client.setScreen(new ProfileSelectionScreen(this))));

        //TODO: make Board texture clickable to select different texture.
        this.addDrawableChild(new TexturedButtonWidget(this.width / 2 - 26, this.height / 2 - 65, 52, 130, 0, 0, 130, BOARD_TEXTURE, 52, 130, (buttonWidget) -> this.client.setScreen(this)));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height - 30, 200, 20, Text.of("About Microcraft"), (buttonWidget) -> this.client.setScreen(new ModCreditsScreen(this))));
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height - 55, 200, 20, Text.of("Advanced Pin Mapping"), (buttonWidget) -> this.client.setScreen(new AdvancedPinMappingScreen(this))));
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height - 80, 200, 20, Text.of("Advanced Board Settings"), (buttonWidget) -> this.client.setScreen(new AdvancedSettingsScreen(this))));
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height - 105, 200, 20, getToggleText(), (buttonWidget) -> Microcraft.toggle()));
        this.addDrawableChild(new ButtonWidget(this.width - 60, this.height - 30, 50, 20, Text.of("Done"), (buttonWidget) -> this.client.setScreen(this.parent)));
        this.addDrawableChild(new ButtonWidget(this.width - 210, this.height - 30, 140, 20, Text.of("Write Program to Board"), (buttonWidget) -> this.client.setScreen(this.parent)));
        this.addDrawableChild(new ButtonWidget(this.width - 210, this.height - 55, 200, 20, Text.of("Microcraft Settings"), (buttonWidget) -> this.client.setScreen(new ModSettings(this))));

        this.addDrawableChild(new )

    }
    private Text getToggleText() {
        if (Microcraft.enabled) {
            return Text.of("Microcraft: enabled");
        } else {
            return Text.of("Microcraft: disabled");
        }
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }



}
