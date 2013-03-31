package com.volumetricpixels.testmodule.materials.windmill;

import com.volumetricpixels.testmodule.TestMaterials;
import com.volumetricpixels.testmodule.materials.SingleComponentTestBlockMaterial;
import org.spout.api.Spout;
import org.spout.api.inventory.recipe.RecipeBuilder;
import org.spout.vanilla.plugin.material.VanillaMaterials;

public class WindmillBlock extends SingleComponentTestBlockMaterial {

    public WindmillBlock(String name) {
        super(name, Windmill.class, "model://Vanilla/materials/block/solid/furnace/furnace.spm");
        //this.getDrops().clear().add(TestMaterials.WINDMILL_BLOCK , 1);
    }

    @Override
    public void initialise() {
        RecipeBuilder builder = new RecipeBuilder();
        builder.setResult(TestMaterials.WINDMILL_BLOCK, 1);
        builder.addIngredient(VanillaMaterials.DIRT, 1);
        Spout.getEngine().getRecipeManager().register(builder.buildShapelessRecipe());
    }
}