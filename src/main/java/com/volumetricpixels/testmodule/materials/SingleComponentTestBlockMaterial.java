package com.volumetricpixels.testmodule.materials;

import com.volumetricpixels.mcsquared.BlockEntityMaterial;
import java.util.ArrayList;
import java.util.Arrays;
import org.spout.api.component.type.BlockComponent;
import org.spout.api.material.Material;

public abstract class SingleComponentTestBlockMaterial extends BlockEntityMaterial implements Initializable {

    @SuppressWarnings("unchecked")
    public SingleComponentTestBlockMaterial(String name, Class<? extends BlockComponent> component, String model) {
        super(name, new ArrayList<Class<? extends BlockComponent>>(Arrays.asList(component)), model);
    }

    @SuppressWarnings("unchecked")
    public SingleComponentTestBlockMaterial(String name, int data, Material parent, String model, Class<? extends BlockComponent> component) {
        super(name, data, parent, model, new ArrayList<Class<? extends BlockComponent>>(Arrays.asList(component)));
    }

    public abstract void initialise();

}