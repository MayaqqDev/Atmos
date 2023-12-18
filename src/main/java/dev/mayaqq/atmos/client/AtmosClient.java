package dev.mayaqq.atmos.client;

import dev.mayaqq.atmos.client.screen.TimeChangerScreen;
import dev.mayaqq.atmos.registry.AtmosScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class AtmosClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(AtmosScreenHandlers.TIME_CHANGER, TimeChangerScreen::new);
    }
}
