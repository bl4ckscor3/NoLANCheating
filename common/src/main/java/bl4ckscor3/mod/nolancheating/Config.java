package bl4ckscor3.mod.nolancheating;

import org.apache.commons.lang3.tuple.Pair;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;

public class Config {
	public static final ModConfigSpec CONFIG_SPEC;
	public static final Config CONFIG;
	public BooleanValue removeButtonInOpenToLANScreen, removeButtonInWorldOptionsScreen, removeButtonInCreateNewWorldScreen;

	static {
		Pair<Config, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Config::new);

		CONFIG_SPEC = specPair.getRight();
		CONFIG = specPair.getLeft();
	}

	public Config(ModConfigSpec.Builder builder) {
		removeButtonInOpenToLANScreen = builder
			.comment("Removes the \"Allow Commands\" button in the \"Open to LAN\" screen, if set to \"true\".")
			.define("removeButtonInOpenToLANScreen", true);

		removeButtonInWorldOptionsScreen = builder
			.comment("Removes the \"Allow Commands\" button in the \"World Options\" screen, if set to \"true\".")
			.define("removeButtonInWorldOptionsScreen", true);

		removeButtonInCreateNewWorldScreen = builder
			.comment("Removes the \"Allow Commands\" button in the \"Create New World\" screen, if set to \"true\".")
			.define("removeButtonInCreateNewWorldScreen", false);
	}
}