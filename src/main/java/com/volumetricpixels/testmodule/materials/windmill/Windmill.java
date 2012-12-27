package com.volumetricpixels.testmodule.materials.windmill;

import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import java.util.ArrayList;
import java.util.List;
import org.spout.api.component.type.BlockComponent;

public class Windmill extends BlockComponent implements EnergySource {
    private int energy;
    private List<EnergyReceiver> receivers = new ArrayList<EnergyReceiver>();


    public Windmill() {
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

    public void addReceiver(EnergyReceiver destination) {
        receivers.add(destination);
    }
}