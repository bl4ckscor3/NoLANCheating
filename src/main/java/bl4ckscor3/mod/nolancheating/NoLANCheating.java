package bl4ckscor3.mod.nolancheating;

import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.screens.ShareToLanScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod(NoLANCheating.MODID)
@EventBusSubscriber(modid = NoLANCheating.MODID, value = Dist.CLIENT)
public class NoLANCheating {
	public static final String MODID = "nolancheating";

	@SubscribeEvent
	public static void onGuiInit(ScreenEvent.Init.Post event) {
		if (event.getScreen() instanceof ShareToLanScreen screen) {
			AbstractButton commandsButton = (AbstractButton) screen.renderables.get(1);
			AbstractButton modeButton = (AbstractButton) screen.renderables.get(0);

			commandsButton.visible = false;
			modeButton.setX(screen.width / 2 - modeButton.getWidth() / 2);
		}
	}
}
