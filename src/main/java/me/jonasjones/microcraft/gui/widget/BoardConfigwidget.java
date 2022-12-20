//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.jonasjones.microcraft.gui.widget;

import me.jonasjones.microcraft.Microcraft;
import me.jonasjones.microcraft.board.MicrocontrollerBoardIcon;
import me.jonasjones.microcraft.gui.screens.ModSettings;
import me.jonasjones.microcraft.gui.screens.board.AdvancedPinMappingScreen;
import me.jonasjones.microcraft.gui.screens.board.AdvancedSettingsScreen;
import me.jonasjones.microcraft.gui.screens.board.BoardIconSelectionScreen;
import me.jonasjones.microcraft.gui.screens.board.ProfileSelectionScreen;
import me.jonasjones.microcraft.gui.screens.ModCreditsScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;

@Environment(EnvType.CLIENT)
public class BoardConfigwidget extends Screen {

    private final Screen parent;

    //public static Identifier BOARD_TEXTURE = new Identifier(Microcraft.MOD_ID, "textures/boards/arduino-nano.png");

    public static MicrocontrollerBoardIcon BOARD_TEXTURE = new MicrocontrollerBoardIcon(new Identifier(Microcraft.MOD_ID, "textures/boards/arduino-nano-sideways.png"), new Identifier(Microcraft.MOD_ID, "textures/boards/arduino-nano.png"), 128, 52);

    public BoardConfigwidget(Screen parent) {
        super(Text.of("Microcraft Configuration"));
        this.parent = parent;
    }
    protected void init() {
        //TODO: get current profile
        addDrawableChild(ButtonWidget.builder(Text.of("[Profile]"), (buttonWidget) -> this.client.setScreen(new ProfileSelectionScreen(this))).dimensions(this.width / 2 - 50, this.height - 52, 100, 20).build());

        //TODO: make Board texture clickable to select different texture.
        this.addDrawableChild(new TexturedButtonWidget(this.width / 2 - (BOARD_TEXTURE.height() / 2), this.height / 2 - (BOARD_TEXTURE.height() / 2) - 45, BOARD_TEXTURE.height(), BOARD_TEXTURE.width(), 0, 0, 0, BOARD_TEXTURE.boardTextureVertical(), BOARD_TEXTURE.height(), BOARD_TEXTURE.width(), (buttonWidget) -> this.client.setScreen(new BoardIconSelectionScreen(this))));

        /*this.addDrawableChild(ButtonWidget.builder(Text.of("About Microcraft"), (buttonWidget) -> this.client.setScreen(new ModCreditsScreen(this))).dimensions(10, this.height - 30, 200, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Advanced Pin Mapping"), (buttonWidget) -> this.client.setScreen(new AdvancedPinMappingScreen(this))).dimensions(this.width / 2 - 100, this.height - 55, 200, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Advanced Board Settings"), (buttonWidget) -> this.client.setScreen(new AdvancedSettingsScreen(this))).dimensions(this.width / 2 - 100, this.height - 80, 200, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Done"), (buttonWidget) -> this.client.setScreen(this.parent)).dimensions(this.width - 60, this.height - 30, 50, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Write to Board and Quit"), (buttonWidget) -> this.client.setScreen(this.parent)).dimensions(this.width - 210, this.height - 30, 140, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Microcraft Settings"), (buttonWidget) -> this.client.setScreen(new ModSettings(this))).dimensions(this.width - 210, this.height - 55, 200, 20).build());*/

        this.addDrawableChild(ButtonWidget.builder(Text.of("About"), (buttonWidget) -> this.client.setScreen(new ModCreditsScreen(this)))
                .dimensions(this.width / 2 - 154, this.height - 28, 75, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Pin Mapping"), (buttonWidget) -> this.client.setScreen(new AdvancedPinMappingScreen(this)))
                .dimensions(this.width / 2 + 4 + 50, this.height - 52, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Board Settings"), (buttonWidget) -> this.client.setScreen(new AdvancedSettingsScreen(this)))
                .dimensions(this.width / 2 - 154, this.height - 52, 100, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Done"), (buttonWidget) -> this.client.setScreen(this.parent))
                .dimensions(this.width / 2 + 4 + 76, this.height - 28, 75, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Save"), (buttonWidget) -> this.client.setScreen(this.parent))
                .dimensions(this.width / 2, this.height - 28, 75 , 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.of("Settings"), (buttonWidget) -> this.client.setScreen(new ModSettings(this)))
                .dimensions(this.width / 2 - 75, this.height - 28, 70, 20).build());


    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }



}
