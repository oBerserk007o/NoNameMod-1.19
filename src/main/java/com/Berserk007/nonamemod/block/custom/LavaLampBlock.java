package com.Berserk007.nonamemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class LavaLampBlock extends Block {
    public static final BooleanProperty FULL = BooleanProperty.create("full");

    public LavaLampBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FULL, false));
    }

    public static ItemStack createFilledResult(ItemStack emptyStack, Player player, ItemStack filledStack) {
        emptyStack.shrink(1);
        if (emptyStack.isEmpty()) {
            return filledStack;
        } else {
            if (!player.getInventory().add(filledStack)) {
                player.drop(filledStack, false);
            }
            return emptyStack;
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        boolean sound = false;
        boolean sound1 = false;
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            ItemStack itemstack = player.getItemInHand(hand);
            if (itemstack.is(Items.LAVA_BUCKET) && !state.getValue(FULL)) {
                sound = true;
                player.sendSystemMessage(Component.literal("Filled lava lamp!"));
                player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                level.setBlock(pos, state.setValue(FULL, true), 3);
            }
            if (itemstack.is(Items.BUCKET) && state.getValue(FULL)) {
                sound1 = true;
                player.sendSystemMessage(Component.literal("Emptied lava lamp!"));
                ItemStack itemstack1 = createFilledResult(itemstack, player, new ItemStack(Items.LAVA_BUCKET));
                player.setItemInHand(hand, itemstack1);
                level.setBlock(pos, state.setValue(FULL, false), 3);
            }
        }
        if (sound) {player.playSound(SoundEvents.BUCKET_FILL_LAVA, 1f, 1f);}
        if (sound1) {player.playSound(SoundEvents.BUCKET_EMPTY_LAVA, 1f, 1f);}
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FULL);
    }
}
