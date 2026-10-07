package com.ancestralcraft.creativemodetab;

import com.ancestralcraft.AncestralCraft;
import com.ancestralcraft.item.ModBlocks;
import com.ancestralcraft.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab OBJETOS_ANCESTRALES_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(AncestralCraft.MOD_ID, "objetos_ancestrales"),
            FabricCreativeModeTab.builder().icon(()-> new ItemStack(ModItems.BOLSA))
                    .title(Component.translatable("creativetab.bolsa-ancestral.objetos_ancestrales"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BOTAS_ANCESTRALES);
                        output.accept(ModItems.PANTALONES_ANCESTRALES);
                        output.accept(ModItems.PECHERA_ANCESTRAL);
                        output.accept(ModItems.CASCO_ANCESTRAL);
                        output.accept(ModItems.LINGOTE_ANCESTRAL);
                        output.accept(ModItems.CORAZON_ANCESTRAL);
                        output.accept(ModItems.PIEDRA_ANCESTRAL);
                        output.accept(ModItems.BOLSA);
                        output.accept(ModItems.PICO_ANCESTRAL);
                        output.accept(ModBlocks.BLOQUE_ANCESTRAL);
                    }).build());

    public static void registerModCreativeTabs() {
        AncestralCraft.LOGGER.info("Registrando Creative Tabs para: " + AncestralCraft.MOD_ID);
    }
}
