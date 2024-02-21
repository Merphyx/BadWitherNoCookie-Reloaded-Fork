package com.kreezcraft.badwithernocookiereloaded.mixin;

import com.kreezcraft.badwithernocookiereloaded.common.ProxyPlaySoundEvent;
import com.kreezcraft.badwithernocookiereloaded.event.PlaySoundCallback;

import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SoundSystem.class)
public class SoundSystemMixin {

	@Inject(method = "play(Lnet/minecraft/client/sound/SoundInstance;)V", at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/sound/SoundInstance;canPlay()Z",
			shift = At.Shift.BEFORE,
			ordinal = 0), cancellable = true)
	public void bwnc_play(SoundInstance soundInstance, CallbackInfo ci) {
		ProxyPlaySoundEvent event = new ProxyPlaySoundEvent(soundInstance.getId().getPath(), soundInstance);
		soundInstance = PlaySoundCallback.EVENT.invoker().playSound(event);
		if(soundInstance == null) {
			ci.cancel();
		}
	}
}