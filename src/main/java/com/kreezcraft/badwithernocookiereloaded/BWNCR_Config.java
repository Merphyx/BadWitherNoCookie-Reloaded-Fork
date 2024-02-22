package com.kreezcraft.badwithernocookiereloaded;

import com.kreezcraft.badwithernocookiereloaded.common.Constants;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import java.util.ArrayList;
import java.util.List;

@Config(name = Constants.MOD_ID)
public class BWNCR_Config implements ConfigData {
	@CollapsibleObject
	public General general = new General();

	public static class General {
		@Comment("Silence the server-wide Wither spawn and death broadcast sounds.")
		public boolean silenceWither = true;

		@Comment("Silence the wandering trader's ambient sound.")
		public boolean silenceTrader = true;

		@Comment("Silence the server-wide Ender Dragon Death broadcast sound.")
		public boolean silenceDragon = true;

		@Comment("Silence the server-wide Thunder broadcast sound caused by the Lightning event")
		public boolean silenceLightning = true;

		@Comment("A list of sounds to silence, discoverable with the toggle command /bwncr listen enter one sound event per line with no commas.")
		public List<String> silenceUs = new ArrayList<>();

		@Comment("If enabled the console will load up spam showing what sounds are being received and whether or not they are being canceled")
		public boolean debugMode = false;
	}

	@Override
	public void validatePostLoad() throws ValidationException {
	}
}
