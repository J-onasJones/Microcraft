package me.jonasjones.arduinoctrls.mixin;

import me.jonasjones.arduinoctrls.gui.screens.GuiHome;
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

@Mixin(TitleScreen.class)
public abstract class ArduinoMixin extends Screen {
	protected ArduinoMixin(Text title) {
		super(title);
	}

	@Inject(at = @At("RETURN"), method = "initWidgetsNormal")
	private void titleScreenButton(int y, int spacingY, CallbackInfo ci) {

		final Identifier ICON_TEXTURE = new Identifier("arduinoctrls", "gui/button_icon.png");

		int buttonX = this.width / 2 + 104;
		int buttonY = y + spacingY * 2;

		this.addDrawableChild(new ButtonWidget(buttonX, buttonY, 20, 20, Text.of(""), (button) -> {
			this.client.setScreen(new GuiHome(this));
		}));
		this.addDrawableChild( new TexturedButtonWidget(buttonX, buttonY, 20, 20, 0, 0, 0, ICON_TEXTURE, 20, 20, (buttonWidget) -> this.client.setScreen(new GuiHome(this))));
	}
}