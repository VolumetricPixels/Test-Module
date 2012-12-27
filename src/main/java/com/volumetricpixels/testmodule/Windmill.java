package com.volumetricpixels.testmodule;

import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import org.spout.api.component.type.BlockComponent;

public class Windmill extends BlockComponent implements EnergySource {
	
    private int energy;

    public Windmill() {
        final int height = this.getPosition().getBlockY();
        energy = height - (height % 10);
    }
	
    @Override
	public void onTick(float dt) {
		
	}

    public void addReceiver(EnergyReceiver destination) {
        
    }
}