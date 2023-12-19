package dev.mayaqq.atmos.registry.block.entity;

import dev.mayaqq.atmos.config.AtmosConfig;
import dev.mayaqq.atmos.registry.AtmosBlockEntities;
import dev.mayaqq.atmos.screen.TimeChangerScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class TimeChangerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {
    public final Inventory inventory = new SimpleInventory(1);
    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(AtmosConfig.HANDLER.instance().timeChangerCapacity, 10_000, 10_000) {
        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };
    public TimeChangerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AtmosBlockEntities.TIME_CHANGER, blockPos, blockState);
    }

    public static void tick(World world, BlockPos pos, BlockState state, TimeChangerBlockEntity blockEntity) {}

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new TimeChangerScreenHandler(syncId, playerInventory, this.inventory, ScreenHandlerContext.create(world, pos));
    }
}
