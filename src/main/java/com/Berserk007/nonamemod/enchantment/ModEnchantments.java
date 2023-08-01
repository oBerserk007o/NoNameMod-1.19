package com.Berserk007.nonamemod.enchantment;

import com.Berserk007.nonamemod.NoNameMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS
            = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, NoNameMod.MOD_ID);

    public static RegistryObject<Enchantment> GRIPPER =
            ENCHANTMENTS.register("gripper", () -> new GripperEnchantment(Enchantment.Rarity.RARE,
                    EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
