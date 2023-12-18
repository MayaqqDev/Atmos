package dev.mayaqq.atmos.screen;

import dev.mayaqq.atmos.registry.AtmosScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import team.reborn.energy.api.EnergyStorage;

public class TimeChangerScreenHandler extends ScreenHandler {
    private final int INVENTORY_START = 5;
    private final int INVENTORY_END = 32;
    private final int HOTBAR_START = 32;
    private final int HOTBAR_END = 41;

    private final Inventory inventory;
    private final ScreenHandlerContext context;
    private final PlayerEntity player;

    public TimeChangerScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(1), ScreenHandlerContext.EMPTY);
    }
    public TimeChangerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, ScreenHandlerContext context) {
        super(AtmosScreenHandlers.TIME_CHANGER, syncId);

        this.inventory = inventory;
        this.context = context;
        this.player = playerInventory.player;

        this.addSlot(new Slot(inventory, 0 , 22, 36));

        this.addPlayerInventory(playerInventory);
        this.addPlayerHotbar(playerInventory);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }

    private void addPlayerInventory(PlayerInventory inventory) {
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory inventory) {
        for (int slot = 0; slot < 9; ++slot) {
            this.addSlot(new Slot(inventory, slot, 8 + slot * 18, 142));
        }
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
    }

    public ScreenHandlerContext getContext() {
        return context;
    }
}
