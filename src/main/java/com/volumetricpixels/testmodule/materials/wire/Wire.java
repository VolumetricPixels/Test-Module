package com.volumetricpixels.testmodule.materials.wire;

import com.volumetricpixels.mcsquared.api.energy.EnergyReceiver;
import com.volumetricpixels.mcsquared.api.energy.EnergySource;
import java.util.HashSet;
import java.util.Set;
import org.spout.api.component.type.BlockComponent;
import org.spout.vanilla.material.VanillaMaterials;

/**
 * @author thehutch
 */
public class Wire extends BlockComponent implements EnergyReceiver, EnergySource {

    private double energy;
    private double maxEnergy;
    
    protected final Set<EnergyReceiver> receivers = new HashSet<EnergyReceiver>();
    
    @Override
    public double onReceive(EnergySource source, double energy) {
        if (energy > maxEnergy) {
            this.getPosition().getBlock().setMaterial(VanillaMaterials.AIR);
            //Play explosion sound
            return energy;
        } else {
            if (energy > 0) {
                for(EnergyReceiver receiver : receivers) {
                    receiver.onReceive(this, energy);
                }
            } else {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public void addReceiver(EnergyReceiver destination) {
        
    }
}