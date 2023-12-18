package dev.mayaqq.atmos.registry;

import dev.mayaqq.atmos.Atmos;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class AtmosBlocks {
    public static void register() {}

    private static Block register(String name, Block block) {
        Registry.register(Registries.ITEM, Atmos.id(name), new BlockItem(block, new FabricItemSettings()));
        return Registry.register(Registries.BLOCK, Atmos.id(name), block);
    }
}
