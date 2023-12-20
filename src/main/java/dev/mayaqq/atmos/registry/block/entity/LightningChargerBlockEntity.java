package dev.mayaqq.atmos.registry.block.entity;

import dev.mayaqq.atmos.registry.AtmosBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class LightningChargerBlockEntity extends BlockEntity {
    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(0, 0, 0) {
        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };
    public LightningChargerBlockEntity(BlockPos pos, BlockState state) {
        super(AtmosBlockEntities.LIGHTNING_CHARGER, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, LightningChargerBlockEntity blockEntity) {}
}
