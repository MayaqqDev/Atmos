package dev.mayaqq.atmos.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.mayaqq.atmos.config.AtmosConfig;

public class ModMenuIntegration implements ModMenuApi {
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return screen -> AtmosConfig.HANDLER.generateGui().generateScreen(screen);
    }
}
