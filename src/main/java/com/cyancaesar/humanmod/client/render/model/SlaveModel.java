package com.cyancaesar.humanmod.client.render.model;

import com.cyancaesar.humanmod.common.entities.SlaveEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SlaveModel<T extends SlaveEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer jacket;
    private final ModelRenderer left_arm;
    private final ModelRenderer left_sleve;
    private final ModelRenderer right_arm;
    private final ModelRenderer right_sleve;
    private final ModelRenderer left_leg;
    private final ModelRenderer left_pants;
    private final ModelRenderer right_leg;
    private final ModelRenderer right_pants;

    public SlaveModel() {
        texWidth = 64;
        texHeight = 64;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setPos(0.0F, 0.0F, 0.0F);
        body.texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

        jacket = new ModelRenderer(this);
        jacket.setPos(0.0F, 0.0F, 0.0F);
        jacket.texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);

        left_arm = new ModelRenderer(this);
        left_arm.setPos(5.0F, 2.0F, 0.0F);
        left_arm.texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        left_sleve = new ModelRenderer(this);
        left_sleve.setPos(5.0F, 2.0F, 0.0F);
        left_sleve.texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        right_arm = new ModelRenderer(this);
        right_arm.setPos(-5.0F, 2.0F, 0.0F);
        right_arm.texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        right_sleve = new ModelRenderer(this);
        right_sleve.setPos(-5.0F, 2.0F, 0.0F);
        right_sleve.texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        left_leg = new ModelRenderer(this);
        left_leg.setPos(2.0F, 12.0F, 0.0F);
        left_leg.texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        left_pants = new ModelRenderer(this);
        left_pants.setPos(2.0F, 12.0F, 0.0F);
        left_pants.texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        right_leg = new ModelRenderer(this);
        right_leg.setPos(-2.0F, 12.0F, 0.0F);
        right_leg.texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        right_pants = new ModelRenderer(this);
        right_pants.setPos(-2.0F, 12.0F, 0.0F);
        right_pants.texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
    }

    @Override
    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.head.yRot = p_225597_5_ * ((float)Math.PI / 180F);

        this.right_arm.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 2.0F * p_225597_3_ * 0.5F;
        this.left_arm.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 2.0F * p_225597_3_ * 0.5F;
        this.right_arm.zRot = 0.0F;
        this.left_arm.zRot = 0.0F;
        this.right_leg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.left_leg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.right_leg.yRot = 0.0F;
        this.left_leg.yRot = 0.0F;
        this.right_leg.zRot = 0.0F;
        this.left_leg.zRot = 0.0F;

        this.jacket.copyFrom(body);
        this.right_sleve.copyFrom(right_arm);
        this.left_sleve.copyFrom(left_arm);
        this.right_pants.copyFrom(right_leg);
        this.left_pants.copyFrom(left_leg);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        jacket.render(matrixStack, buffer, packedLight, packedOverlay);
        left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        left_sleve.render(matrixStack, buffer, packedLight, packedOverlay);
        right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        right_sleve.render(matrixStack, buffer, packedLight, packedOverlay);
        left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        left_pants.render(matrixStack, buffer, packedLight, packedOverlay);
        right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        right_pants.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
