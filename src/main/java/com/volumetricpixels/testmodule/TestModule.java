package com.volumetricpixels.testmodule;

import org.spout.api.Client;
import org.spout.api.Spout;
import org.spout.api.input.InputManager;
import org.spout.api.input.Keyboard;
import org.spout.api.plugin.CommonPlugin;
import org.spout.api.plugin.Platform;

public class TestModule extends CommonPlugin {

    @Override
	public void onDisable() {
		getLogger().info("Test-Module Disabled.");
	}

    @Override
	public void onEnable() {
	
		TMExecutor t = new TMExecutor();
		getEngine().getRootCommand().addSubCommand(this, "+windmill").setArgBounds(0, 0).setExecutor(Platform.CLIENT, t);
		
		if (Spout.getPlatform() == Platform.CLIENT) {
			InputManager input = ((Client) Spout.getEngine()).getInputManager();
			input.bind(Keyboard.KEY_B, "windmill");
		}
        TestMaterials.initialise();
		getLogger().info("Test-Module Enabled.");
	}
}