package com.ancestralcraft.item;

import com.ancestralcraft.AncestralCraft;
import com.ancestralcraft.item.custom.ArmaduraAncestralMaterial;
import com.ancestralcraft.item.custom.BolsaAncestralItem;
import com.ancestralcraft.item.custom.CorazonAncestralItem;
import com.ancestralcraft.item.custom.PicoAncestralItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.List;
import java.util.function.Function;

public class ModItems {

    private static EquipmentSlotGroup getSlotGroup(ArmorType type) {
        return switch (type) {
            case HELMET -> EquipmentSlotGroup.HEAD;
            case CHESTPLATE -> EquipmentSlotGroup.CHEST;
            case LEGGINGS -> EquipmentSlotGroup.LEGS;
            case BOOTS -> EquipmentSlotGroup.FEET;
            case BODY -> EquipmentSlotGroup.BODY;
        };
    }

    private static Item.Properties vidaExtra(
            Item.Properties properties,
            ArmorType type,
            String nombre
    ) {
        EquipmentSlotGroup slotGroup = getSlotGroup(type);

        int defensa = ArmaduraAncestralMaterial.ARMADURA_ANCESTRAL_MATERIAL.defense().getOrDefault(type, 0);

        return properties.attributes(
                ItemAttributeModifiers.builder()
                        .add(
                                Attributes.ARMOR,
                                new AttributeModifier(
                                        Identifier.fromNamespaceAndPath(AncestralCraft.MOD_ID, nombre + "_defense"),
                                        defensa,
                                        AttributeModifier.Operation.ADD_VALUE
                                ),
                                slotGroup
                        )
                        .add(
                                Attributes.ARMOR_TOUGHNESS,
                                new AttributeModifier(
                                        Identifier.fromNamespaceAndPath(AncestralCraft.MOD_ID, nombre + "_toughness"),
                                        4.0,
                                        AttributeModifier.Operation.ADD_VALUE
                                ),
                                slotGroup
                        )
                        .add(
                                Attributes.KNOCKBACK_RESISTANCE,
                                new AttributeModifier(
                                        Identifier.fromNamespaceAndPath(AncestralCraft.MOD_ID, nombre + "_knockback"),
                                        0.25,
                                        AttributeModifier.Operation.ADD_VALUE
                                ),
                                slotGroup
                        )
                        .add(
                                Attributes.MAX_HEALTH,
                                new AttributeModifier(
                                        Identifier.fromNamespaceAndPath(AncestralCraft.MOD_ID, nombre),
                                        1.0,
                                        AttributeModifier.Operation.ADD_VALUE
                                ),
                                slotGroup
                        )
                        .build()
        );
    }

    public static final Item CASCO_ANCESTRAL = registerItem(
            "casco_ancestral",
            properties -> new Item(
                    vidaExtra(
                            properties.humanoidArmor(
                                            ArmaduraAncestralMaterial.ARMADURA_ANCESTRAL_MATERIAL,
                                            ArmorType.HELMET
                                    ).rarity(Rarity.RARE)
                                    .fireResistant(),
                            ArmorType.HELMET,
                            "casco_vida_extra"
                    )
            )
    );

    public static final Item PECHERA_ANCESTRAL = registerItem(
            "pechera_ancestral",
            properties -> new Item(
                    vidaExtra(
                            properties.humanoidArmor(
                                            ArmaduraAncestralMaterial.ARMADURA_ANCESTRAL_MATERIAL,
                                            ArmorType.CHESTPLATE
                                    ).rarity(Rarity.RARE)
                                    .fireResistant(),
                            ArmorType.CHESTPLATE,
                            "pechera_vida_extra"
                    )
            )
    );

    public static final Item PANTALONES_ANCESTRALES = registerItem(
            "pantalones_ancestrales",
            properties -> new Item(
                    vidaExtra(
                            properties.humanoidArmor(
                                            ArmaduraAncestralMaterial.ARMADURA_ANCESTRAL_MATERIAL,
                                            ArmorType.LEGGINGS
                                    ).rarity(Rarity.RARE)
                                    .fireResistant(),
                            ArmorType.LEGGINGS,
                            "pantalones_vida_extra"
                    )
            )
    );

