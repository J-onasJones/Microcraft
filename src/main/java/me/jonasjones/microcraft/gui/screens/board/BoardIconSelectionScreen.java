package me.jonasjones.microcraft.gui.screens.board;

import me.jonasjones.microcraft.Microcraft;
import me.jonasjones.microcraft.board.MicrocontrollerBoardIcon;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static me.jonasjones.microcraft.gui.widget.BoardConfigwidget.BOARD_TEXTURE;

public class BoardIconSelectionScreen extends Screen {

    private final Screen parent;

    private final MicrocontrollerBoardIcon NANO_BOARD_TEXTURE = new MicrocontrollerBoardIcon(new Identifier(Microcraft.MOD_ID, "textures/boards/arduino-nano-sideways.png"), new Identifier(Microcraft.MOD_ID, "textures/boards/arduino-nano.png"), 128, 52);
    private final MicrocontrollerBoardIcon UNO_BOARD_TEXTURE = new MicrocontrollerBoardIcon(new Identifier(Microcraft.MOD_ID, "textures/boards/arduino-uno-sideways.png"), new Identifier(Microcraft.MOD_ID, "textures/boards/arduino-uno.png"), 128, 90);
    private final MicrocontrollerBoardIcon PROMINI_BOARD_TEXTURE = new MicrocontrollerBoardIcon(new Identifier(Microcraft.MOD_ID, "textures/boards/arduino-pro_mini-sideways.png"), new Identifier(Microcraft.MOD_ID, "textures/boards/arduino-pro_mini.png"), 97, 52);

    public BoardIconSelectionScreen(Screen parent) {
        super(Text.of("Select Board Icon"));
        this.parent = parent;
    }

    protected void init() {
        this.addDrawableChild(new TexturedButtonWidget(this.width / 2 - 138, this.height / 2 - 85, NANO_BOARD_TEXTURE.width(), NANO_BOARD_TEXTURE.height(), 0, 0, 0, NANO_BOARD_TEXTURE.boardTextureHorizontal(), NANO_BOARD_TEXTURE.width(), NANO_BOARD_TEXTURE.height(), (buttonWidget) -> {
            BOARD_TEXTURE = NANO_BOARD_TEXTURE;
            this.client.setScreen(this.parent);
        }));
        this.addDrawableChild(new TexturedButtonWidget(this.width / 2 - 138, this.height / 2 - 20, UNO_BOARD_TEXTURE.width(), UNO_BOARD_TEXTURE.height(), 0, 0, 0, UNO_BOARD_TEXTURE.boardTextureHorizontal(), UNO_BOARD_TEXTURE.width(), UNO_BOARD_TEXTURE.height(), (buttonWidget) -> {
            BOARD_TEXTURE = UNO_BOARD_TEXTURE;
            this.client.setScreen(this.parent);
        }));
        this.addDrawableChild(new TexturedButtonWidget(this.width / 2 + 10, this.height / 2 - 85, PROMINI_BOARD_TEXTURE.width(), PROMINI_BOARD_TEXTURE.height(), 0, 0, 0, PROMINI_BOARD_TEXTURE.boardTextureHorizontal(), PROMINI_BOARD_TEXTURE.width(), PROMINI_BOARD_TEXTURE.height(), (buttonWidget) -> {
            BOARD_TEXTURE = PROMINI_BOARD_TEXTURE;
            this.client.setScreen(this.parent);
        }));
        this.addDrawableChild(ButtonWidget.builder(Text.of("Cancel"), (button) -> {
            this.client.setScreen(this.parent);
        }).dimensions(this.width / 2 - 100, this.height / 6 + 168, 200, 20).build());
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
