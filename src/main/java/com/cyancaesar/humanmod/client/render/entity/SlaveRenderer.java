package com.cyancaesar.humanmod.client.render.entity;

import com.cyancaesar.humanmod.HumanMod;
import com.cyancaesar.humanmod.client.render.model.SlaveModel;
import com.cyancaesar.humanmod.common.entities.SlaveEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SlaveRenderer extends MobRenderer<SlaveEntity, SlaveModel<SlaveEntity>> {

    protected final ResourceLocation TEXTURE = new ResourceLocation(HumanMod.MODID, "textures/entity/slavegirl.png");

    public SlaveRenderer(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new SlaveModel<>(), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(SlaveEntity p_110775_1_) {
        return TEXTURE;
    }
}
