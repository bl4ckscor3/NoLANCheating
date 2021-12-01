package bl4ckscor3.mod.nolancheating;

import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.screens.ShareToLanScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent.InitScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod(NoLANCheating.MODID)
@EventBusSubscriber(modid=NoLANCheating.MODID, value=Dist.CLIENT)
public class NoLANCheating
{
	public static final String MODID = "nolancheating";

	@SubscribeEvent
	public static void onGuiInit(InitScreenEvent.Post event)
	{
		if(event.getScreen() instanceof ShareToLanScreen)
		{
			ShareToLanScreen screen = (ShareToLanScreen)event.getScreen();
			AbstractButton commandsButton = (AbstractButton)screen.renderables.get(1);
			AbstractButton modeButton = (AbstractButton)screen.renderables.get(0);

			commandsButton.visible = false;
			modeButton.x = screen.width / 2 - modeButton.getWidth() / 2;
		}
	}
}
