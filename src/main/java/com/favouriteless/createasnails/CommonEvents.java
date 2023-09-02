package com.favouriteless.createasnails;

import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid=CreateAsNails.MODID)
public class CommonEvents {

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent event) {

	}

}
