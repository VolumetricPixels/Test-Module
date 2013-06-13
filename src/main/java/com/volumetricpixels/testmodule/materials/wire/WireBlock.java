package com.volumetricpixels.testmodule.materials.wire;

import com.volumetricpixels.testmodule.TestMaterials;
import com.volumetricpixels.testmodule.materials.TestBlockMaterial;
import com.volumetricpixels.testmodule.materials.windmill.Windmill;
import org.spout.api.Spout;
import org.spout.api.inventory.recipe.RecipeBuilder;
import org.spout.vanilla.plugin.material.VanillaMaterials;

public class WireBlock extends TestBlockMaterial {

    public WireBlock(String name) {
        super(name, "model://Vanilla/materials/block/solid/brownwool/brownwool.spm", Windmill.class);
    }

    @Override
    public void initialise() {
        RecipeBuilder builder = new RecipeBuilder();
        builder.setResult(TestMaterials.WIRE_BLOCK, 1);
        builder.addIngredient(VanillaMaterials.STONE, 1);
        Spout.getEngine().getRecipeManager().register(builder.buildShapelessRecipe());
    }
    
    
}