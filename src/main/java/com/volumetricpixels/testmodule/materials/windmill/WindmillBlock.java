package com.volumetricpixels.testmodule.materials.windmill;

import com.volumetricpixels.testmodule.TestMaterials;
import com.volumetricpixels.testmodule.materials.TestBlockMaterial;
import org.spout.api.Spout;
import org.spout.api.inventory.recipe.RecipeBuilder;
import org.spout.vanilla.material.VanillaMaterials;
import org.spout.vanilla.material.block.component.ComponentMaterial;

public class WindmillBlock extends ComponentMaterial implements TestBlockMaterial {

	public WindmillBlock(String name, int id) {
		super(name, id, Windmill.class, "model://Vanilla/materials/block/solid/furnace/furnace.spm");
        this.getDrops().clear().add(TestMaterials.WINDMILL_BLOCK , 1);
	}

    public void initRecipe() {
        RecipeBuilder builder = new RecipeBuilder();
        builder.setResult(TestMaterials.WINDMILL_BLOCK, 1);
        builder.addIngredient(VanillaMaterials.DIRT, 1);
        Spout.getEngine().getRecipeManager().register(builder.buildShapelessRecipe());
    }
}