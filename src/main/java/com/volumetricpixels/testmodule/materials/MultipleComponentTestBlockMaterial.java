package com.volumetricpixels.testmodule.materials;

import com.volumetricpixels.mcsquared.BlockEntityMaterial;
import java.util.List;
import org.spout.api.component.type.BlockComponent;
import org.spout.api.material.Material;

public abstract class MultipleComponentTestBlockMaterial extends BlockEntityMaterial implements Initializable {

    public MultipleComponentTestBlockMaterial(String name, List<Class<? extends BlockComponent>> component, String model) {
        super(name, component, model);
    }

    public MultipleComponentTestBlockMaterial(String name, int data, Material parent, String model, List<Class<? extends BlockComponent>> component) {
        super(name, data, parent, model, component);
    }

    public abstract void initialise();
}