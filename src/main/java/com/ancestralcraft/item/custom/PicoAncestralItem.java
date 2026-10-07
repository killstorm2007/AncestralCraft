package com.ancestralcraft.item.custom;

import com.ancestralcraft.item.ModItems;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class PicoAncestralItem extends net.minecraft.world.item.Item {

    private static final ThreadLocal<Boolean> ROMPIENDO_3X3 =
            ThreadLocal.withInitial(() -> false);

    public PicoAncestralItem(Properties properties) {
        super(properties);
    }

    public static void registerEvents() {

        PlayerBlockBreakEvents.AFTER.register(
                (level, player, pos, state, blockEntity) -> {

                    // Evitar ejecución en cliente
                    if (level.isClientSide()) {
                        return;
                    }

                    // Evitar que los bloques adicionales vuelvan a activar el 3x3
                    if (ROMPIENDO_3X3.get()) {
                        return;
                    }

                    ItemStack pico = player.getMainHandItem();

                    // Comprobar que realmente sea el Pico Ancestral
                    if (!pico.is(ModItems.PICO_ANCESTRAL)) {
                        return;
                    }

                    ROMPIENDO_3X3.set(true);

                    try {
                        romper3x3(level, player, pos, pico);
                    } finally {
                        ROMPIENDO_3X3.set(false);
                    }
                }
        );
    }

    private static void romper3x3(
            Level level,
            Player player,
            BlockPos centro,
            ItemStack pico) {

        Direction.Axis eje = obtenerEjeDeMirada(player);

        for (int a = -1; a <= 1; a++) {

            for (int b = -1; b <= 1; b++) {

                // No volver a romper el bloque central
                if (a == 0 && b == 0) {
                    continue;
                }

                BlockPos objetivo;

                /*
                 * Si miramos principalmente hacia X:
                 *
                 *        Y
                 *        ↑
                 *     3 x 3
                 *        →
                 *        Z
                 */
                if (eje == Direction.Axis.X) {

                    objetivo = centro.offset(
                            0,
                            a,
                            b
                    );

                    /*
                     * Si miramos principalmente hacia Y:
                     *
                     * plano horizontal X/Z
                     */
                } else if (eje == Direction.Axis.Y) {

                    objetivo = centro.offset(
                            a,
                            0,
                            b
                    );

                    /*
                     * Si miramos principalmente hacia Z:
                     *
                     * plano vertical X/Y
                     */
                } else {

                    objetivo = centro.offset(
                            a,
                            b,
                            0
                    );
                }

                romperBloque(
                        level,
                        player,
                        objetivo,
                        pico
                );
            }
        }
    }

    private static void romperBloque(
            Level level,
            Player player,
            BlockPos pos,
            ItemStack pico) {

        BlockState state = level.getBlockState(pos);

        // Aire
        if (state.isAir()) {
            return;
        }

        /*
         * Solo romper bloques que el pico puede minar
         * correctamente y de los que puede obtener drops.
         */
        if (!pico.isCorrectToolForDrops(state)) {
            return;
        }

        /*
         * No romper bloques con entidad.
         *
         * Esto evita destruir accidentalmente:
         * - Cofres
         * - Hornos
         * - Barriles
         * - Shulkers
         * - etc.
         */
        if (level.getBlockEntity(pos) != null) {
            return;
        }

        // Romper y generar los drops normales
        boolean roto = level.destroyBlock(
                pos,
                true,
                player
        );

        if (roto) {

            // Gastar 1 de durabilidad
            pico.hurtWithoutBreaking(
                    1,
                    player
            );
        }
    }

    private static Direction.Axis obtenerEjeDeMirada(Player player) {

        double x = Math.abs(player.getLookAngle().x);
        double y = Math.abs(player.getLookAngle().y);
        double z = Math.abs(player.getLookAngle().z);

        if (x >= y && x >= z) {
            return Direction.Axis.X;
        }

        if (y >= x && y >= z) {
            return Direction.Axis.Y;
        }

        return Direction.Axis.Z;
    }
}