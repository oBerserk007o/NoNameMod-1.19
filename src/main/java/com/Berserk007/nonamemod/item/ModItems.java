package com.Berserk007.nonamemod.item;

import com.Berserk007.nonamemod.NoNameMod;
import com.Berserk007.nonamemod.block.ModBlocks;
import com.Berserk007.nonamemod.item.custom.FireballStaffItem;
import com.Berserk007.nonamemod.item.custom.FleeStickItem;
import com.Berserk007.nonamemod.item.custom.LightningStaffItem;
import com.Berserk007.nonamemod.item.custom.UpgradedCoalItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NoNameMod.MOD_ID);

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
           () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB)));

    public static final RegistryObject<Item> STEEL_BEED = ITEMS.register("steel_beed",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB)));

    public static final RegistryObject<Item> PYRO_CONDENSATE= ITEMS.register("pyro_condensate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB)));

    public static final RegistryObject<Item> RAW_PYRO_CONDENSATE = ITEMS.register("raw_pyro_condensate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB)));

    public static final RegistryObject<Item> ELECTRO_CONDENSATE = ITEMS.register("electro_condensate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB)));

    public static final RegistryObject<Item> RAW_ELECTRO_CONDENSATE = ITEMS.register("raw_electro_condensate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB)));

    public static final RegistryObject<Item> CHILI_PEPPER = ITEMS.register("chili_pepper",
            () -> new ItemNameBlockItem(ModBlocks.CHILI_PEPPER_BUSH.get(), new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).food(ModFoods.CHILI_PEPPER)));


    public static final RegistryObject<Item> UPGRADED_COAL = ITEMS.register("upgraded_coal",
            () -> new UpgradedCoalItem(new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB)));

    public static final RegistryObject<Item> FIREBALL_STAFF = ITEMS.register("fireball_staff",
            () -> new FireballStaffItem(new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).durability(100)));

    public static final RegistryObject<Item> LIGHTNING_STAFF = ITEMS.register("lightning_staff",
            () -> new LightningStaffItem(new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).durability(100)));

    public static final RegistryObject<Item> FLEE_STICK = ITEMS.register("flee_stick",
            () -> new FleeStickItem(ModTiers.GENERIC, 1, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB)));


    public static final RegistryObject<Item> PYRO_CONDENSATE_SWORD = ITEMS.register("pyro_condensate_sword",
            () -> new SwordItem(ModTiers.PYRO, 3, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).fireResistant()));
    public static final RegistryObject<Item> PYRO_CONDENSATE_AXE = ITEMS.register("pyro_condensate_axe",
            () -> new AxeItem(ModTiers.PYRO, 5, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).fireResistant()));
    public static final RegistryObject<Item> PYRO_CONDENSATE_PICKAXE = ITEMS.register("pyro_condensate_pickaxe",
            () -> new PickaxeItem(ModTiers.PYRO, 1, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).fireResistant()));
    public static final RegistryObject<Item> PYRO_CONDENSATE_HOE = ITEMS.register("pyro_condensate_hoe",
            () -> new HoeItem(ModTiers.PYRO, -4, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).fireResistant()));
    public static final RegistryObject<Item> PYRO_CONDENSATE_SHOVEL = ITEMS.register("pyro_condensate_shovel",
            () -> new ShovelItem(ModTiers.PYRO, 3, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).fireResistant()));

    public static final RegistryObject<Item> ELECTRO_CONDENSATE_SWORD = ITEMS.register("electro_condensate_sword",
            () -> new SwordItem(ModTiers.ELECTRO, 3, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).fireResistant()));
    public static final RegistryObject<Item> ELECTRO_CONDENSATE_AXE = ITEMS.register("electro_condensate_axe",
            () -> new AxeItem(ModTiers.ELECTRO, 5, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).fireResistant()));
    public static final RegistryObject<Item> ELECTRO_CONDENSATE_PICKAXE = ITEMS.register("electro_condensate_pickaxe",
            () -> new PickaxeItem(ModTiers.ELECTRO, 1, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).fireResistant()));
    public static final RegistryObject<Item> ELECTRO_CONDENSATE_HOE = ITEMS.register("electro_condensate_hoe",
            () -> new HoeItem(ModTiers.ELECTRO, -4, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).fireResistant()));
    public static final RegistryObject<Item> ELECTRO_CONDENSATE_SHOVEL = ITEMS.register("electro_condensate_shovel",
            () -> new ShovelItem(ModTiers.ELECTRO, 3, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.NONAMEMOD_TAB).fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
