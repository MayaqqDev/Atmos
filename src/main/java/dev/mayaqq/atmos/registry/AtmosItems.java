package dev.mayaqq.atmos.registry;

import dev.mayaqq.atmos.Atmos;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class AtmosItems {
    public static void register() {}

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, Atmos.id(name), item);
    }
}
