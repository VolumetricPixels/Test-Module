package com.volumetricpixels.testmodule.materials;

import com.volumetricpixels.mcsquared.material.SingleComponentMaterial;
import org.spout.api.component.type.BlockComponent;
import org.spout.api.material.Material;

public abstract class SingleComponentTestBlockMaterial extends SingleComponentMaterial implements Initializable {

    @SuppressWarnings("unchecked")
    public SingleComponentTestBlockMaterial(String name, Class<? extends BlockComponent> component, String model) {
        super(name, component, model);
    }

    @SuppressWarnings("unchecked")
    public SingleComponentTestBlockMaterial(String name, int data, Material parent, String model, Class<? extends BlockComponent> component) {
        super(name, data, parent, model, component);
    }

    public abstract void initialise();

}