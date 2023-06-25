package me.jonasjones.microcraft.gui.screens.board;

import com.mojang.blaze3d.vertex.PoseStack;
import me.jonasjones.microcraft.Microcraft;
import me.jonasjones.microcraft.board.MicrocontrollerBoardIcon;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static me.jonasjones.microcraft.gui.widget.BoardConfigwidget.BOARD_TEXTURE;

public class BoardIconSelectionScreen extends Screen {

    private final Screen parent;

    private final MicrocontrollerBoardIcon NANO_BOARD_TEXTURE = new MicrocontrollerBoardIcon(new ResourceLocation(Microcraft.MOD_ID, "textures/boards/arduino-nano-sideways.png"), new ResourceLocation(Microcraft.MOD_ID, "textures/boards/arduino-nano.png"), 128, 52);
    private final MicrocontrollerBoardIcon UNO_BOARD_TEXTURE = new MicrocontrollerBoardIcon(new ResourceLocation(Microcraft.MOD_ID, "textures/boards/arduino-uno-sideways.png"), new ResourceLocation(Microcraft.MOD_ID, "textures/boards/arduino-uno.png"), 128, 90);
    private final MicrocontrollerBoardIcon PROMINI_BOARD_TEXTURE = new MicrocontrollerBoardIcon(new ResourceLocation(Microcraft.MOD_ID, "textures/boards/arduino-pro_mini-sideways.png"), new ResourceLocation(Microcraft.MOD_ID, "textures/boards/arduino-pro_mini.png"), 97, 52);

    public BoardIconSelectionScreen(Screen parent) {
        super(Component.nullToEmpty("Select Board Icon"));
        this.parent = parent;
    }

    protected void init() {
        this.addRenderableWidget(new ImageButton(this.width / 2 - 138, this.height / 2 - 85, NANO_BOARD_TEXTURE.width(), NANO_BOARD_TEXTURE.height(), 0, 0, 0, NANO_BOARD_TEXTURE.boardTextureHorizontal(), NANO_BOARD_TEXTURE.width(), NANO_BOARD_TEXTURE.height(), (buttonWidget) -> {
            BOARD_TEXTURE = NANO_BOARD_TEXTURE;
            this.minecraft.setScreen(this.parent);
        }));
        this.addRenderableWidget(new ImageButton(this.width / 2 - 138, this.height / 2 - 20, UNO_BOARD_TEXTURE.width(), UNO_BOARD_TEXTURE.height(), 0, 0, 0, UNO_BOARD_TEXTURE.boardTextureHorizontal(), UNO_BOARD_TEXTURE.width(), UNO_BOARD_TEXTURE.height(), (buttonWidget) -> {
            BOARD_TEXTURE = UNO_BOARD_TEXTURE;
            this.minecraft.setScreen(this.parent);
        }));
        this.addRenderableWidget(new ImageButton(this.width / 2 + 10, this.height / 2 - 85, PROMINI_BOARD_TEXTURE.width(), PROMINI_BOARD_TEXTURE.height(), 0, 0, 0, PROMINI_BOARD_TEXTURE.boardTextureHorizontal(), PROMINI_BOARD_TEXTURE.width(), PROMINI_BOARD_TEXTURE.height(), (buttonWidget) -> {
            BOARD_TEXTURE = PROMINI_BOARD_TEXTURE;
            this.minecraft.setScreen(this.parent);
        }));
        this.addRenderableWidget(Button.builder(Component.nullToEmpty("Cancel"), (button) -> {
            this.minecraft.setScreen(this.parent);
        }).bounds(this.width / 2 - 100, this.height / 6 + 168, 200, 20).build());
    }

    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredString(matrices, this.font, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
