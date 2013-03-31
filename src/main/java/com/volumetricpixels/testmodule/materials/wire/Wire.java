package com.volumetricpixels.testmodule.materials.wire;

import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.energy.MaxEnergySource;
import com.volumetricpixels.mcsquared.api.energy.electricity.Electricity;
import com.volumetricpixels.mcsquared.api.energy.electricity.ElectricityCarrier;

public class Wire extends ElectricityCarrier implements EnergyReceiver<Electricity>, EnergySource<Electricity>, MaxEnergySource<Electricity> {
    
    public Wire() {
        this.maxEnergyTransfer = new Electricity(100);
    }

    @Override
    public Electricity getMaxEnergy() {
        return maxEnergyTransfer;
    }
}