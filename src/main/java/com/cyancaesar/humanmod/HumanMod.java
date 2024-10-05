package com.cyancaesar.humanmod;

import com.cyancaesar.humanmod.common.entities.HogEntity;
import com.cyancaesar.humanmod.common.entities.SlaveEntity;
import com.cyancaesar.humanmod.core.init.BlockInit;
import com.cyancaesar.humanmod.core.init.ContainerTypeInit;
import com.cyancaesar.humanmod.core.init.EntityTypeInit;
import com.cyancaesar.humanmod.core.init.ItemInit;
import com.cyancaesar.humanmod.core.init.TileEntityTypeInit;
import com.cyancaesar.humanmod.core.util.ModSoundEvents;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(HumanMod.MODID)
public class HumanMod
{
    public static final String MODID = "humanmod";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final HumanModGroup HUMANMOD_GROUP = new HumanModGroup("humanmodtab");

    public HumanMod() {
        // Register the setup method for modloading
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ModSoundEvents.SOUNDS.register(bus);
        EntityTypeInit.ENTITY_TYPES.register(bus);
        TileEntityTypeInit.TILE_ENTITY.register(bus);
        ContainerTypeInit.CONTAINER.register(bus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntityTypeInit.SLAVE.get(), SlaveEntity.setCustomAttribute().build());
            GlobalEntityTypeAttributes.put(EntityTypeInit.HOG.get(), HogEntity.setCustomAttributes().build());
        });
    }


    public static class HumanModGroup extends ItemGroup
    {
        public HumanModGroup(String tab)
        {
            super(tab);
        }

        @Override
        public ItemStack makeIcon() {
            return ItemInit.HUMAN_BLOCK.get().getDefaultInstance();
        }
    }

}
