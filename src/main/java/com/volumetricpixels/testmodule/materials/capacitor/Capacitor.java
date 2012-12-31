package com.volumetricpixels.testmodule.materials.capacitor;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.api.energy.EnergyHolder;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import java.util.HashSet;
import java.util.Set;
import org.spout.api.component.type.BlockComponent;

public class Capacitor extends BlockComponent implements EnergyHolder, EnergyReceiver, EnergySource {
    private Energy maxEnergy;
    private Energy energyHeld;
    protected final Set<EnergyReceiver> receivers = new HashSet<EnergyReceiver>();

    public Energy getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(Energy maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public Energy getEnergyHeld() {
        return energyHeld;
    }

    @Override
    public void onTick(float dt) {
        if (receivers.isEmpty()) return; 
        Energy give = energyHeld.split(receivers.size());
        for (EnergyReceiver r : receivers) {
            r.onReceive(this, give);
        }
    }
    
    /**
     * 
     * @param energy
     * @return excess energy that couldn't be added
     */
    public Energy addEnergy(Energy energy) {
        Energy excess = Energy.EMPTY;
        if (energy.getValue() < 0) {
            throw new IllegalArgumentException("Cannot add negative energy!");
        } else if (energyHeld.add(energy).getValue() > maxEnergy.getValue()) {
            excess = energyHeld.add(energy).subtract(maxEnergy);
            energyHeld = maxEnergy;
        } else {
            energyHeld = energyHeld.add(energy);
        }
        return excess;
    }

    /**
     * 
     * @param energy
     * @return amount of energy that couldn't be removed
     */
    public Energy removeEnergy(Energy energy) {
        Energy excess = Energy.EMPTY;
        if (energy.getValue() < 0) {
            throw new IllegalArgumentException("Cannot remove negative energy!");
        } else if (energyHeld.subtract(energy).getValue() < 0) {
            excess = new Energy(Math.abs(energyHeld.getValue() - energy.getValue()));
            energyHeld = Energy.EMPTY;
        } else {
            energyHeld = energyHeld.subtract(energy);
        }
        return excess;
    }

    public Energy onReceive(EnergySource source, Energy energy) {
        return addEnergy(energy);
    }
    
    public void addReceiver(EnergyReceiver receiver) {
        receivers.add(receiver);
    }
}
