package com.kreezcraft.badwithernocookiereloaded.handler;

import com.kreezcraft.badwithernocookiereloaded.BWNCR_Config;
import com.kreezcraft.badwithernocookiereloaded.common.CommonClass;
import com.kreezcraft.badwithernocookiereloaded.common.ProxyPlaySoundEvent;
import com.kreezcraft.badwithernocookiereloaded.common.SoundHandler;
import me.shedaniel.autoconfig.AutoConfig;

public class SoundEventHandler {

    public static ProxyPlaySoundEvent onSoundEvent(ProxyPlaySoundEvent event) {
        BWNCR_Config config = AutoConfig.getConfigHolder(BWNCR_Config.class).getConfig();
        SoundHandler.silenceWither = config.general.silenceWither;
        SoundHandler.silenceTrader = config.general.silenceTrader;
        SoundHandler.silenceDragon = config.general.silenceDragon;
        SoundHandler.silenceLightning = config.general.silenceLightning;
        SoundHandler.silenceUs = config.general.silenceUs;
        CommonClass.debugMode = config.general.debugMode;

        ProxyPlaySoundEvent proxy = SoundHandler.onPlaySound(event);
        return proxy;
    }
}
