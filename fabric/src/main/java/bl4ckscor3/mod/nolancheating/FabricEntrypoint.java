package bl4ckscor3.mod.nolancheating;

import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import fuzs.forgeconfigapiport.fabric.api.v5.client.ConfigScreenFactoryRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;

public class FabricEntrypoint implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ConfigRegistry.INSTANCE.register(NoLANCheating.MODID, ModConfig.Type.CLIENT, Config.CONFIG_SPEC);
		ConfigScreenFactoryRegistry.INSTANCE.register(NoLANCheating.MODID, ConfigurationScreen::new);
	}
}
