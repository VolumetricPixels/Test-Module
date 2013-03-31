package com.volumetricpixels.testmodule.materials.capacitor;

import com.volumetricpixels.testmodule.TestMaterials;
import com.volumetricpixels.testmodule.materials.SingleComponentTestBlockMaterial;
import org.spout.api.Spout;
import org.spout.api.inventory.recipe.RecipeBuilder;
import org.spout.vanilla.plugin.material.VanillaMaterials;

public class CapacitorBlock extends SingleComponentTestBlockMaterial {

    public CapacitorBlock(String name) {
        super(name, Capacitor.class, "model://Vanilla/materials/block/solid/furnace/furnace.spm");
    }

    @Override
    public void initialise() {
        RecipeBuilder builder = new RecipeBuilder();
        builder.setResult(TestMaterials.BATTERY_BLOCK, 1);
        builder.addIngredient(VanillaMaterials.BEDROCK);
        Spout.getEngine().getRecipeManager().register(builder.buildShapelessRecipe());
    }
}
