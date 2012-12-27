package com.volumetricpixels.testmodule.materials.batteryblock;

import org.spout.vanilla.material.block.component.ComponentMaterial;

public class BatteryBlock extends ComponentMaterial {

	public BatteryBlock(String name, int id) {
		super(name, id, Battery.class, "model://Vanilla/materials/block/solid/oakplanks/oakplanks.spm");
	}
}