    public static final Item BOTAS_ANCESTRALES = registerItem(
            "botas_ancestrales",
            properties -> new Item(
                    vidaExtra(
                            properties.humanoidArmor(
                                            ArmaduraAncestralMaterial.ARMADURA_ANCESTRAL_MATERIAL,
                                            ArmorType.BOOTS
                                    ).rarity(Rarity.RARE)
                                    .fireResistant(),
                            ArmorType.BOOTS,
                            "botas_vida_extra"
                    )
            )
    );

    public static final Item PIEDRA_ANCESTRAL = registerItem(
            "piedra_ancestral",
            properties -> new Item(
                    properties
                            .stacksTo(64)
                            .rarity(Rarity.RARE)
            )
    );

    public static final Item LINGOTE_ANCESTRAL = registerItem(
            "lingote_ancestral",
            properties -> new Item(
                    properties
                            .stacksTo(64)
                            .rarity(Rarity.EPIC)
            )
    );

    public static final Item CORAZON_ANCESTRAL = registerItem(
            "corazon_ancestral", properties -> new CorazonAncestralItem(
                    properties
                            .rarity(Rarity.EPIC).component(DataComponents.LORE,
                                    new ItemLore(
                                            List.of(
                                                    Component.literal("Al consumir el Corazon Ancestral").withStyle(style -> style.withColor(0x808080)),
                                                    Component.literal("aumentas en 1 tu Salud Maxima").withStyle(style -> style.withColor(0xAA00FF))
                                            )))
            ));

    public static final Item BOLSA = registerItem(
            "bolsa_ancestral",
            propierties -> new BolsaAncestralItem(
                    propierties
                            .stacksTo(1)
                            .rarity(Rarity.RARE)
                            .fireResistant()
                            .component(
                                    DataComponents.LORE,
                                    new ItemLore(
                                            List.of(
                                                    Component.literal("Utilizala para guardar objetos y que"),
                                                    Component.literal("no ocupen slots en tu inventario"),
                                                    Component.literal(""),
                                                    Component.literal("Tiene: 27 slots")
                                            )
                                    )
                            )
            )
    );

    public static final Item PICO_ANCESTRAL = registerItem(
            "pico_ancestral",
            properties -> new PicoAncestralItem(
                    properties
                            .pickaxe(
                                    ModToolMaterials.ANCESTRAL,
                                    1,
                                    -2.0F
                            )
                            .stacksTo(1)
                            .fireResistant()
                            .component(
                                    DataComponents.LORE,
                                    new ItemLore(
                                            List.of(
                                                    Component.literal(
                                                            "Permite minar en un radio 3x3"
                                                    )
                                            )
                                    )
                            )
            )
    );

    private static Item registerItem(
            String name, Function<Item.Properties, Item> function) {

        Identifier id = Identifier.fromNamespaceAndPath(
                AncestralCraft.MOD_ID, name
        );

        return Registry.register(BuiltInRegistries.ITEM, id,
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id))
                        .component(DataComponents.CONTAINER, ItemContainerContents.EMPTY))
        );
    }

    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    public static void registerModItems() {

        AncestralCraft.LOGGER.info("Registering Mod Items for: " + AncestralCraft.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register(output -> output.accept(BOLSA));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register(output -> output.accept(CORAZON_ANCESTRAL));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register(output -> output.accept(PIEDRA_ANCESTRAL));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register(output -> output.accept(LINGOTE_ANCESTRAL));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register(output -> output.accept(CASCO_ANCESTRAL));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register(output -> output.accept(PECHERA_ANCESTRAL));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register(output -> output.accept(PANTALONES_ANCESTRALES));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register(output -> output.accept(BOTAS_ANCESTRALES));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register(output -> output.accept(PICO_ANCESTRAL));

    }
}