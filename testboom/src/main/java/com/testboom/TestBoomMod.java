package com.testboom;

import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = TestBoomMod.MODID, name = "Test Boom", version = "1.0", dependencies = "required-after:hbm")
public class TestBoomMod {
	public static final String MODID = "testboom";
	public static Item testboom;
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		testboom = new ItemTestBoom().setUnlocalizedName("testboom").setTextureName(MODID + ":testboom");
		GameRegistry.registerItem(testboom, "testboom");
	}
}
