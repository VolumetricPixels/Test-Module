package com.volumetricpixels.testmodule.materials.capacitor;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.api.energy.EnergyHolder;
import com.volumetricpixels.mcsquared.api.energy.EnergyNode;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.energy.MaxEnergyAccess;
import com.volumetricpixels.mcsquared.api.energy.impl.EnergyHolderImpl;
import com.volumetricpixels.mcsquared.api.utils.EnergyUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Capacitor extends EnergyHolderImpl implements EnergyHolder, EnergyReceiver, EnergySource, MaxEnergyAccess {
    private final Set<EnergyReceiver> receivers = new HashSet<EnergyReceiver>();

    @Override
    public Energy getMaxEnergy() {
        return maxEnergy;
    }

    @Override
    public void setMaxEnergy(Energy maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    @Override
    public void onTick(float dt) {
        if (receivers.isEmpty()) return;
        this.energyHeld = EnergyUtils.safeSplit(this, energyHeld, new HashSet<EnergyNode>(Arrays.asList(this)), receivers);
    }

    @Override
    public Energy onReceive(EnergySource source, Set<EnergyNode> visited, Energy energy) {
        return addEnergy(energy);
    }
    
    @Override
    public void addReceiver(EnergyReceiver receiver) {
        receivers.add(receiver);
    }
}
