package bl4ckscor3.mod.nolancheating.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.llamalad7.mixinextras.sugar.Local;

import bl4ckscor3.mod.nolancheating.Config;
import net.minecraft.client.gui.components.CycleButton;

@Mixin(targets = "net.minecraft.client.gui.screens.worldselection.CreateWorldScreen$GameTab")
public class GameTabMixin {
	@Inject(method = "<init>", at = @At("TAIL"))
	private void nolancheating$maybeRemoveAllowCommandsButton(CallbackInfo ci, @Local(ordinal = 2) CycleButton<Boolean> allowCommandsButton) {
		if (Config.CONFIG.removeButtonInCreateNewWorldScreen.get())
			allowCommandsButton.visible = false;
	}
}
