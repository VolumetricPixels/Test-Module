package com.volumetricpixels.testmodule.materials.capacitor;

import com.volumetricpixels.mcsquared.api.energy.EnergyHolder;
import com.volumetricpixels.mcsquared.api.energy.EnergyNodeComponent;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.energy.MaxEnergyAccess;
import com.volumetricpixels.mcsquared.api.energy.electricity.Electricity;
import com.volumetricpixels.mcsquared.api.energy.electricity.ElectricityHolder;
import com.volumetricpixels.mcsquared.api.utils.EnergyUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Capacitor extends ElectricityHolder implements EnergyHolder<Electricity>, EnergyReceiver<Electricity>, EnergySource<Electricity>, MaxEnergyAccess<Electricity> {

    private final Set<EnergyReceiver<Electricity>> receivers = new HashSet<EnergyReceiver<Electricity>>();

    @Override
    public Electricity getMaxEnergy() {
        return maxEnergy;
    }

    @Override
    public void setMaxEnergy(Electricity maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    @Override
    public void onTick(float dt) {
        if (receivers.isEmpty()) {
            return;
        }
        this.energyHeld = EnergyUtils.safeSplit(this, energyHeld, new HashSet<EnergyNodeComponent<Electricity>>(Arrays.asList(this)), receivers);
    }

    @Override
    public Electricity onReceive(EnergySource<Electricity> source, Set<EnergyNodeComponent<Electricity>> visited, Electricity energy) {
        return addEnergy(energy);
    }

    @Override
    public void addReceiver(EnergyReceiver<Electricity> receiver) {
        receivers.add(receiver);
    }

    @Override
    public void removeReceiver(EnergyReceiver<Electricity> receiver) {
        receivers.remove(receiver);
    }
}
