package com.cyancaesar.humanmod.common.entities;

import com.cyancaesar.humanmod.client.utils.FollowGoal;
import com.cyancaesar.humanmod.core.init.EntityTypeInit;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SlaveEntity extends VillagerEntity {
    private static final Ingredient TEMPTATION_GOAL = Ingredient.of(Items.GOLD_NUGGET);

    public SlaveEntity(EntityType<? extends VillagerEntity> p_i50182_1_, World p_i50182_2_) {
        super(p_i50182_1_, p_i50182_2_);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttribute() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D);
    }

    @Override
    protected void rewardTradeXp(MerchantOffer p_213713_1_) {
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FollowGoal(this, 0.9d, TEMPTATION_GOAL, false));
    }

    @Override
    public SlaveEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        SlaveEntity slaveEntity = new SlaveEntity(EntityTypeInit.SLAVE.get(), p_241840_1_);
        slaveEntity.finalizeSpawn(p_241840_1_, p_241840_1_.getCurrentDifficultyAt(slaveEntity.blockPosition()), SpawnReason.BREEDING, null, null);
        return slaveEntity;
    }

    @Override
    protected void updateTrades() {

    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.PIG_STEP;
    }
}
