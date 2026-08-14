package com.kiuseii.sitrusskin.client

import com.cobblemon.mod.common.CobblemonItemComponents
import net.minecraft.world.food.FoodProperties
import squeek.appleskin.api.AppleSkinApi
import squeek.appleskin.api.event.FoodValuesEvent

class AppleSkinCobblemonBridge : AppleSkinApi {
    override fun registerEvents() {
        FoodValuesEvent.EVENT.register { event ->
            val seasoningBonus = event.itemStack.get(CobblemonItemComponents.FOOD) ?: return@register

            val default = event.defaultFoodComponent

            val totalHunger = default.nutrition() + seasoningBonus.hunger
            val totalSaturation = default.saturation() + seasoningBonus.saturation

            event.modifiedFoodComponent = FoodProperties(
                totalHunger,
                totalSaturation,
                default.canAlwaysEat(),
                default.eatSeconds(),
                default.usingConvertsTo(),
                default.effects()
            )
        }
    }
}