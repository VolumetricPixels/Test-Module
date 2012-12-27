package com.volumetricpixels.testmodule.materials.windmill;

import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import java.util.HashSet;
import java.util.Set;
import org.spout.api.component.type.BlockComponent;

public class Windmill extends BlockComponent implements EnergySource {
    
    private double energy;
    protected final Set<EnergyReceiver> receivers = new HashSet<EnergyReceiver>();

    @Override
    public void onAttached() {
        final int height = this.getPosition().getBlockY();
        energy = height - (height % 10);
    }
	
    @Override
    public void onTick(float dt) {
        double give = energy/receivers.size();
        for (EnergyReceiver r : receivers) {
            r.onReceive(this, give);
        }
    }

    @Override
    public void addReceiver(EnergyReceiver destination) {
        receivers.add(destination);
    }
}