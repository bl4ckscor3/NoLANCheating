package bl4ckscor3.mod.nolancheating.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import bl4ckscor3.mod.nolancheating.NoLANCheating;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.layouts.LayoutElement;

@Mixin(targets = "io.github.satxm.mcwifipnp.client.ShareToLanScreenNew$DefaultTab1")
public class ShareToLanScreenNewDefaultTab1Mixin {
	@WrapOperation(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/layouts/GridLayout$RowHelper;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;I)Lnet/minecraft/client/gui/layouts/LayoutElement;", ordinal = 1))
	private LayoutElement addHostCheatButton(GridLayout.RowHelper instance, LayoutElement widget, int columnWidth, Operation<LayoutElement> original) {
		if (NoLANCheating.CONFIG.removeButtonInOpenToLANScreen.get())
			return null;
		else
			return original.call(instance, widget, columnWidth);
	}
}
