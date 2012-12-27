package com.volumetricpixels.testmodule;

import com.volumetricpixels.mcsquared.api.energy.EnergyGenerator;

public class Windmill extends EnergyGenerator {
	
    private int energy;

    public Windmill() {
        final int height = this.getPosition().getBlockY();
        energy = height - (height % 10);
    }
	
    @Override
	public void onTick(float dt) {
		onEnergyGenerate(energy);
	}

	@Override
	public void onEnergyGenerate(double energy_generated) {
        //TODO: Split energy to each connected block
	}
}