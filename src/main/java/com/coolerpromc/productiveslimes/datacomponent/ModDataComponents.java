package com.coolerpromc.productiveslimes.datacomponent;

import com.coolerpromc.productiveslimes.ProductiveSlimes;
import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModDataComponents {
    public static ComponentType<Integer> COLOR;

    public static void register() {
        COLOR = Registry.register(
                Registries.DATA_COMPONENT_TYPE,
                Identifier.of(ProductiveSlimes.MOD_ID, "color"),
                ComponentType.<Integer>builder().codec(Codec.INT).build());
    }
}
