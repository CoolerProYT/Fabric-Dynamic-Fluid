package com.coolerpromc.productiveslimes.fluid;

import com.coolerpromc.productiveslimes.ProductiveSlimes;
import com.coolerpromc.productiveslimes.tier.ModTierLists;
import com.coolerpromc.productiveslimes.tier.Tier;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static void register() {
        for (Tier tier : Tier.values()){
            FlowableFluid STILL_DYNAMIC_FLUID = Registry.register(Registries.FLUID,
                    Identifier.of(ProductiveSlimes.MOD_ID, "still_" + ModTierLists.getTierByName(tier).name()), new DynamicFluid.Still(ModTierLists.getTierByName(tier).name()));
            FlowableFluid FLOWING_DYNAMIC_FLUID = Registry.register(Registries.FLUID,
                    Identifier.of(ProductiveSlimes.MOD_ID, "flowing_"  + ModTierLists.getTierByName(tier).name()), new DynamicFluid.Flowing(ModTierLists.getTierByName(tier).name()));

            ModTierLists.addRegisteredSource(ModTierLists.getTierByName(tier).name(), STILL_DYNAMIC_FLUID);
            ModTierLists.addRegisteredFlow(ModTierLists.getTierByName(tier).name(), FLOWING_DYNAMIC_FLUID);

            FluidBlock DYNAMIC_FLUID_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(ProductiveSlimes.MOD_ID, ModTierLists.getTierByName(tier).name() + "_block"),
                    new FluidBlock(ModTierLists.getSourceByName(ModTierLists.getTierByName(tier).name()), FabricBlockSettings.copyOf(Blocks.WATER)) {
                    });
            Item DYNAMIC_FLUID_BUCKET = Registry.register(Registries.ITEM, Identifier.of(ProductiveSlimes.MOD_ID, ModTierLists.getTierByName(tier).name() + "_bucket"),
                    new BucketItem(ModTierLists.getSourceByName(ModTierLists.getTierByName(tier).name()), new Item.Settings().maxCount(64)));

            ModTierLists.addRegisteredLiquidBlock(ModTierLists.getTierByName(tier).name(), DYNAMIC_FLUID_BLOCK);
            ModTierLists.addRegisteredBucketItem(ModTierLists.getTierByName(tier).name(), DYNAMIC_FLUID_BUCKET);
        }
    }
}
