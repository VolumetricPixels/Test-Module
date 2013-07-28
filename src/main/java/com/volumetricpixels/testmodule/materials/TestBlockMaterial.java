package com.volumetricpixels.testmodule.materials;

import java.util.Arrays;
import org.spout.api.Platform;
import org.spout.api.Spout;
import org.spout.api.component.block.BlockComponent;
import org.spout.api.material.basic.Solid;
import org.spout.vanilla.render.VanillaEffects;

public abstract class TestBlockMaterial extends Solid implements Initializable {

	public TestBlockMaterial(String name, String model, Class<? extends BlockComponent>... components) {
		super(name, model);
		if (Spout.getEngine().getPlatform() == Platform.CLIENT) {
			if (!getModel().getRenderMaterial().getRenderEffects().contains(VanillaEffects.SKY_TIME)) {
				getModel().getRenderMaterial().addRenderEffect(VanillaEffects.SKY_TIME);
				getModel().getRenderMaterial().addBufferEffect(VanillaEffects.LIGHTING);
			}
		}
		getComponents().addAll(Arrays.asList(components));
	}

	public abstract void initialise();
}
