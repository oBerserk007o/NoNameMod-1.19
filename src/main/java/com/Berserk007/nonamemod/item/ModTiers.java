package com.Berserk007.nonamemod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier GENERIC = new ForgeTier(1, 100, 4.5f,
            1f, 10, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(ModItems.PYRO_CONDENSATE.get()));
    public static final ForgeTier PYRO = new ForgeTier(4, 2031, 9f,
            4f, 20, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.PYRO_CONDENSATE.get()));
    public static final ForgeTier ELECTRO = new ForgeTier(4, 2031, 9f,
            4f, 20, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.ELECTRO_CONDENSATE.get()));
}
