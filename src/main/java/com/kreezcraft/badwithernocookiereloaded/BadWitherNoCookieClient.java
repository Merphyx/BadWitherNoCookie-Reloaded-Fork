package com.kreezcraft.badwithernocookiereloaded;

import com.kreezcraft.badwithernocookiereloaded.command.FabricListenCommand;
import com.kreezcraft.badwithernocookiereloaded.common.CommonClass;
import com.kreezcraft.badwithernocookiereloaded.common.ProxyPlaySoundEvent;
import com.kreezcraft.badwithernocookiereloaded.event.PlaySoundCallback;
import com.kreezcraft.badwithernocookiereloaded.handler.SoundEventHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class BadWitherNoCookieClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		CommonClass.init();

		PlaySoundCallback.EVENT.register((event) -> {
			ProxyPlaySoundEvent proxyEvent = SoundEventHandler.onSoundEvent(event);
			return proxyEvent.getSound();
		});

		AutoConfig.register(BWNCR_Config.class, Toml4jConfigSerializer::new);

		ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
			FabricListenCommand.register(dispatcher);
		});
	}

}
