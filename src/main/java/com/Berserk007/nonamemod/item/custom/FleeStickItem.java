package com.Berserk007.nonamemod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FleeStickItem extends SwordItem {
    public FleeStickItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag isAdvanced) {
        if(Screen.hasShiftDown()){
            components.add(Component.translatable("tooltip.nonamemod.flee_stick"));
        }
        else {
            components.add(Component.translatable("tooltip.nonamemod.shift"));
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200), attacker);
        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200), attacker);
        target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200), attacker);
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200), attacker);
        attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), attacker);
        attacker.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60), attacker);
        return super.hurtEnemy(stack, target, attacker);
    }
}
