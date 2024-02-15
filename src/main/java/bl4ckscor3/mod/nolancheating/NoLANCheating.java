package bl4ckscor3.mod.nolancheating;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.ShareToLanScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

@Mod(NoLANCheating.MODID)
@EventBusSubscriber(modid = NoLANCheating.MODID, value = Dist.CLIENT)
public class NoLANCheating {
	public static final String MODID = "nolancheating";
	public static final ForgeConfigSpec CONFIG_SPEC;
	public static final Config CONFIG;
	public static final boolean IS_LAN_WORLD_PLUG_N_PLAY_INSTALLED = ModList.get().isLoaded("mcwifipnp");

	static {
		Pair<Config, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Config::new);

		CONFIG_SPEC = clientSpecPair.getRight();
		CONFIG = clientSpecPair.getLeft();
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onGuiInit(ScreenEvent.Init.Post event) {
		Screen screen = event.getScreen();

		if (screen instanceof ShareToLanScreen lanScreen) {
			if (CONFIG.removeButtonInOpenToLANScreen.get()) {
				AbstractButton commandsButton = (AbstractButton) lanScreen.renderables.get(1);
				AbstractButton modeButton = (AbstractButton) lanScreen.renderables.get(0);

				commandsButton.visible = false;
				centerButton(lanScreen, modeButton);
			}
		}
		else if (IS_LAN_WORLD_PLUG_N_PLAY_INSTALLED)
			LanWorldPlugNPlayCompat.check(screen);
	}

	public static void centerButton(Screen screen, AbstractButton modeButton) {
		modeButton.setX(screen.width / 2 - modeButton.getWidth() / 2);
	}

	public static class Config {
		public BooleanValue removeButtonInOpenToLANScreen, removeButtonInCreateNewWorldScreen;

		Config(ForgeConfigSpec.Builder builder) {
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
