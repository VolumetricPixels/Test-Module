package com.volumetricpixels.testmodule.materials.wire;

import com.volumetricpixels.testmodule.TestMaterials;
import com.volumetricpixels.testmodule.materials.SingleComponentTestBlockMaterial;
import com.volumetricpixels.testmodule.materials.windmill.Windmill;
import org.spout.api.Spout;
import org.spout.api.inventory.recipe.RecipeBuilder;
import org.spout.vanilla.plugin.material.VanillaMaterials;

public class WireBlock extends SingleComponentTestBlockMaterial {

    public WireBlock(String name) {
        super(name, Windmill.class, "model://Vanilla/materials/block/solid/brownwool/brownwool.spm");
    }

    @Override
    public void initialise() {
        RecipeBuilder builder = new RecipeBuilder();
        builder.setResult(TestMaterials.WIRE_BLOCK, 1);
        builder.addIngredient(VanillaMaterials.STONE, 1);
        Spout.getEngine().getRecipeManager().register(builder.buildShapelessRecipe());
    }
    
    
}