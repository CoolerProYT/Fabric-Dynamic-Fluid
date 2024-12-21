package com.coolerpromc.productiveslimes;

import com.coolerpromc.productiveslimes.tier.ModTierLists;
import com.coolerpromc.productiveslimes.tier.ModTiers;
import com.coolerpromc.productiveslimes.tier.Tier;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;

public class ProductiveSlimesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        for (Tier tier : Tier.values()){
            ModTiers tiers = ModTierLists.getTierByName(tier);
            String name = tiers.name();

            FluidRenderHandlerRegistry.INSTANCE.register(ModTierLists.getSourceByName(name), ModTierLists.getFlowByName(name),
                    SimpleFluidRenderHandler.coloredWater(tiers.color()));
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                    ModTierLists.getSourceByName(name), ModTierLists.getFlowByName(name));
        }
    }
}
