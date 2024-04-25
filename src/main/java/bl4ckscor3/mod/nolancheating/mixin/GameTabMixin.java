package bl4ckscor3.mod.nolancheating.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import bl4ckscor3.mod.nolancheating.NoLANCheating;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.layouts.LayoutSettings;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import net.minecraft.world.Difficulty;

@Mixin(targets = "net.minecraft.client.gui.screens.worldselection.CreateWorldScreen$GameTab")
public class GameTabMixin {
	@Inject(method = "<init>", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILSOFT)
	private void nolancheating$maybeRemoveAllowCommandsButton(CreateWorldScreen this$0, CallbackInfo ci, GridLayout.RowHelper gridlayout$rowhelper, LayoutSettings layoutsettings, CycleButton<WorldCreationUiState.SelectedGameMode> gamemodeButton, CycleButton<Difficulty> difficultyButton, CycleButton<Boolean> allowCommandsButton) {
		if (NoLANCheating.CONFIG.removeButtonInCreateNewWorldScreen)
			allowCommandsButton.visible = false;
	}
}
