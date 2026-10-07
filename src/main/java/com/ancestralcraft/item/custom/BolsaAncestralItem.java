package com.ancestralcraft.item.custom;

import com.ancestralcraft.menu.BolsaMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BolsaAncestralItem extends Item {

    public BolsaAncestralItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(
            Level level,
            Player player,
            InteractionHand hand) {

        if (!level.isClientSide()
                && player instanceof ServerPlayer serverPlayer) {

            ItemStack bolsa = player.getItemInHand(hand);

            serverPlayer.openMenu(new MenuProvider() {

                @Override
                public Component getDisplayName() {
                    return Component.literal("Bolsa Ancestral");
                }

                @Override
                public BolsaMenu createMenu(
                        int containerId,
                        Inventory inventory,
                        Player player) {

                    return new BolsaMenu(
                            containerId,
                            inventory,
                            bolsa
                    );
                }
            });
            // 🔊 Sonido al abrir la bolsa
            serverPlayer.level().playSound(
                    null,
                    serverPlayer.blockPosition(),
                    SoundEvents.BUNDLE_INSERT,
                    net.minecraft.sounds.SoundSource.PLAYERS,
                    1.0F,
                    1.0F
            );
        }

        return InteractionResult.SUCCESS;
    }
}