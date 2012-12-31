package com.volumetricpixels.testmodule.materials.windmill;

import com.volumetricpixels.mcsquared.api.energy.Energy;
import com.volumetricpixels.mcsquared.api.energy.EnergyNode;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import com.volumetricpixels.mcsquared.api.energy.impl.EnergyNodeImpl;
import com.volumetricpixels.mcsquared.api.utils.EnergyUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Windmill extends EnergyNodeImpl implements EnergySource {
    
    private Energy energyGenerated;
    private final Set<EnergyReceiver> receivers = new HashSet<EnergyReceiver>();

    @Override
    public void onAttached() {
        final int height = this.getPosition().getBlockY();
        energyGenerated = new Energy(height - (height % 10));
    }
	
    @Override
    public void onTick(float dt) {
        if (receivers.isEmpty()) {
            return;
        }
        EnergyUtils.safeSplit(this, energyGenerated, new HashSet<EnergyNode>(Arrays.asList(this)), receivers);
    }

    @Override
    public void addReceiver(EnergyReceiver destination) {
        receivers.add(destination);
    }
}