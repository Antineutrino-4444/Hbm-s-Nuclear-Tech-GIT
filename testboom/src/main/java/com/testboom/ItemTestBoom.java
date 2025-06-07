package com.testboom;

import java.util.List;

import com.hbm.config.BombConfig;
import com.hbm.entity.logic.EntityNukeExplosionMK5;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemTestBoom extends Item {
	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		if(entityItem != null && !entityItem.worldObj.isRemote && entityItem.onGround) {
			entityItem.worldObj.spawnEntityInWorld(EntityNukeExplosionMK5.statFac(entityItem.worldObj, BombConfig.boyRadius, entityItem.posX, entityItem.posY, entityItem.posZ));
			entityItem.worldObj.playSoundEffect(entityItem.posX, entityItem.posY, entityItem.posZ, "random.explode", 1.0F, entityItem.worldObj.rand.nextFloat() * 0.1F + 0.9F);
			entityItem.setDead();
			return true;
		}
		return false;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
		list.add(EnumChatFormatting.RED + "[Drop to detonate]");
	}
}
