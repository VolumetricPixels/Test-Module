package com.volumetricpixels.testmodule.materials.batteryblock;

import com.volumetricpixels.testmodule.TestMaterials;
import com.volumetricpixels.testmodule.materials.TestBlockMaterial;
import org.spout.api.Spout;
import org.spout.api.inventory.recipe.RecipeBuilder;
import org.spout.vanilla.material.VanillaMaterials;
import org.spout.vanilla.material.block.component.ComponentMaterial;

public class BatteryBlock extends ComponentMaterial implements TestBlockMaterial {

	public BatteryBlock(String name, int id) {
		super(name, id, Battery.class, "model://Vanilla/materials/block/solid/oakplanks/oakplanks.spm");
	}

    public void initRecipe() {
        RecipeBuilder builder = new RecipeBuilder();
        builder.setResult(TestMaterials.BATTERY_BLOCK, 1);
        builder.addIngredient(VanillaMaterials.BEDROCK);
        Spout.getEngine().getRecipeManager().register(builder.buildShapelessRecipe());
    }
}