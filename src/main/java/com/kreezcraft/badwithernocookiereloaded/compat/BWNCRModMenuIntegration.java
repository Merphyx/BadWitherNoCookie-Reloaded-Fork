package com.kreezcraft.badwithernocookiereloaded.compat;

import com.kreezcraft.badwithernocookiereloaded.BWNCR_Config;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;

public class BWNCRModMenuIntegration implements ModMenuApi {

	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> AutoConfig.getConfigScreen(BWNCR_Config.class, parent).get();
	}
}
