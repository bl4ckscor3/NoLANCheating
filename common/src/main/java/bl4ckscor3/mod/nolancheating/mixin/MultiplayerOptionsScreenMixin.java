package bl4ckscor3.mod.nolancheating.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import bl4ckscor3.mod.nolancheating.Config;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.MultiplayerOptionsScreen;

@Mixin(MultiplayerOptionsScreen.class)
public class MultiplayerOptionsScreenMixin {
	@WrapOperation(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/layouts/LinearLayout;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;", ordinal = 7))
	private LayoutElement nolancheating$maybeRemoveAllowCommandsButton(LinearLayout instance, LayoutElement child, Operation<LayoutElement> original) {
		if (Config.CONFIG.removeButtonInOpenToLANScreen.get())
			return child;
		else
			return original.call(instance, child);
	}
}
