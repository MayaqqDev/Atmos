package dev.mayaqq.atmos;

import dev.mayaqq.atmos.config.AtmosConfig;
import dev.mayaqq.atmos.registry.AtmosBlockEntities;
import dev.mayaqq.atmos.registry.AtmosBlocks;
import dev.mayaqq.atmos.registry.AtmosItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Atmos implements ModInitializer {

    public static final String MOD_ID = "atmos";
    public static final Logger LOGGER = LoggerFactory.getLogger("Atmos");

    @Override
    public void onInitialize() {
        // Keep this on top
        AtmosConfig.HANDLER.load();

        AtmosItems.register();
        AtmosBlocks.register();
        AtmosBlockEntities.register();
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
