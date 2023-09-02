package com.favouriteless.createasnails.mixin;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock.HeatLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toughasnails.temperature.TemperatureHelperImpl;

import java.util.Set;

@Mixin(TemperatureHelperImpl.class)
public class MixinTemperatureHelperImpl {

	@Inject(method="addHeatingOrCooling", at=@At("HEAD"), remap = false)
	private static void addHeatingOrCooling(Set<BlockPos> checked, Set<BlockPos> heating, Set<BlockPos> cooling, Level level, BlockPos pos, CallbackInfo ci) {
		BlockState state = level.getBlockState(pos);
		if(state.is(AllBlocks.BLAZE_BURNER.get())) {
			if(state.getValue(BlazeBurnerBlock.HEAT_LEVEL).isAtLeast(HeatLevel.KINDLED))
				heating.add(pos);
		}
	}

}
