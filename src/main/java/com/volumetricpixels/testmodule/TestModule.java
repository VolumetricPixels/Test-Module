package com.volumetricpixels.testmodule;

import org.spout.api.Client;
import org.spout.api.Spout;
import org.spout.api.input.InputManager;
import org.spout.api.input.Keyboard;
import org.spout.api.inventory.recipe.RecipeBuilder;
import org.spout.api.plugin.CommonPlugin;
import org.spout.api.plugin.Platform;
import org.spout.vanilla.material.VanillaMaterials;

public class TestModule extends CommonPlugin {

	public void onDisable() {
		getLogger().info("disabled.");
	}

	public void onEnable() {
		
		RecipeBuilder builder = new RecipeBuilder();
		builder.setResult(WindmillData.WINDMILL_BLOCK, 1);
		builder.addRow("D  ");
		builder.setIngredient('D', VanillaMaterials.DIRT);
		Spout.getEngine().getRecipeManager().register(builder.buildShapedRecipe());
		
		TMExecutor t = new TMExecutor();
		getEngine().getRootCommand().addSubCommand(this, "+windmill").setArgBounds(0, 0).setExecutor(Platform.CLIENT, t);
		
		if (Spout.getPlatform() == Platform.CLIENT) {
			InputManager input = ((Client) Spout.getEngine()).getInputManager();
			input.bind(Keyboard.KEY_B, "windmill");
		}
			
		getLogger().info("enabled.");
	}
	
}
