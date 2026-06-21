package bl4ckscor3.mod.nolancheating.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import bl4ckscor3.mod.nolancheating.Config;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.screens.options.WorldOptionsScreen;

@Mixin(WorldOptionsScreen.class)
public class WorldOptionsScreenMixin {
	@WrapOperation(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/layouts/GridLayout$RowHelper;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;", ordinal = 3))
	private LayoutElement nolancheating$maybeRemoveAllowCommandsButton(GridLayout.RowHelper instance, LayoutElement widget, Operation<LayoutElement> original) {
		if (Config.CONFIG.removeButtonInWorldOptionsScreen.get())
			return null;
		else
			return original.call(instance, widget);
	}
}
