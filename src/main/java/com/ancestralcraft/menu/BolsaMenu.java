package com.ancestralcraft.menu;

import com.ancestralcraft.item.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;

public class BolsaMenu extends ChestMenu {

    private final ItemStack bolsa;
    private final Container bolsaContainer;

    public BolsaMenu(
            int containerId,
            Inventory playerInventory,
            ItemStack bolsa) {

        this(
                containerId,
                playerInventory,
                bolsa,
                crearContenedor(bolsa)
        );
    }

    private BolsaMenu(
            int containerId,
            Inventory playerInventory,
            ItemStack bolsa,
            Container container) {

        super(
                MenuType.GENERIC_9x3,
                containerId,
                playerInventory,
                container,
                3
        );

        this.bolsa = bolsa;
        this.bolsaContainer = container;
    }

    private static Container crearContenedor(ItemStack bolsa) {

        SimpleContainer container = new SimpleContainer(27);

        ItemContainerContents contents =
                bolsa.getOrDefault(
                        net.minecraft.core.component.DataComponents.CONTAINER,
                        ItemContainerContents.EMPTY
                );

        NonNullList<ItemStack> stacks =
                NonNullList.withSize(
                        27,
                        ItemStack.EMPTY
                );

        contents.copyInto(stacks);

        for (int i = 0; i < 27; i++) {
            container.setItem(
                    i,
                    stacks.get(i)
            );
        }

        return container;
    }

    @Override
    public boolean stillValid(Player player) {

        return player.getMainHandItem().is(ModItems.BOLSA)
                || player.getOffhandItem().is(ModItems.BOLSA);
    }

    @Override
    public void removed(Player player) {

        guardarContenido();

        super.removed(player);
    }

    private void guardarContenido() {

        NonNullList<ItemStack> stacks =
                NonNullList.withSize(
                        27,
                        ItemStack.EMPTY
                );

        for (int i = 0; i < 27; i++) {

            stacks.set(
                    i,
                    bolsaContainer.getItem(i).copy()
            );
        }

        bolsa.set(
                net.minecraft.core.component.DataComponents.CONTAINER,
                ItemContainerContents.fromItems(stacks)
        );
    }

    @Override
    public boolean canTakeItemForPickAll(
            ItemStack stack,
            net.minecraft.world.inventory.Slot slot) {

        return slot.container != bolsaContainer
                && super.canTakeItemForPickAll(stack, slot);
    }
}