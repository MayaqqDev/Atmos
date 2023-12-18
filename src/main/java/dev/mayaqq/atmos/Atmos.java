package dev.mayaqq.atmos;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Atmos implements ModInitializer {

    public static final String MOD_ID = "atmos";
    public static final Logger LOGGER = LoggerFactory.getLogger("Atmos");

    @Override
    public void onInitialize() {

    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
