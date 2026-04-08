package bl4ckscor3.mod.nolancheating;

import java.util.List;

import bl4ckscor3.mod.nolancheating.mixin.ScreenAccessor;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.ShareToLanScreen;

public class NoLANCheating {
	public static final String MODID = "nolancheating";

	public static void handleVanillaScreen(Screen screen) {
		if (screen instanceof ShareToLanScreen lanScreen) {
			if (Config.CONFIG.removeButtonInOpenToLANScreen.get()) {
				List<Renderable> renderables = ((ScreenAccessor) screen).getRenderables();
				AbstractButton commandsButton = (AbstractButton) renderables.get(1);
				AbstractButton modeButton = (AbstractButton) renderables.get(0);

				commandsButton.visible = false;
				centerButton(lanScreen, modeButton);
			}
		}
	}

	public static void centerButton(Screen screen, AbstractButton modeButton) {
		modeButton.setX(screen.width / 2 - modeButton.getWidth() / 2);
	}
}
