package com.volumetricpixels.testmodule;

import org.spout.api.command.CommandArguments;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Binding;
import org.spout.api.command.annotated.Command;
import org.spout.api.command.annotated.Filter;
import org.spout.api.command.filter.PlayerFilter;
import org.spout.api.component.entity.InteractComponent;
import org.spout.api.entity.Player;
import org.spout.api.exception.CommandException;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.input.Keyboard;
import org.spout.api.material.BlockMaterial;

public class TMCommands {

    @Command(aliases = {"battery"}, desc = "Sets the block to a battery", min = 0, max = 0)
    @Binding(Keyboard.KEY_B)
    @Filter(PlayerFilter.class)
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

    @Command(aliases = {"windmill"}, desc = "Sets the block to a windmill", min = 0, max = 0)
    @Binding(Keyboard.KEY_B)
    @Filter(PlayerFilter.class)
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