package com.volumetricpixels.testmodule;

import org.spout.api.plugin.CommonPlugin;

public class TestModule extends CommonPlugin {

	public static final WindmillBlock WINDMILL_BLOCK = new WindmillBlock("Windmill", 150);
	
	public void onDisable() {
		getLogger().info("disabled.");
	}

	public void onEnable() {
		getLogger().info("enabled.");
	}
}
