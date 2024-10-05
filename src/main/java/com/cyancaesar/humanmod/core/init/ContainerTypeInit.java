package com.cyancaesar.humanmod.core.init;


import com.cyancaesar.humanmod.HumanMod;
import com.cyancaesar.humanmod.common.containers.HumanContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypeInit {
    public static final DeferredRegister<ContainerType<?>> CONTAINER =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, HumanMod.MODID);

    public static final RegistryObject<ContainerType<HumanContainer>> HUMAN_CONTAINER =
            CONTAINER.register("human_container", () ->
                IForgeContainerType.create(((windowId, inv, data) -> {
                    BlockPos pos = data.readBlockPos();
                    World world = inv.player.level;
                    return new HumanContainer(windowId, world, pos, inv, inv.player);
                        }))
            );
}
