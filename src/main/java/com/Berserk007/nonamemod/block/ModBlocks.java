package com.Berserk007.nonamemod.block;

import com.Berserk007.nonamemod.NoNameMod;
import com.Berserk007.nonamemod.block.custom.ChiliPepperBushBlock;
import com.Berserk007.nonamemod.block.custom.ItemGeneratorBlock;
import com.Berserk007.nonamemod.block.custom.LavaLampBlock;
import com.Berserk007.nonamemod.item.ModCreativeModeTab;
import com.Berserk007.nonamemod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NoNameMod.MOD_ID);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.NONAMEMOD_TAB);

    public static final RegistryObject<Block> PYRO_CONDENSATE_ORE = registerBlock("pyro_condensate_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.NONAMEMOD_TAB);

    public static final RegistryObject<Block> ELECTRO_CONDENSATE_ORE = registerBlock("electro_condensate_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.NONAMEMOD_TAB);


    public static final RegistryObject<Block> CHILI_PEPPER_BUSH = BLOCKS.register("chili_pepper_bush",
            () -> new ChiliPepperBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).randomTicks()
                    .noCollission().noOcclusion().sound(SoundType.SWEET_BERRY_BUSH)));


    public static final RegistryObject<Block> ITEM_GENERATOR_BLOCK = registerBlock("item_generator_block",
            () -> new ItemGeneratorBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.NONAMEMOD_TAB, "tooltip.nonamemod.item_generator_block");

    public static final RegistryObject<Block> LAVA_LAMP_BLOCK = registerBlock("lava_lamp",
            () -> new LavaLampBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()
                    .lightLevel((state) -> state.getValue(LavaLampBlock.FULL) ? 15 : 0)),
            ModCreativeModeTab.NONAMEMOD_TAB, "tooltip.nonamemod.lava_lamp");

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                 new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
                tooltip.add(Component.translatable(tooltipKey));
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
