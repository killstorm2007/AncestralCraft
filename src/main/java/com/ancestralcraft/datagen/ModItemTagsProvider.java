package com.ancestralcraft.datagen;

import com.ancestralcraft.item.ModItems;
import com.ancestralcraft.tags.ModTags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {

    public ModItemTagsProvider(
            FabricPackOutput output,
            CompletableFuture<HolderLookup.Provider> registriesFuture) {

        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        tag(ModTags.Items.ANCESTRAL_REPAIR)
                .add(ModItems.getRK(ModItems.LINGOTE_ANCESTRAL));

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.getRK(ModItems.CASCO_ANCESTRAL));

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.getRK(ModItems.PECHERA_ANCESTRAL));

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.getRK(ModItems.PANTALONES_ANCESTRALES));

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.getRK(ModItems.BOTAS_ANCESTRALES));
        tag(ItemTags.PICKAXES)
                .add(ModItems.getRK(ModItems.PICO_ANCESTRAL));
    }
}