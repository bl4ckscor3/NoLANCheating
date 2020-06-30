package bl4ckscor3.mod.nolancheating;

import net.minecraft.client.gui.screen.ShareToLanScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod(NoLANCheating.MODID)
@EventBusSubscriber(modid=NoLANCheating.MODID, value=Dist.CLIENT)
public class NoLANCheating
{
	public static final String MODID = "nolancheating";

	@SubscribeEvent
	public static void onGuiInit(InitGuiEvent.Post event)
	{
		if(event.getGui() instanceof ShareToLanScreen)
		{
			ShareToLanScreen screen = (ShareToLanScreen)event.getGui();

			screen.allowCheatsButton.field_230694_p_ = false; //visible
			screen.gameModeButton.field_230690_l_ = screen.field_230708_k_ / 2 - screen.gameModeButton.func_230998_h_() / 2; //x, width, getWidth
		}
	}
}
