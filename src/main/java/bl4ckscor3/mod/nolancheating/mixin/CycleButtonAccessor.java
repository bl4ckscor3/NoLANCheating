package bl4ckscor3.mod.nolancheating.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.client.gui.components.CycleButton;

@Mixin(CycleButton.class)
public interface CycleButtonAccessor {
	@Invoker
	public void callUpdateValue(Object value);
}
