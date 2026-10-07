package com.ancestralcraft.datagen;

import com.ancestralcraft.item.ModBlocks;
import com.ancestralcraft.item.ModItems;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

import java.util.Map;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(
            BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.BLOQUE_ANCESTRAL);
    }

    @Override
    public void generateItemModels(
            ItemModelGenerators itemModelGenerators) {

        // Objetos
        itemModelGenerators.generateFlatItem(
                ModItems.BOLSA,
                ModelTemplates.FLAT_ITEM
        );

        itemModelGenerators.generateFlatItem(
                ModItems.CORAZON_ANCESTRAL,
                ModelTemplates.FLAT_ITEM
        );

        itemModelGenerators.generateFlatItem(
                ModItems.PIEDRA_ANCESTRAL,
                ModelTemplates.FLAT_ITEM
        );

        itemModelGenerators.generateFlatItem(
                ModItems.LINGOTE_ANCESTRAL,
                ModelTemplates.FLAT_ITEM
        );

        itemModelGenerators.generateFlatItem(
                ModItems.PICO_ANCESTRAL,
                ModelTemplates.FLAT_HANDHELD_ITEM
        );

        // Armadura ancestral
        itemModelGenerators.generateTrimmableItem(
                ModItems.CASCO_ANCESTRAL,
                ItemModelGenerators.TRIM_PREFIX_HELMET,
                false,
                Map.of()
        );

        itemModelGenerators.generateTrimmableItem(
                ModItems.PECHERA_ANCESTRAL,
                ItemModelGenerators.TRIM_PREFIX_CHESTPLATE,
                false,
                Map.of()
        );

        itemModelGenerators.generateTrimmableItem(
                ModItems.PANTALONES_ANCESTRALES,
                ItemModelGenerators.TRIM_PREFIX_LEGGINGS,
                false,
                Map.of()
        );

        itemModelGenerators.generateTrimmableItem(
                ModItems.BOTAS_ANCESTRALES,
                ItemModelGenerators.TRIM_PREFIX_BOOTS,
                false,
                Map.of()
        );
    }
}