package com.volumetricpixels.testmodule.materials.battery;

import com.volumetricpixels.testmodule.TestMaterials;
import com.volumetricpixels.testmodule.materials.SingleComponentTestBlockMaterial;
import org.spout.api.Spout;
import org.spout.api.inventory.recipe.RecipeBuilder;
import org.spout.vanilla.plugin.material.VanillaMaterials;

public class BatteryBlock extends SingleComponentTestBlockMaterial {

    public BatteryBlock(String name) {
        super(name, Battery.class, "model://Test-Module/materials/block/solid/battery/battery.spm");
    }

    @Override
    public void initialise() {
        RecipeBuilder builder = new RecipeBuilder();
        builder.setResult(TestMaterials.BATTERY_BLOCK, 1);
        builder.addIngredient(VanillaMaterials.COBBLESTONE);
        Spout.getEngine().getRecipeManager().register(builder.buildShapelessRecipe());
    }
}
