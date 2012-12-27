package com.volumetricpixels.testmodule.materials.windmill;

import com.volumetricpixels.testmodule.TestData;
import org.spout.vanilla.material.block.component.ComponentMaterial;

public class WindmillBlock extends ComponentMaterial {

	public WindmillBlock(String name, int id) {
		super(name, id, Windmill.class, "model://Vanilla/materials/block/solid/furnace/furnace.spm");
        this.getDrops().clear().add(TestData.WINDMILL_BLOCK , 1);
	}
}