package dev.mayaqq.atmos.registry;

import dev.mayaqq.atmos.Atmos;
import dev.mayaqq.atmos.registry.block.entity.LightningChargerBlockEntity;
import dev.mayaqq.atmos.registry.block.entity.TimeChangerBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import team.reborn.energy.api.EnergyStorage;

public class AtmosBlockEntities {
    public static final BlockEntityType<TimeChangerBlockEntity> TIME_CHANGER = register("time_changer", FabricBlockEntityTypeBuilder.create(
            TimeChangerBlockEntity::new,
            AtmosBlocks.TIME_CHANGER
    ).build());

    public static final BlockEntityType<LightningChargerBlockEntity> LIGHTNING_CHARGER = register("lighting_charger", FabricBlockEntityTypeBuilder.create(
            LightningChargerBlockEntity::new,
            AtmosBlocks.LIGHTNING_CHARGER
    ).build());

    public static void register() {
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, TIME_CHANGER);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, LIGHTNING_CHARGER);
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Atmos.id(name), blockEntityType);
    }
}
