package com.ancestralcraft;

import com.ancestralcraft.creativemodetab.ModCreativeModeTabs;
import com.ancestralcraft.item.ModBlocks;
import com.ancestralcraft.item.ModItems;
import com.ancestralcraft.item.custom.PicoAncestralItem;
import com.ancestralcraft.loot.ModLoot;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AncestralCraft implements ModInitializer {
	public static final String MOD_ID = "ancestralcraft";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModLoot.register();
		ModCreativeModeTabs.registerModCreativeTabs();
		PicoAncestralItem.registerEvents();
		ModBlocks.registerModBlocks();
	}
}
