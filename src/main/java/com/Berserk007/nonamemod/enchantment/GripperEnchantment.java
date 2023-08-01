package com.Berserk007.nonamemod.enchantment;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.KnockbackEnchantment;
import net.minecraft.world.phys.Vec3;

public class GripperEnchantment extends Enchantment {
    protected GripperEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, EnchantmentCategory.WEAPON, pApplicableSlots);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
        Vec3 vec3 = (new Vec3(attacker.getX() - target.getX(), (attacker.getY() - target.getY()) / 5, attacker.getZ() - target.getZ())).scale(0.15D);
        target.setDeltaMovement(target.getDeltaMovement().add(vec3));
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof AxeItem || super.canEnchant(pStack);
    }

    @Override
    public boolean checkCompatibility(Enchantment pEnch) {
        return !(pEnch instanceof KnockbackEnchantment);
    }
}