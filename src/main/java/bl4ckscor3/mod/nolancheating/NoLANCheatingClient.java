package bl4ckscor3.mod.nolancheating;

import java.util.List;

import bl4ckscor3.mod.nolancheating.mixin.ScreenAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.ShareToLanScreen;

public class NoLANCheatingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
			if (screen instanceof ShareToLanScreen && NoLANCheating.CONFIG.removeButtonInOpenToLANScreen) {
				List<Renderable> renderables = ((ScreenAccessor) screen).getRenderables();
				AbstractButton commandsButton = (AbstractButton) renderables.get(1);
				AbstractButton modeButton = (AbstractButton) renderables.get(0);

				commandsButton.visible = false;
				modeButton.setX(screen.width / 2 - modeButton.getWidth() / 2);
			}
		});
	}
}
