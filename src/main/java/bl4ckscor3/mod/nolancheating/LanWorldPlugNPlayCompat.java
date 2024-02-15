package bl4ckscor3.mod.nolancheating;

import java.util.List;

import bl4ckscor3.mod.nolancheating.mixin.CycleButtonAccessor;
import bl4ckscor3.mod.nolancheating.mixin.ScreenAccessor;
import io.github.satxm.mcwifipnp.ShareToLanScreenNew;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.level.GameType;

public class LanWorldPlugNPlayCompat {
	private LanWorldPlugNPlayCompat() {}

	public static void check(Screen screen) {
		if (screen instanceof ShareToLanScreenNew && NoLANCheating.CONFIG.removeButtonInOpenToLANScreen) {
			List<Renderable> renderables = ((ScreenAccessor) screen).getRenderables();
			CycleButton<GameType> gamemodeButton = (CycleButton<GameType>) renderables.get(2);
			CycleButton<Boolean> allowCheatsButton = (CycleButton<Boolean>) renderables.get(3);
			CycleButton<Boolean> otherPlayersCheatButton = (CycleButton<Boolean>) renderables.get(7);
			CycleButton<Boolean> whitelistButton = (CycleButton<Boolean>) renderables.get(8);

			((CycleButtonAccessor) allowCheatsButton).callUpdateValue(false);
			allowCheatsButton.visible = false;
			NoLANCheatingClient.centerButton(screen, gamemodeButton);
			otherPlayersCheatButton.visible = false;
			NoLANCheatingClient.centerButton(screen, whitelistButton);
		}
	}
}
