package com.ancestralcraft.datagen;

import com.ancestralcraft.item.ModBlocks;
import com.ancestralcraft.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModBlockTagsProvider(
            FabricPackOutput output,
            CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.getRK(ModBlocks.BLOQUE_ANCESTRAL));

        // Bloques que NO puede minar correctamente el Pico Ancestral
        tag(ModTags.Blocks.INCORRECT_FOR_PICO_ANCESTRAL);

        // Bloques que requieren el Pico Ancestral
        tag(ModTags.Blocks.NEEDS_PICO_ANCESTRAL);
    }
}