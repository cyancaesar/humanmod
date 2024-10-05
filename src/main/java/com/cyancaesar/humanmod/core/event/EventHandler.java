package com.cyancaesar.humanmod.core.event;

import com.cyancaesar.humanmod.HumanMod;
import com.cyancaesar.humanmod.core.util.ModSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HumanMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event)
    {
        Entity player = event.getEntity();
        IWorld world = event.getWorld();
        String blockName = event.getPlacedBlock().getBlock().getName().getString();
//        Minecraft.getInstance().player.chat(blockName);
    }

    @SubscribeEvent
    public static void onHandRender(RenderHandEvent event)
    {
        String itemName = Minecraft.getInstance().player.getMainHandItem().getDisplayName().getString();
        if (itemName.equals("[Stone]"))
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event)
    {
        Entity entity = event.getEntity();
        Entity player = event.getSource().getEntity();
        Vector3d entityVec = new Vector3d(entity.getX(), entity.getY(), entity.getZ());
        Vector3d playerVec = new Vector3d(player.getX(), player.getY(), player.getZ());
        double distance = entityVec.distanceTo(playerVec);
        IWorld world = entity.getCommandSenderWorld();
        if (entity instanceof VillagerEntity)
        {
            Minecraft.getInstance().player.chat(String.valueOf(distance));
            BlockPos pos = new BlockPos(entity.getX(), entity.getY(), entity.getZ());
            if (distance > 11)
                world.playSound(null, pos, ModSoundEvents.MALE_SOUND.get(), SoundCategory.AMBIENT, 0.1f,1f);
            else if (distance > 6)
                world.playSound(null, pos, ModSoundEvents.MALE_SOUND.get(), SoundCategory.AMBIENT, 0.3f,1f);
            else
                world.playSound(null, pos, ModSoundEvents.MALE_SOUND.get(), SoundCategory.AMBIENT, 0.6f,1f);
        }
    }

}
