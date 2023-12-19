package dev.mayaqq.atmos.registry;

import dev.mayaqq.atmos.Atmos;
import dev.mayaqq.atmos.registry.block.TimeChangerBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class AtmosBlocks {
    public static final Block TIME_CHANGER = register("time_changer", new TimeChangerBlock(FabricBlockSettings.create()));
    public static void register() {}

    public static Block register(String name, Block block) {
        Registry.register(Registries.ITEM, Atmos.id(name), new BlockItem(block, new FabricItemSettings()));
        Block registered = Registry.register(Registries.BLOCK, Atmos.id(name), block);
        AtmosItemGroups.items.add(registered.asItem().getDefaultStack());
        return registered;
    }
}
