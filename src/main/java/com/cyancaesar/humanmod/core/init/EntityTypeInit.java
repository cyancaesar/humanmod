package com.cyancaesar.humanmod.core.init;

import com.cyancaesar.humanmod.HumanMod;
import com.cyancaesar.humanmod.common.entities.SlaveEntity;
import com.cyancaesar.humanmod.common.entities.HogEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, HumanMod.MODID);

    // ENTITY TYPES
    public static final RegistryObject<EntityType<SlaveEntity>> SLAVE = ENTITY_TYPES.register("slave" ,
            () -> EntityType.Builder
                    .of(SlaveEntity::new, EntityClassification.CREATURE)
                    .sized(1.0f, 1.0f)
                    .build(new ResourceLocation(HumanMod.MODID, "slave").toString())
    );

    public static final RegistryObject<EntityType<HogEntity>> HOG = ENTITY_TYPES.register("hog",
            () -> EntityType.Builder
                    .of(HogEntity::new, EntityClassification.CREATURE)
                    .sized(1.0f, 1.0f)
                    .build(new ResourceLocation(HumanMod.MODID, "hog").toString()));
}
