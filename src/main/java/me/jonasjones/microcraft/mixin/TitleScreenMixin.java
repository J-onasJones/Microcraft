package me.jonasjones.microcraft.mixin;

import me.jonasjones.microcraft.gui.screens.BoardScreen;
import me.jonasjones.microcraft.gui.screens.GuiHome;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.intellij.lang.annotations.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.Image;

import static me.jonasjones.microcraft.Microcraft.MOD_ID;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    // todo: find a way to get rid
    protected TitleScreenMixin(Component component) {
        super(component);
    }

//    @Inject(at = @At("HEAD"), method = "init")
//    private void gameMenuScreenButton(CallbackInfo ci) {
//        final ResourceLocation ICON_TEXTURE = new ResourceLocation(MOD_ID, "gui/button_icon.png");
//
//        int buttonX = this.width / 2 + 108;
//        int buttonY = 3 * this.height / 4 + 8;
//
//        this.addRenderableWidget(new Button.Builder(Component.empty(), (b) -> {
//            this.minecraft.setScreen(new GuiHome(this));
//        }).bounds(buttonX, buttonY, 20, 20).build());
//
////        this.addRenderableWidget(new ImageButton(buttonX, buttonY,
////                                                 20, 20,
////                                                 0, 0, 0,
////                                                 ICON_TEXTURE,
////                                                 20, 20,
////                                                 (buttonWidget) -> this.minecraft.setScreen(new GuiHome(this))
////        ));
//    }

    @Inject(at = @At("RETURN"), method = "createNormalMenuOptions")
	private void titleScreenButton(int y, int spacingY, CallbackInfo ci) {

        final ResourceLocation ICON_TEXTURE = new ResourceLocation(MOD_ID, "textures/gui/button_icon.png");

        int buttonX = this.width / 2 + 104;
        int buttonY = y + spacingY * 2;

//        this.addRenderableWidget(new Button.Builder(Component.literal(""), (button) -> {
//            this.minecraft.setScreen(new BoardScreen(this));
//        }).bounds(buttonX, buttonY, 20, 20).build());

        this.addRenderableWidget(new ImageButton(buttonX, buttonY, 20, 20, 0, 0, 0, ICON_TEXTURE, 20, 20,
                                                 (buttonWidget) -> this.minecraft.setScreen(new BoardScreen(this))));
    }
}
