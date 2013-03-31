package com.volumetricpixels.testmodule.materials.windmill;

import com.volumetricpixels.mcsquared.api.energy.EnergyNode;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.energy.electricity.Electricity;
import com.volumetricpixels.mcsquared.api.energy.electricity.EnergyNodeImpl;
import com.volumetricpixels.mcsquared.api.utils.EnergyUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Windmill extends EnergyNodeImpl<Electricity> implements EnergySource<Electricity> {

    private Electricity energyGenerated;
    private final Set<EnergyReceiver<Electricity>> receivers = new HashSet<EnergyReceiver<Electricity>>();

    @Override
    public void onAttached() {
        final int height = this.getPosition().getBlockY();
        energyGenerated = new Electricity(height - (height % 10));
    }

    @Override
    public void onTick(float dt) {
        if (receivers.isEmpty()) {
            return;
        }
        EnergyUtils.safeSplit(this, energyGenerated, new HashSet<EnergyNode<Electricity>>(Arrays.asList(this)), receivers);
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