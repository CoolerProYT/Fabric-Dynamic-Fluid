package com.coolerpromc.productiveslimes;

import com.coolerpromc.productiveslimes.tier.ModTierLists;
import com.coolerpromc.productiveslimes.tier.Tier;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTabs {
    public static ItemGroup PRODUCTIVE_SLIMES_TAB = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(ProductiveSlimes.MOD_ID, "productiveslimes"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.SLIME_BLOCK))
                    .displayName(Text.translatable("creativetab.productiveslimes"))
                    .entries((pParameters, pOutput) -> {
                        for(Tier tier : Tier.values()) {
                            pOutput.add(ModTierLists.getBucketItemByName(ModTierLists.getTierByName(tier).name()).asItem());
                        }
                    }).build());

    public static void registerCreativeTab() {
    }
}
