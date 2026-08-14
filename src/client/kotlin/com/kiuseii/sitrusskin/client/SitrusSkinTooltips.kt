package com.kiuseii.sitrusskin.client

import com.cobblemon.mod.common.CobblemonItemComponents
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component

object SitrusSkinTooltips {
    fun register() {
        ItemTooltipCallback.EVENT.register { stack, context, type, lines ->
            val mobEffects = stack.get(CobblemonItemComponents.MOB_EFFECTS) ?: return@register

            for (effectInstance in mobEffects.mobEffects) {
                val effectName = effectInstance.effect.value().displayName
                val totalSeconds = effectInstance.duration / 20
                val minutes = totalSeconds / 60
                val seconds = totalSeconds % 60

                val line = Component.literal("")
                    .append(effectName)
                    .append(Component.literal(" (%02d:%02d)".format(minutes, seconds)))
                    .withStyle(ChatFormatting.BLUE)

                lines.add(line)
            }
        }
    }
}