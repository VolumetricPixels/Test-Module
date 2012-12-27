package com.volumetricpixels.testmodule.materials.wire;

import com.volumetricpixels.testmodule.materials.windmill.*;
import com.volumetricpixels.testmodule.TestMaterials;
import com.volumetricpixels.testmodule.materials.ComponentMaterial;
import com.volumetricpixels.testmodule.materials.TestBlockMaterial;
import org.spout.api.Spout;
import org.spout.api.inventory.recipe.RecipeBuilder;
import org.spout.vanilla.material.VanillaMaterials;

public class WireBlock extends ComponentMaterial implements TestBlockMaterial {

    public WireBlock(String name) {
       super(name, Windmill.class, "model://Vanilla/materials/block/solid/brownwool/brownwool.spm");
       //this.getDrops().clear().add(TestMaterials.WINDMILL_BLOCK , 1);
    }

    public void initRecipe() {
        RecipeBuilder builder = new RecipeBuilder();
        builder.setResult(TestMaterials.WIRE_BLOCK, 1);
        builder.addIngredient(VanillaMaterials.DIRT, 1);
        Spout.getEngine().getRecipeManager().register(builder.buildShapelessRecipe());
    }
}