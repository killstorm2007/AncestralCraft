package com.ancestralcraft.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CorazonAncestralItem extends Item {

    private static final double VIDA_POR_CORAZON = 2.0;
    private static final double VIDA_MAXIMA = 40.0;

    public CorazonAncestralItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(
            Level level,
            Player player,
            InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide()) {

            AttributeInstance atributoVida =
                    player.getAttribute(Attributes.MAX_HEALTH);

            if (atributoVida == null) {
                return InteractionResult.FAIL;
            }

            double vidaActual =
                    atributoVida.getBaseValue();

            // Ya tiene el máximo de 20 corazones
            if (vidaActual >= VIDA_MAXIMA) {
                return InteractionResult.FAIL;
            }

            double nuevaVida = Math.min(
                    vidaActual + VIDA_POR_CORAZON,
                    VIDA_MAXIMA
            );

            atributoVida.setBaseValue(nuevaVida);

            // Recupera el corazón ganado
            player.setHealth((float) nuevaVida);

            level.playSound(
                    null,
                    player.blockPosition(),
                    SoundEvents.PLAYER_BURP,
                    SoundSource.PLAYERS,
                    1.0F,
                    1.2F
            );

            // Consumir el corazón
            stack.shrink(1);
        }

        return InteractionResult.SUCCESS;
    }
}