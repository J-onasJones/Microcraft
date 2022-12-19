package me.jonasjones.microcraft.mixin;

import me.jonasjones.microcraft.gui.screens.BoardScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static me.jonasjones.microcraft.Microcraft.MOD_ID;

@Mixin(TitleScreen.class)
public abstract class TitleScreenButtonMixin extends Screen {
	protected TitleScreenButtonMixin(Text title) {
		super(title);
	}

	@Inject(at = @At("RETURN"), method = "initWidgetsNormal")
	private void titleScreenButton(int y, int spacingY, CallbackInfo ci) {

		final Identifier ICON_TEXTURE = new Identifier(MOD_ID, "textures/gui/button_icon.png");

		int buttonX = this.width / 2 + 104;
		int buttonY = y + spacingY * 2;

		this.addDrawableChild(ButtonWidget.builder( Text.of(""), (button) -> {
			this.client.setScreen(new BoardScreen(this));
		}).dimensions(buttonX, buttonY, 20, 20).build());
		this.addDrawableChild( new TexturedButtonWidget(buttonX, buttonY, 20, 20, 0, 0, 0, ICON_TEXTURE, 20, 20, (buttonWidget) -> this.client.setScreen(new BoardScreen(this))));
	}
}