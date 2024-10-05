package com.cyancaesar.humanmod.core.util;

import com.cyancaesar.humanmod.HumanMod;
import com.cyancaesar.humanmod.client.render.entity.HogRenderer;
import com.cyancaesar.humanmod.client.screens.HumanScreen;
import com.cyancaesar.humanmod.core.init.ContainerTypeInit;
import com.cyancaesar.humanmod.core.init.EntityTypeInit;
import com.cyancaesar.humanmod.client.render.entity.SlaveRenderer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HumanMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeInit.SLAVE.get(), SlaveRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeInit.HOG.get(), HogRenderer::new);

        event.enqueueWork(() -> {
            ScreenManager.register(ContainerTypeInit.HUMAN_CONTAINER.get(), HumanScreen::new);
        });
    }
}
