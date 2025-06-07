package com.hbm.items.special;

import com.hbm.config.BombConfig;
import com.hbm.entity.logic.EntityNukeExplosionMK5;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ItemTestBoom extends Item {

	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		if(entityItem != null && entityItem.onGround && !entityItem.worldObj.isRemote) {
		World world = entityItem.worldObj;
		world.spawnEntityInWorld(EntityNukeExplosionMK5.statFac(world, BombConfig.boyRadius, entityItem.posX, entityItem.posY, entityItem.posZ));
		entityItem.setDead();
		return true;
	}
	return false;
	}
}

