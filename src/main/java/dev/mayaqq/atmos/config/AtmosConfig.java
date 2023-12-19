package dev.mayaqq.atmos.config;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.autogen.AutoGen;
import dev.isxander.yacl3.config.v2.api.autogen.CustomDescription;
import dev.isxander.yacl3.config.v2.api.autogen.IntField;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.mayaqq.atmos.Atmos;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class AtmosConfig {
    public static final Path configFile = FabricLoader.getInstance().getConfigDir().resolve("Atmos.json");

    @AutoGen(category = "energy")
    @CustomDescription("yacl3.config.atmos:config.time_changer_capacity.desc")
    @IntField(min = 1, max = 1_000_000)
    @SerialEntry
    public int timeChangerCapacity = 50_000;

    public static final ConfigClassHandler<AtmosConfig> HANDLER = ConfigClassHandler.createBuilder(AtmosConfig.class)
            .id(Atmos.id("config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(configFile).appendGsonBuilder(GsonBuilder::setPrettyPrinting)
                    .setJson5(true)
                    .build())
            .build();
}
