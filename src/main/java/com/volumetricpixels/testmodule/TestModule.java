package com.volumetricpixels.testmodule;

import org.spout.api.plugin.CommonPlugin;

public class TestModule extends CommonPlugin {

	public void onDisable() {
		getLogger().info("disabled.");
	}

	public void onEnable() {
		getLogger().info("enabled.");
	}
}
