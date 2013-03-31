package com.volumetricpixels.testmodule.materials;

import com.volumetricpixels.mcsquared.material.MultipleComponentMaterial;
import java.util.List;
import org.spout.api.Spout;
import org.spout.api.component.type.BlockComponent;
import org.spout.api.material.Material;
import org.spout.api.plugin.Platform;
import org.spout.vanilla.plugin.render.VanillaEffects;

public abstract class MultipleComponentTestBlockMaterial extends MultipleComponentMaterial implements Initializable {

    public MultipleComponentTestBlockMaterial(String name, List<Class<? extends BlockComponent>> component, String model) {
        super(name, component, model);
        if (Spout.getEngine().getPlatform() == Platform.CLIENT) {
			if (!getModel().getRenderMaterial().getRenderEffects().contains(VanillaEffects.SKY_TIME)) {
				getModel().getRenderMaterial().addRenderEffect(VanillaEffects.SKY_TIME);
				getModel().getRenderMaterial().addBufferEffect(VanillaEffects.LIGHTING);
			}
		}
    }

    public MultipleComponentTestBlockMaterial(String name, int data, Material parent, String model, List<Class<? extends BlockComponent>> component) {
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