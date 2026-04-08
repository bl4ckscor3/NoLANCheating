package bl4ckscor3.mod.nolancheating;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = NoLANCheating.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(Dist.CLIENT)
public class NeoEntrypoint {
	public NeoEntrypoint(ModContainer modContainer) {
		modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
		modContainer.registerConfig(ModConfig.Type.CLIENT, Config.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onGuiInit(ScreenEvent.Init.Post event) {
		NoLANCheating.handleVanillaScreen(event.getScreen());
	}
}
