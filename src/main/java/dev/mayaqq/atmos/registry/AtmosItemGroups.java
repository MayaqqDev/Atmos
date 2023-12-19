package dev.mayaqq.atmos.registry;

import dev.mayaqq.atmos.Atmos;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.ArrayList;

public class AtmosItemGroups {

    public static ArrayList<ItemStack> items = new ArrayList<>();

    public static final ItemGroup ATMOS_GROUP = Registry.register(Registries.ITEM_GROUP, Atmos.id("atmos_group"), FabricItemGroup.builder()
            .icon(() -> Items.CLOCK.getDefaultStack())
            .displayName(Text.translatable("itemGroup.atmos.atmos_group"))
            .entries((context, entries) -> {
                items.forEach(entries::add);
            }).build());

    public static void register() {}
}
