package com.volumetricpixels.testmodule.materials;

import com.volumetricpixels.mcsquared.material.SingleComponentMaterial;
import org.spout.api.Spout;
import org.spout.api.component.type.BlockComponent;
import org.spout.api.material.Material;
import org.spout.api.plugin.Platform;
import org.spout.vanilla.render.VanillaEffects;

public abstract class SingleComponentTestBlockMaterial extends SingleComponentMaterial implements Initializable {

    @SuppressWarnings("unchecked")
    public SingleComponentTestBlockMaterial(String name, Class<? extends BlockComponent> component, String model) {
        super(name, component, model);
        if (Spout.getEngine().getPlatform() == Platform.CLIENT) {
			if (!getModel().getRenderMaterial().getRenderEffects().contains(VanillaEffects.SKY_TIME)) {
				getModel().getRenderMaterial().addRenderEffect(VanillaEffects.SKY_TIME);
				getModel().getRenderMaterial().addBufferEffect(VanillaEffects.LIGHTING);
			}
		}
    }

    @SuppressWarnings("unchecked")
    public SingleComponentTestBlockMaterial(String name, int data, Material parent, String model, Class<? extends BlockComponent> component) {
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