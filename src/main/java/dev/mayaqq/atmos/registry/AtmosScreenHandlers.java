package dev.mayaqq.atmos.registry;

import dev.mayaqq.atmos.Atmos;
import dev.mayaqq.atmos.screen.TimeChangerScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class AtmosScreenHandlers {
    public static final ScreenHandlerType<TimeChangerScreenHandler> TIME_CHANGER = register("time_changer",
            new ScreenHandlerType<>(TimeChangerScreenHandler::new, FeatureFlags.VANILLA_FEATURES));
    public static void register() {}

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String name, ScreenHandlerType<T> handler) {
        return Registry.register(Registries.SCREEN_HANDLER, Atmos.id(name), handler);
    }
}
