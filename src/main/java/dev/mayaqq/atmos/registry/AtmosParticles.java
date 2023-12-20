package dev.mayaqq.atmos.registry;

import dev.mayaqq.atmos.Atmos;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class AtmosParticles {

    public static final DefaultParticleType LIGHTNING_OVERCHARGE = registerSimple("lightning_overcharge");

    public static void register() {}

    private static DefaultParticleType registerSimple(String name) {
        return Registry.register(Registries.PARTICLE_TYPE, Atmos.id(name), FabricParticleTypes.simple());
    }
}
