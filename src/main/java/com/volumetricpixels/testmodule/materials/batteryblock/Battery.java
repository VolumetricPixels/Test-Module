package com.volumetricpixels.testmodule.materials.batteryblock;

import com.volumetricpixels.mcsquared.api.energy.EnergyHolder;
import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;

public class Battery extends EnergyHolder {
    private int energy;

    @Override
    public void onAttached() {
        final int height = this.getPosition().getBlockY();
        energy = height - (height % 10);
    }

    @Override
	public void onTick(float dt) {
        double give = receivers.isEmpty() ? 0 : energy/receivers.size();
        if (give != 0) {
            for (EnergyReceiver r : receivers) {
                r.onReceive(this, give);
            }
        }
	}
}