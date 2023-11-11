package bl4ckscor3.mod.nolancheating;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.screens.ShareToLanScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;

@Mod(NoLANCheating.MODID)
@EventBusSubscriber(modid = NoLANCheating.MODID, value = Dist.CLIENT)
public class NoLANCheating {
	public static final String MODID = "nolancheating";
	public static final ModConfigSpec CONFIG_SPEC;
	public static final Config CONFIG;

	static {
		Pair<Config, ModConfigSpec> clientSpecPair = new ModConfigSpec.Builder().configure(Config::new);

		CONFIG_SPEC = clientSpecPair.getRight();
		CONFIG = clientSpecPair.getLeft();
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onGuiInit(ScreenEvent.Init.Post event) {
		if (event.getScreen() instanceof ShareToLanScreen screen && CONFIG.removeButtonInOpenToLANScreen.get()) {
			AbstractButton commandsButton = (AbstractButton) screen.renderables.get(1);
			AbstractButton modeButton = (AbstractButton) screen.renderables.get(0);

			commandsButton.visible = false;
			modeButton.setX(screen.width / 2 - modeButton.getWidth() / 2);
		}
	}

	public static class Config {
		public BooleanValue removeButtonInOpenToLANScreen, removeButtonInCreateNewWorldScreen;

		Config(ModConfigSpec.Builder builder) {
			//@formatter:off
			removeButtonInOpenToLANScreen = builder
					.comment("Removes the \"Allow Cheats\" button in the \"Open to LAN\" screen, if set to \"true\".")
					.define("removeButtonInOpenToLANScreen", true);

			removeButtonInCreateNewWorldScreen = builder
					.comment("Removes the \"Allow Cheats\" button in the \"Create New World\" screen, if set to \"true\".")
					.define("removeButtonInCreateNewWorldScreen", false);
		}
	}
}
