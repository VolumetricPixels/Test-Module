package com.volumetricpixels.testmodule.materials;

import org.spout.api.Platform;
import org.spout.api.Spout;
import org.spout.api.component.block.BlockComponent;
import org.spout.api.material.BlockMaterial;
import org.spout.api.material.Material;
import org.spout.vanilla.plugin.render.VanillaEffects;

public abstract class TestBlockMaterial extends BlockMaterial implements Initializable {

	@SuppressWarnings("unchecked")
	public TestBlockMaterial(String name, String model, Class<? extends BlockComponent>... component) {
		super((short) 0, name, model, component);
		if (Spout.getEngine().getPlatform() == Platform.CLIENT) {
			if (!getModel().getRenderMaterial().getRenderEffects().contains(VanillaEffects.SKY_TIME)) {
				getModel().getRenderMaterial().addRenderEffect(VanillaEffects.SKY_TIME);
				getModel().getRenderMaterial().addBufferEffect(VanillaEffects.LIGHTING);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public TestBlockMaterial(String name, int data, Material parent, String model, Class<? extends BlockComponent> component) {
		super(name, data, parent, model, component);
		if (Spout.getEngine().getPlatform() == Platform.CLIENT) {
			if (!getModel().getRenderMaterial().getRenderEffects().contains(VanillaEffects.SKY_TIME)) {
				getModel().getRenderMaterial().addRenderEffect(VanillaEffects.SKY_TIME);
				getModel().getRenderMaterial().addBufferEffect(VanillaEffects.LIGHTING);
			}
		}
	}

	public abstract void initialise();
}