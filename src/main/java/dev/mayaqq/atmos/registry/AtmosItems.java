package dev.mayaqq.atmos.registry;

import dev.mayaqq.atmos.Atmos;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class AtmosItems {
    public static void register() {}

    public static Item register(String name, Item item) {
        Item registered = Registry.register(Registries.ITEM, Atmos.id(name), item);
        AtmosItemGroups.items.add(registered.getDefaultStack());
        return registered;
    }
}
