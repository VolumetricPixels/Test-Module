package com.volumetricpixels.testmodule.materials.wire;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.api.energy.EnergyNode;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.energy.MaxEnergySource;
import com.volumetricpixels.mcsquared.api.energy.impl.EnergyNodeImpl;
import com.volumetricpixels.mcsquared.api.utils.EnergyUtils;
import java.util.HashSet;
import java.util.Set;
import org.spout.vanilla.material.VanillaMaterials;

public class Wire extends EnergyNodeImpl implements EnergyReceiver, EnergySource, MaxEnergySource {

    private Energy maxEnergy;
    private final Set<EnergyReceiver> receivers = new HashSet<EnergyReceiver>();
    
    public Wire() {
        maxEnergy = new Energy(100);
    }

    @Override
    public Energy onReceive(EnergySource source, Set<EnergyNode> visited, Energy energy) {
        if (maxEnergy.compareTo(energy) > 0) {
            this.getPosition().getBlock().setMaterial(VanillaMaterials.AIR);
            //Play explosion sound
            return energy;
        }
        visited.add(this);
        return EnergyUtils.safeSplit(source, energy, visited, receivers);
    }

    @Override
    public void addReceiver(EnergyReceiver destination) {
        receivers.add(destination);
    }

    public Energy getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(Energy maxEnergy) {
        this.maxEnergy = maxEnergy;
    }
    
    @Override
    public void removeReceiver(EnergyReceiver receiver) {
        receivers.remove(receiver);
    }
}