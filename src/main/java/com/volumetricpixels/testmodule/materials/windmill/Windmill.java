package com.volumetricpixels.testmodule.materials.windmill;

import com.volumetricpixels.mcsquared.api.energy.EnergyNodeComponent;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.energy.electricity.Electricity;
import com.volumetricpixels.mcsquared.api.energy.electricity.ElectricityNode;
import com.volumetricpixels.mcsquared.api.utils.EnergyUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Windmill extends ElectricityNode implements EnergySource<Electricity> {

    private Electricity energyGenerated;
    private final Set<EnergyReceiver<Electricity>> receivers = new HashSet<EnergyReceiver<Electricity>>();

    @Override
    public void onAttached() {
        final int height = this.getBlock().getPosition().getBlockY();
        energyGenerated = new Electricity(height - (height % 10));
    }

    @Override
    public void onTick(float dt) {
        if (receivers.isEmpty()) {
            return;
        }
        EnergyUtils.safeSplit(this, energyGenerated, new HashSet<EnergyNodeComponent<Electricity>>(Arrays.asList(this)), receivers);
    }

    @Override
    public void addReceiver(EnergyReceiver<Electricity> destination) {
        receivers.add(destination);
    }
    
    @Override
    public void removeReceiver(EnergyReceiver<Electricity> receiver) {
        receivers.remove(receiver);
    }
}