package dev.mayaqq.atmos.config;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.mayaqq.atmos.Atmos;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class AtmosConfig {
    public static final Path configFile = FabricLoader.getInstance().getConfigDir().resolve("Atmos.json");

    /*
        * Add your config fields here
        * Example:
        * @AutoGen(category = "general", group = "general")
        * @CustomDescription("yacl3.config.atmos:config.example.desc")
        * @TickBox
        * @SerialEntry
        * public boolean example = true;
     */

    public static final ConfigClassHandler<AtmosConfig> HANDLER = ConfigClassHandler.createBuilder(AtmosConfig.class)
            .id(Atmos.id("config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(configFile).appendGsonBuilder(GsonBuilder::setPrettyPrinting)
                    .setJson5(true)
                    .build())
            .build();
}
