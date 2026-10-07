package com.ancestralcraft.tags;

import com.ancestralcraft.AncestralCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;



public class ModTags {
    public static class Items {
        public static final TagKey<Item> ANCESTRAL_REPAIR = createTag("ancestral_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(AncestralCraft.MOD_ID, name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> NEEDS_PICO_ANCESTRAL = createTag("needs_pico_ancestral");
        public static final TagKey<Block> INCORRECT_FOR_PICO_ANCESTRAL = createTag("incorrect_for_pico_ancestral");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(AncestralCraft.MOD_ID, name));
        }
    }

}
