package com.volumetricpixels.testmodule;

import org.spout.api.command.annotated.AnnotatedCommandExecutorFactory;
import org.spout.api.plugin.Plugin;

public class TestModule extends Plugin {

    @Override
    public void onDisable() {
        getLogger().info("Disabled.");
    }

    @Override
    public void onLoad() {
        getLogger().info("Loaded");
    }

    @Override
    public void onEnable() {
        TestMaterials.initialise();
        AnnotatedCommandExecutorFactory.create(new TMCommands());
        getLogger().info("Enabled.");
    }
}