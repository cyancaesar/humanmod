package com.cyancaesar.humanmod.client.render.entity;

import com.cyancaesar.humanmod.HumanMod;
import com.cyancaesar.humanmod.client.render.model.HogModel;
import com.cyancaesar.humanmod.common.entities.HogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HogRenderer extends MobRenderer<HogEntity, HogModel<HogEntity>> {
    protected final ResourceLocation TEXTURE = new ResourceLocation(HumanMod.MODID, "textures/entity/hog.png");
    public HogRenderer(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new HogModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(HogEntity p_110775_1_) {
        return TEXTURE;
    }
}
