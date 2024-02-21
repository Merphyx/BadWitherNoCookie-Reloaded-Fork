package com.kreezcraft.badwithernocookiereloaded.command;

import com.kreezcraft.badwithernocookiereloaded.common.CommonClass;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public final class FabricListenCommand {

	public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
		final LiteralArgumentBuilder<FabricClientCommandSource> root = ClientCommandManager.literal("bwncr")
				.then(ClientCommandManager.literal("listen").executes((command) -> {
					if (CommonClass.whatWasThat) {
						CommonClass.whatWasThat = false;
						CommonClass.player = null;
					} else {
						CommonClass.whatWasThat = true;
						if (command.getSource().getEntity() instanceof PlayerEntity) {
							CommonClass.player = command.getSource().getPlayer();
						}
					}

					command.getSource().sendFeedback(Text.of("Event Listening is now " + (CommonClass.whatWasThat ? "on" : "off")));
					return 0;
				}));
		dispatcher.register(root);
	}
}
