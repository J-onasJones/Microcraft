package me.jonasjones.arduinoctrls.mixin;

import me.jonasjones.arduinoctrls.ArduinoControls;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class ArduinoMixin extends Screen {
	protected ArduinoMixin(Text title) {
		super(title);
	}

	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		ArduinoControls.LOGGER.info("This line is printed by an example mod mixin!");
	}

	@Inject(at = @At("RETURN"), method = "initWidgetsNormal")
	private void ledToggleButton(int y, int spacingY, CallbackInfo ci) {
		this.addDrawableChild(new ButtonWidget(50, 50, 20, 20,Text.of("LED"), (button) -> {
			this.client.scheduleStop();
		}));
	}
}