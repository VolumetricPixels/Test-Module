package com.volumetricpixels.testmodule;

import org.spout.api.command.CommandArguments;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.CommandDescription;
import org.spout.api.command.annotated.Filter;
import org.spout.api.command.filter.PlayerFilter;
import org.spout.api.component.entity.InteractComponent;
import org.spout.api.entity.Player;
import org.spout.api.exception.CommandException;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.material.BlockMaterial;

public class TMCommands {

	@Filter(PlayerFilter.class)
	@CommandDescription(aliases = {"battery"}, desc = "Sets the block to a battery")
	public void onBattery(CommandSource source, CommandArguments args) throws CommandException {
		Player p = (Player) source;
		BlockMaterial mat = TestMaterials.BATTERY_BLOCK;
		p.sendMessage("Battery command has been executed");

		InteractComponent hit = p.get(InteractComponent.class);
		if (hit != null) {
			Block b = hit.getTargetBlock();
			b.setMaterial(mat);
			p.sendMessage("Block at " + b.getPosition() + " has been set to " + mat.getDisplayName());
		}
	}

	@Filter(PlayerFilter.class)
	@CommandDescription(aliases = {"windmill"}, desc = "Sets the block to a windmill")
	public void onWindmill(CommandSource source, CommandArguments args) throws CommandException {
		Player p = (Player) source;
		BlockMaterial mat = TestMaterials.WINDMILL_BLOCK;
		p.sendMessage("Windmill command has been executed");
		InteractComponent hit = p.get(InteractComponent.class);
		if (hit != null) {
			Block b = hit.getTargetBlock();
			b.setMaterial(mat);
			p.sendMessage("Block at " + b.getPosition() + " has been set to " + mat.getDisplayName());
		}
	}
}