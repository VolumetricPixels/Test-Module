package com.volumetricpixels.testmodule;

import com.volumetricpixels.mcsquared.api.energy.EnergyGenerator;
import org.spout.api.entity.Player;
import org.spout.api.inventory.Inventory;
import org.spout.vanilla.component.inventory.WindowHolder;
import org.spout.vanilla.inventory.window.block.CraftingTableWindow;

public class Windmill extends EnergyGenerator {
	
    private int energy;
    
    public Windmill() {
        final int height = this.getBlock().getPosition().getBlockY();
        energy = height - (height % 10);
    }
	
    @Override
	public void onTick(float dt) {
		onEnergyGenerate(energy);
	}
	
	public Inventory getInventory() {
		return null;
	}

	public void open(Player player) {
		player.get(WindowHolder.class).openWindow(new CraftingTableWindow(player));
		player.sendMessage("Energy: " + energy);
	}

	@Override
	public void onEnergyGenerate(double energy_generated) {
        //TODO: Split energy to each connected block
	}    
}