package com.volumetricpixels.testmodule;

import org.spout.api.command.Command;
import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandExecutor;
import org.spout.api.command.CommandSource;
import org.spout.api.component.impl.HitBlockComponent;
import org.spout.api.entity.Player;
import org.spout.api.exception.CommandException;
import org.spout.api.geo.cuboid.Block;

public class TMExecutor implements CommandExecutor {

    @Override
    public void processCommand(CommandSource source, Command command, CommandContext args) throws CommandException {
        String name = command.getPreferredName();
        if (source instanceof Player) {
            Player p = (Player) source;
            if (name.equalsIgnoreCase("+windmill")) {
                p.sendMessage("Windmill command has been executed");
                HitBlockComponent hit = p.get(HitBlockComponent.class);
                if (hit != null) {
                    Block b = hit.getTargetBlock();
                    b.setMaterial(TestMaterials.WINDMILL_BLOCK);
                    p.sendMessage("Block at ", b.getPosition(), " has been set to a 'Windmill'");
                }
            }
        }
    }
}