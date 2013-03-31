package com.volumetricpixels.testmodule;

import org.spout.api.command.Command;
import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandExecutor;
import org.spout.api.command.CommandSource;
import org.spout.api.component.impl.InteractComponent;
import org.spout.api.entity.Player;
import org.spout.api.exception.CommandException;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.material.BlockMaterial;

public class TMExecutor implements CommandExecutor {

    @Override
    public void processCommand(CommandSource source, Command command, CommandContext args) throws CommandException {
        String name = command.getPreferredName();
        if (source instanceof Player) {
            Player p = (Player) source;
            BlockMaterial mat;
            if (name.equalsIgnoreCase("+battery")) {
                p.sendMessage("Battery command has been executed");
                mat = TestMaterials.BATTERY_BLOCK;
            } else if (name.equalsIgnoreCase("+windmill")) {
                p.sendMessage("Windmill command has been executed");
                mat = TestMaterials.WINDMILL_BLOCK;
            } else {
                mat = BlockMaterial.AIR;
            }
            InteractComponent hit = p.get(InteractComponent.class);
            if (hit != null) {
                Block b = hit.getTargetBlock();
                b.setMaterial(mat);
                p.sendMessage("Block at ", b.getPosition(), " has been set to " + mat.getDisplayName());
            }
        }
    }
}