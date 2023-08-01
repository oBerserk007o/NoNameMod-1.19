package com.Berserk007.nonamemod.item.custom;

import java.util.List;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FireballStaffItem extends Item {
    public FireballStaffItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag isAdvanced) {
        if(Screen.hasShiftDown()){
            components.add(Component.translatable("tooltip.nonamemod.fireball_staff"));
        }
        else {
            components.add(Component.translatable("tooltip.nonamemod.shift"));
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        player.getItemInHand(interactionHand).hurtAndBreak(1, player, (Player) -> Player.broadcastBreakEvent(Player.getUsedItemHand()));
        level.playSound(player, player.getOnPos(), SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        player.getCooldowns().addCooldown(this, 100);
        ItemStack itemStack = player.getItemInHand(interactionHand);
        Vec3 vec3 = player.getViewVector(1.0F);
        int power = 5;
        LargeFireball largefireball = new LargeFireball(level, player,
                vec3.x,
                vec3.y,
                vec3.z,
                power);
        largefireball.setPos(
                player.getX(),
                player.getY() + 1,
                player.getZ());
        largefireball.level.addFreshEntity(largefireball);
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}