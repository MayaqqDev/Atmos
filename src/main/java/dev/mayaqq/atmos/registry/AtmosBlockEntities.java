package dev.mayaqq.atmos.registry;

import dev.mayaqq.atmos.Atmos;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class AtmosBlockEntities {
    public static void register() {}

    private static BlockEntityType<?> register(String name, BlockEntityType<?> blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Atmos.id(name), blockEntityType);
    }
}
