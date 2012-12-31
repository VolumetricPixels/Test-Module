package com.volumetricpixels.testmodule.materials.battery;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.api.energy.EnergyNode;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.energy.MaxEnergySource;
import com.volumetricpixels.mcsquared.api.energy.impl.EnergyHolderImpl;
import java.util.Set;

public class Battery extends EnergyHolderImpl implements EnergyReceiver, MaxEnergySource {

    public Battery() {
        maxEnergy = new Energy(100);
    }

    @Override
    public Energy onReceive(EnergySource source, Set<EnergyNode> visited, Energy energy) {
        return addEnergy(energy);
    }

    @Override
    public Energy getMaxEnergy() {
        return maxEnergy;
    }
}