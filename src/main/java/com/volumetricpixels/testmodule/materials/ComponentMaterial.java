package com.volumetricpixels.testmodule.materials;

import org.spout.api.component.type.BlockComponent;
import org.spout.api.entity.Entity;
import org.spout.api.event.Cause;
import org.spout.api.event.player.PlayerInteractEvent;
import org.spout.api.geo.LoadOption;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.geo.discrete.Point;
import org.spout.api.material.BlockMaterial;
import org.spout.api.material.ComplexMaterial;
import org.spout.api.material.Material;
import org.spout.api.material.block.BlockFace;
import org.spout.api.math.Vector3;
import org.spout.vanilla.component.substance.material.VanillaBlockComponent;

public class ComponentMaterial extends BlockMaterial implements ComplexMaterial {
	private final Class<? extends BlockComponent> componentType;

	public ComponentMaterial(String name, Class<? extends BlockComponent> component, String model) {
		super((short) 0, name, model);
		this.componentType = component;
	}

	public ComponentMaterial(String name, int data, Material parent, String model, Class<? extends BlockComponent> component) {
		super(name, data, parent, model);
		this.componentType = component;
	}

	public BlockComponent spawn(Point pos) {
		return pos.getWorld().createAndSpawnEntity(pos, componentType, LoadOption.NO_LOAD).add(componentType);
	}

	@Override
	public void onInteractBy(Entity entity, Block block, PlayerInteractEvent.Action type, BlockFace clickedFace) {
		super.onInteract(entity, block, type, clickedFace);
		BlockComponent c = block.getComponent();
		Point pos = block.getPosition();
		if (c == null || !c.getClass().equals(componentType)) {
			c = spawn(pos);
		}

		if (c == null) {
			throw new IllegalStateException("Failed to spawn " + componentType.getName() + " at (" + pos.getX() + "," + pos.getY() + "," + pos.getZ() + ")");
		}

		((VanillaBlockComponent) c).onInteractBy(entity, type, clickedFace);
	}

	@Override
	public boolean onPlacement(Block block, short data, BlockFace against, Vector3 clickedPos, boolean isClickedBlock, Cause<?> cause) {
		if (super.onPlacement(block, data, against, clickedPos, isClickedBlock, cause)) {
			spawn(block.getPosition());
			return true;
		}
		return false;
	}

	public BlockComponent createBlockComponent() {
		try {
			return componentType.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
