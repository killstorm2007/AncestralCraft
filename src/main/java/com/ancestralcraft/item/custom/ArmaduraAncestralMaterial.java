package com.ancestralcraft.item.custom;

import com.ancestralcraft.AncestralCraft;
import com.ancestralcraft.tags.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;

import net.minecraft.world.item.equipment.*;


public class ArmaduraAncestralMaterial {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> ANCESTRAL_KEY =
            ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(AncestralCraft.MOD_ID, "ancestral"));

    public static final ArmorMaterial ARMADURA_ANCESTRAL_MATERIAL = new ArmorMaterial(300,
            ArmorMaterials.makeDefense(4,8,10,4,25), 20, SoundEvents.ARMOR_EQUIP_NETHERITE,4F,0.25F, ModTags.Items.ANCESTRAL_REPAIR, ANCESTRAL_KEY
    );
}
