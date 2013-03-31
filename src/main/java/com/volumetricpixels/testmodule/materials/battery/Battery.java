package com.volumetricpixels.testmodule.materials.battery;

import com.volumetricpixels.mcsquared.api.energy.EnergyNode;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.energy.MaxEnergySource;
import com.volumetricpixels.mcsquared.api.energy.electricity.Electricity;
import com.volumetricpixels.mcsquared.api.energy.electricity.ElectricityHolderImpl;
import java.util.Set;

public class Battery extends ElectricityHolderImpl implements EnergyReceiver<Electricity>, MaxEnergySource<Electricity> {

    public Battery() {
        maxEnergy = new Electricity(100);
    }

    @Override
    public Electricity onReceive(EnergySource<Electricity> source, Set<EnergyNode<Electricity>> visited, Electricity energy) {
        return addEnergy(energy);
    }

    @Override
    public Electricity getMaxEnergy() {
        return maxEnergy;
    }
}