package com.volumetricpixels.testmodule.materials.wire;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.api.energy.EnergyCarrier;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.energy.MaxEnergySource;

public class Wire extends EnergyCarrier implements EnergyReceiver, EnergySource, MaxEnergySource {
    
    public Wire() {
        this.maxEnergyTransfer = new Energy(100);
    }

    @Override
    public Energy getMaxEnergy() {
        return maxEnergyTransfer;
    }
}