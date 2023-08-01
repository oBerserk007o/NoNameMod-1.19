package com.Berserk007.nonamemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CHILI_PEPPER = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 2), 1.0F).alwaysEat().build();
}
