//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.jonasjones.microcraft.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import me.jonasjones.microcraft.Microcraft;
import me.jonasjones.microcraft.board.MicrocontrollerBoardIcon;
import me.jonasjones.microcraft.gui.screens.ModCreditsScreen;
import me.jonasjones.microcraft.gui.screens.ModSettings;
import me.jonasjones.microcraft.gui.screens.board.AdvancedPinMappingScreen;
import me.jonasjones.microcraft.gui.screens.board.AdvancedSettingsScreen;
import me.jonasjones.microcraft.gui.screens.board.BoardIconSelectionScreen;
import me.jonasjones.microcraft.gui.screens.board.ProfileSelectionScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class BoardConfigwidget extends Screen {

    private final Screen parent;

    //public static Identifier BOARD_TEXTURE = new Identifier(Microcraft.MOD_ID, "textures/boards/arduino-nano.png");

    public static MicrocontrollerBoardIcon BOARD_TEXTURE = new MicrocontrollerBoardIcon(new ResourceLocation(Microcraft.MOD_ID, "textures/boards/arduino-nano-sideways.png"), new ResourceLocation(Microcraft.MOD_ID, "textures/boards/arduino-nano.png"), 128, 52);

    public BoardConfigwidget(Screen parent) {
        super(Component.literal("Microcraft Configuration"));
        this.parent = parent;
    }
    protected void init() {
        //TODO: get current profile
        addRenderableWidget(new Button.Builder(Component.literal("[Profile]"), (buttonWidget) -> this.minecraft.setScreen(new ProfileSelectionScreen(this))).bounds(this.width / 2 - 50, this.height - 52, 100, 20).build());

        //TODO: make Board texture clickable to select different texture.
        this.addRenderableWidget(new ImageButton(this.width / 2 - (BOARD_TEXTURE.height() / 2), this.height / 2 - (BOARD_TEXTURE.height() / 2) - 45, BOARD_TEXTURE.height(), BOARD_TEXTURE.width(), 0, 0, 0, BOARD_TEXTURE.boardTextureVertical(), BOARD_TEXTURE.height(), BOARD_TEXTURE.width(), (buttonWidget) -> this.minecraft.setScreen(new BoardIconSelectionScreen(this))));

        /*this.addRenderableWidget(ButtonWidget.builder(Component.literal("About Microcraft"), (buttonWidget) -> this.minecraft.setScreen(new ModCreditsScreen(this))).dimensions(10, this.height - 30, 200, 20).build());
        this.addRenderableWidget(ButtonWidget.builder(Component.literal("Advanced Pin Mapping"), (buttonWidget) -> this.minecraft.setScreen(new AdvancedPinMappingScreen(this))).dimensions(this.width / 2 - 100, this.height - 55, 200, 20).build());
        this.addRenderableWidget(ButtonWidget.builder(Component.literal("Advanced Board Settings"), (buttonWidget) -> this.minecraft.setScreen(new AdvancedSettingsScreen(this))).dimensions(this.width / 2 - 100, this.height - 80, 200, 20).build());
        this.addRenderableWidget(ButtonWidget.builder(Component.literal("Done"), (buttonWidget) -> this.minecraft.setScreen(this.parent)).dimensions(this.width - 60, this.height - 30, 50, 20).build());
        this.addRenderableWidget(ButtonWidget.builder(Component.literal("Write to Board and Quit"), (buttonWidget) -> this.minecraft.setScreen(this.parent)).dimensions(this.width - 210, this.height - 30, 140, 20).build());
        this.addRenderableWidget(ButtonWidget.builder(Component.literal("Microcraft Settings"), (buttonWidget) -> this.minecraft.setScreen(new ModSettings(this))).dimensions(this.width - 210, this.height - 55, 200, 20).build());*/

        this.addRenderableWidget(new Button.Builder(Component.literal("About"), (buttonWidget) -> this.minecraft.setScreen(new ModCreditsScreen(this)))
                .bounds(this.width / 2 - 154, this.height - 28, 75, 20).build());
        this.addRenderableWidget(new Button.Builder(Component.literal("Pin Mapping"), (buttonWidget) -> this.minecraft.setScreen(new AdvancedPinMappingScreen(this)))
                .bounds(this.width / 2 + 4 + 50, this.height - 52, 100, 20).build());
        this.addRenderableWidget(new Button.Builder(Component.literal("Board Settings"), (buttonWidget) -> this.minecraft.setScreen(new AdvancedSettingsScreen(this)))
                .bounds(this.width / 2 - 154, this.height - 52, 100, 20).build());
        this.addRenderableWidget(new Button.Builder(Component.literal("Done"), (buttonWidget) -> this.minecraft.setScreen(this.parent))
                .bounds(this.width / 2 + 4 + 76, this.height - 28, 75, 20).build());
        Button upload = this.addRenderableWidget(new Button.Builder(Component.literal("Upload"), (buttonWidget) -> this.minecraft.setScreen(this.parent))
                .bounds(this.width / 2, this.height - 28, 75, 20).build());
        upload.active = false;
        this.addRenderableWidget(new Button.Builder(Component.literal("Settings"), (buttonWidget) -> this.minecraft.setScreen(new ModSettings(this)))
                .bounds(this.width / 2 - 75, this.height - 28, 70, 20).build());


    }

    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredString(matrices, this.font, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }



}
