package com.kreezcraft.badwithernocookiereloaded.common;

import net.minecraft.client.sound.SoundInstance;

public class ProxyPlaySoundEvent {

	private final String name;

	private SoundInstance sound;

	public ProxyPlaySoundEvent(String name, SoundInstance originalSound) {
		this.name = name;
		this.setSound(originalSound);
	}

	public String getName() {
		return name;
	}

	public SoundInstance getSound()
	{
		return sound;
	}

	public void setSound(SoundInstance result)
	{
		this.sound = result;
	}
}
