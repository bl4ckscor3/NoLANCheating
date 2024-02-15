package bl4ckscor3.mod.nolancheating;

import bl4ckscor3.mod.nolancheating.mixin.CycleButtonAccessor;
import io.github.satxm.mcwifipnp.ShareToLanScreenNew;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.level.GameType;

public class LanWorldPlugNPlayCompat {
	private LanWorldPlugNPlayCompat() {}

	public static void check(Screen screen) {
		if (screen instanceof ShareToLanScreenNew lanScreen && NoLANCheating.CONFIG.removeButtonInOpenToLANScreen.get()) {
			CycleButton<GameType> gamemodeButton = (CycleButton<GameType>) lanScreen.renderables.get(2);
			CycleButton<Boolean> allowCheatsButton = (CycleButton<Boolean>) lanScreen.renderables.get(3);
			CycleButton<Boolean> otherPlayersCheatButton = (CycleButton<Boolean>) lanScreen.renderables.get(7);
			CycleButton<Boolean> whitelistButton = (CycleButton<Boolean>) lanScreen.renderables.get(8);

			((CycleButtonAccessor) allowCheatsButton).callUpdateValue(false);
			allowCheatsButton.visible = false;
			NoLANCheating.centerButton(lanScreen, gamemodeButton);
			otherPlayersCheatButton.visible = false;
			NoLANCheating.centerButton(lanScreen, whitelistButton);
		}
	}
}
