package com.cyancaesar.humanmod.client.screens;

import com.cyancaesar.humanmod.HumanMod;
import com.cyancaesar.humanmod.common.containers.HumanContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class HumanScreen extends ContainerScreen<HumanContainer> {
    private final ResourceLocation GUI = new ResourceLocation(HumanMod.MODID, "textures/guis/human_gui.png");

    public HumanScreen(HumanContainer p_i51105_1_, PlayerInventory p_i51105_2_, ITextComponent p_i51105_3_) {
        super(p_i51105_1_, p_i51105_2_, p_i51105_3_);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f,1f,1f,1f);
        this.minecraft.getTextureManager().bind(GUI);
        int i = this.getGuiLeft();
        int  j = this.getGuiTop();
        this.blit(matrixStack, i, j, 0,0, this.getXSize(), this.getYSize());
    }
}
