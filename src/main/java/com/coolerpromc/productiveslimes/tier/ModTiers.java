package com.coolerpromc.productiveslimes.tier;

import net.minecraft.util.math.ColorHelper;
import net.minecraft.block.MapColor;

/**
 * @param name                     Name of the tier
 * @param color                    Color of the tier (For items,block and entity)
 * @param mapColorId               Color on the map (ID reference to {@link MapColor})
 * @param cooldown                 Cooldown for slime to drop slimeball (in ticks)
 * @param growthItemKey            Resource key of the item that can be used to grow the slime
 * @param solidingOutputKey        Resource key of the output item for soliding recipe
 * @param solidingOutputAmount     Amount of output item for soliding recipe
 * @param synthesizingInputItemKey Resource key of the input item for synthesizing recipe
 * @param synthesizingInputDnaKey1 Resource key of the first input dna for synthesizing recipe
 * @param synthesizingInputDnaKey2 Resource key of the second input dna for synthesizing recipe
 * @param dnaOutputChance          Chance of output dna for synthesizing recipe
 */
public record ModTiers(String name, int color, int mapColorId, int cooldown, String growthItemKey, String solidingOutputKey, int solidingOutputAmount, String synthesizingInputItemKey, String synthesizingInputDnaKey1, String synthesizingInputDnaKey2, float dnaOutputChance) {
    public ModTiers {
    }

    public int getOpaqueColor() {
        return ColorHelper.Abgr.toOpaque(color);
    }
}
