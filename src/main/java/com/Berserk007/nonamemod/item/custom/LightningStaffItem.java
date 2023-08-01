package com.Berserk007.nonamemod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LightningStaffItem extends Item {
    public LightningStaffItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag isAdvanced) {
        if(Screen.hasShiftDown()){
            components.add(Component.translatable("tooltip.nonamemod.lightning_staff"));
        }
        else {
            components.add(Component.translatable("tooltip.nonamemod.shift"));
        }
    }

    public static @NotNull BlockHitResult getPlayerPOVHitResult(Level pLevel, Player pPlayer, ClipContext.Fluid pFluidMode) {
        float f = pPlayer.getXRot();
        float f1 = pPlayer.getYRot();
        Vec3 vec3 = pPlayer.getEyePosition();
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = 150;
        Vec3 vec31 = vec3.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return pLevel.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, pFluidMode, pPlayer));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        player.getCooldowns().addCooldown(this, 100);
        player.getItemInHand(interactionHand).hurtAndBreak(1, player, (Player) -> Player.broadcastBreakEvent(Player.getUsedItemHand()));
        HitResult hitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
        LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(level);
        assert lightningbolt != null;
        lightningbolt.moveTo(hitresult.getLocation());
        lightningbolt.setDamage(10.0f);
        lightningbolt.setCause(player instanceof ServerPlayer ? (ServerPlayer)player : null);
        level.addFreshEntity(lightningbolt);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.TRIDENT_THUNDER,
                SoundSource.NEUTRAL, 5.0f, 1.0F);
        ItemStack itemStack = player.getItemInHand(interactionHand);
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}
