package dev.mayaqq.atmos.datagen;

import dev.mayaqq.atmos.registry.AtmosBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class AtmosTranslations {
    public static class EnUs extends FabricLanguageProvider {
        protected EnUs(FabricDataOutput dataOutput) {
            super(dataOutput, "en_us");
        }

        @Override
        public void generateTranslations(TranslationBuilder tb) {
            // Blocks
            tb.add(AtmosBlocks.TIME_CHANGER, "Time Changer");
            // Item groups
            tb.add("itemGroup.atmos.atmos_group", "Atmos");
            // Config
            tb.add("yacl3.config.atmos:config.category.energy", "Energy");
                tb.add("yacl3.config.atmos:config.timeChangerCapacity", "Time Changer Capacity");
                    tb.add("yacl3.config.atmos:config.time_changer_capacity.desc", "The maximum amount of energy the Time Changer can store.");

        }
    }
}
