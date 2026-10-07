package com.ancestralcraft.loot;

import com.ancestralcraft.AncestralCraft;
import com.ancestralcraft.item.ModItems;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

public class ModLoot {

    // ==========================================
    // CIUDAD ANTIGUA
    // ==========================================

    private static final ResourceKey<LootTable> ANCIENT_CITY =
            ResourceKey.create(
                    Registries.LOOT_TABLE,
                    Identifier.parse(
                            "minecraft:chests/ancient_city"
                    )
            );

    // ==========================================
    // TRIAL CHAMBERS
    // ==========================================

    private static final ResourceKey<LootTable> TRIAL_CHAMBER_REWARD =
            ResourceKey.create(
                    Registries.LOOT_TABLE,
                    Identifier.parse(
                            "minecraft:chests/trial_chambers/reward"
                    )
            );

    private static final ResourceKey<LootTable> TRIAL_CHAMBER_CHEST =
            ResourceKey.create(
                    Registries.LOOT_TABLE,
                    Identifier.parse(
                            "minecraft:chests/trial_chambers"
                    )
            );

    // ==========================================
    // BASTIONES
    // ==========================================

    private static final ResourceKey<LootTable> BASTION_TREASURE =
            ResourceKey.create(
                    Registries.LOOT_TABLE,
                    Identifier.parse(
                            "minecraft:chests/bastion_treasure"
                    )
            );

    // ==========================================
    // END CITY
    // ==========================================

    private static final ResourceKey<LootTable> END_CITY =
            ResourceKey.create(
                    Registries.LOOT_TABLE,
                    Identifier.parse(
                            "minecraft:chests/end_city_treasure"
                    )
            );

    private static final ResourceKey<LootTable> STRONGHOLD =
            ResourceKey.create(
                    Registries.LOOT_TABLE,
                    Identifier.parse(
                            "minecraft:chests/stronghold_treasure"
                    )
            );

    public static void register() {

        LootTableEvents.MODIFY.register(
                (key, tableBuilder, source, registries) -> {

                    if (!source.isBuiltin()) {
                        return;
                    }

                    // ==========================================
                    // CIUDAD ANTIGUA
                    // ❤️ Corazón: 1%
                    // 🪨 Piedra: 3%
                    // ==========================================

                    if (ANCIENT_CITY.equals(key)) {

                        // Corazón Ancestral
                        LootPool.Builder corazon =
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(
                                                        ModItems.CORAZON_ANCESTRAL
                                                )
                                        )
                                        .when(
                                                LootItemRandomChanceCondition.randomChance(
                                                        0.01f
                                                )
                                        );

                        tableBuilder.withPool(corazon);

                        // Piedra Ancestral
                        LootPool.Builder piedra =
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(
                                                        ModItems.PIEDRA_ANCESTRAL
                                                )
                                        )
                                        .when(
                                                LootItemRandomChanceCondition.randomChance(
                                                        0.03f
                                                )
                                        );

                        tableBuilder.withPool(piedra);
                    }

                    // ==========================================
                    // TRIAL CHAMBERS
                    // ❤️ Corazón: 2%
                    // 🪨 Piedra: 5%
                    // ==========================================

                    if (TRIAL_CHAMBER_REWARD.equals(key)) {

                        // Corazón Ancestral
                        LootPool.Builder corazon =
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(
                                                        ModItems.CORAZON_ANCESTRAL
                                                )
                                        )
                                        .when(
                                                LootItemRandomChanceCondition.randomChance(
                                                        0.10f
                                                )
                                        );

                        tableBuilder.withPool(corazon);

                        // Piedra Ancestral
                        LootPool.Builder piedra =
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(
                                                        ModItems.PIEDRA_ANCESTRAL
                                                )
                                        )
                                        .when(
                                                LootItemRandomChanceCondition.randomChance(
                                                        0.08f
                                                )
                                        );

                        tableBuilder.withPool(piedra);
                    }

                    // ==========================================
                    // BASTIONES
                    // ❤️ Corazón: 3%
                    // 🪨 Piedra: 5%
                    // ==========================================

                    if (BASTION_TREASURE.equals(key)) {

                        // Corazón Ancestral
                        LootPool.Builder corazon =
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(
                                                        ModItems.CORAZON_ANCESTRAL
                                                )
                                        )
                                        .when(
                                                LootItemRandomChanceCondition.randomChance(
                                                        0.08f
                                                )
                                        );

                        tableBuilder.withPool(corazon);

                        // Piedra Ancestral
                        LootPool.Builder piedra =
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(
                                                        ModItems.PIEDRA_ANCESTRAL
                                                )
                                        )
                                        .when(
                                                LootItemRandomChanceCondition.randomChance(
                                                        0.05f
                                                )
                                        );

                        tableBuilder.withPool(piedra);
                    }

                    // ==========================================
                    // END CITY
                    // 🪨 Piedra: 6%
                    // ==========================================

                    if (END_CITY.equals(key)) {
                        // Corazón Ancestral
                        LootPool.Builder corazon =
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(
                                                        ModItems.CORAZON_ANCESTRAL
                                                )
                                        )
                                        .when(
                                                LootItemRandomChanceCondition.randomChance(
                                                        0.10f
                                                )
                                        );

                        LootPool.Builder piedra =
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(
                                                        ModItems.PIEDRA_ANCESTRAL
                                                )
                                        )
                                        .when(
                                                LootItemRandomChanceCondition.randomChance(
                                                        0.10f
                                                )
                                        );

                        tableBuilder.withPool(piedra);
                    }

                    if (TRIAL_CHAMBER_CHEST.equals(key)) {

                        // Corazón Ancestral
                        LootPool.Builder corazon =
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(
                                                        ModItems.CORAZON_ANCESTRAL
                                                )
                                        )
                                        .when(
                                                LootItemRandomChanceCondition.randomChance(
                                                        0.10f
                                                )
                                        );

                        tableBuilder.withPool(corazon);

                        // Piedra Ancestral
                        LootPool.Builder piedra =
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(
                                                        ModItems.PIEDRA_ANCESTRAL
                                                )
                                        )
                                        .when(
                                                LootItemRandomChanceCondition.randomChance(
                                                        0.08f
                                                )
                                        );

                        tableBuilder.withPool(piedra);
                    }
                }
        );

        AncestralCraft.LOGGER.info(
                "Loot tables de Bolsa Ancestral registradas."
        );
    }
}