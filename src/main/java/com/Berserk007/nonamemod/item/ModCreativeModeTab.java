package com.Berserk007.nonamemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab NONAMEMOD_TAB = new CreativeModeTab("nonamemodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.STEEL_INGOT.get());
        }
    };
}
