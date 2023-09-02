package com.favouriteless.createasnails.mixin;

import com.simibubi.create.AllEntityTypes;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import toughasnails.api.temperature.TemperatureLevel;
import toughasnails.temperature.TemperatureHandler;

@Mixin(TemperatureHandler.class)
public class MixinTemperatureHandler {

	@ModifyVariable(method = "onPlayerTick", at = @At("STORE"), ordinal = 1, remap = false)
	private TemperatureLevel changeTargetTemp(TemperatureLevel temp, PlayerTickEvent event) {
		if(event.player.getRootVehicle().getType() == AllEntityTypes.CARRIAGE_CONTRAPTION.get()) {
			if(temp == TemperatureLevel.ICY)
				return TemperatureLevel.COLD;
			else if(temp == TemperatureLevel.HOT)
				return TemperatureLevel.WARM;
		}

		return temp;
	}

}
