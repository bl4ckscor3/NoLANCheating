package bl4ckscor3.mod.nolancheating;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.fabricmc.api.ModInitializer;

public class NoLANCheating implements ModInitializer {
	public static final Configuration CONFIG = AutoConfig.register(Configuration.class, JanksonConfigSerializer::new).getConfig();

	@Override
	public void onInitialize() {}

	//@formatter:off
	@Config(name = "nolancheating")
	public static class Configuration implements ConfigData {
		@Comment("Removes the \"Allow Cheats\" button in the \"Open to LAN\" screen.")
		public boolean removeButtonInOpenToLANScreen = true;

		@Comment("Removes the \"Allow Cheats\" button in the \"Create New World\" screen.")
		public boolean removeButtonInCreateNewWorldScreen = false;
	}
}
