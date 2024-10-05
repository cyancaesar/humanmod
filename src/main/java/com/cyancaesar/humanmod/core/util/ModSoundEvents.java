package com.cyancaesar.humanmod.core.util;

import com.cyancaesar.humanmod.HumanMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {
    public static final ResourceLocation female_sound_path = new ResourceLocation(HumanMod.MODID, "sound1");
    public static final ResourceLocation male_sound_path = new ResourceLocation(HumanMod.MODID, "sound2");

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HumanMod.MODID);

    public static final RegistryObject<SoundEvent> FEMALE_SOUND = SOUNDS.register("sound1",
            () -> new SoundEvent(female_sound_path));

    public static final RegistryObject<SoundEvent> MALE_SOUND = SOUNDS.register("sound2",
            () -> new SoundEvent(male_sound_path));
}
