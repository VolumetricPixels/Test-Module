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
        getLogger().info("Disabled.");
    }

    @Override
    public void onLoad() {
        TestMaterials.initialise();
        getLogger().info("Loaded");
    }

    @Override
    public void onEnable() {
        TMExecutor t = new TMExecutor();
        getEngine().getRootCommand().addSubCommand(this, "+battery").setArgBounds(0, 0).setExecutor(Platform.CLIENT, t);
        getEngine().getRootCommand().addSubCommand(this, "+windmill").setArgBounds(0, 0).setExecutor(Platform.CLIENT, t);

        if (Spout.getPlatform() == Platform.CLIENT) {
            InputManager input = ((Client) Spout.getEngine()).getInputManager();
            input.bind(Keyboard.KEY_B, "battery");
            input.bind(Keyboard.KEY_N, "windmill");
        }
        getLogger().info("Enabled.");
    }
}