package com.Berserk007.nonamemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class ItemGeneratorBlock extends Block {
    public ItemGeneratorBlock(Properties properties) {
        super(properties);
    }

    Random random = new Random();

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int randomID = this.random.nextInt(1324) + 1;
        ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY() + 0.5f, pos.getZ(), new ItemStack(Item.byId(randomID)));
        player.sendSystemMessage(Component.literal("Block was used! Item: " + Item.byId(randomID) + ", ID:" + randomID));
        itemEntity.setDefaultPickUpDelay();
        level.addFreshEntity(itemEntity);
        return super.use(state, level, pos, player, hand, hit);
    }

}
