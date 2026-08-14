package com.kiuseii.sitrusskin.client

import net.fabricmc.api.ClientModInitializer

object SitrusskinClient : ClientModInitializer {
	override fun onInitializeClient() {
		SitrusSkinTooltips.register()
	}
}