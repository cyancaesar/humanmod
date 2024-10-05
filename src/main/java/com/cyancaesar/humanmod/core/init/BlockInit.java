package com.cyancaesar.humanmod.core.init;

import com.cyancaesar.humanmod.HumanMod;
import com.cyancaesar.humanmod.common.blocks.HumanBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HumanMod.MODID);
//    public static final RegistryObject<Block> HUMAN_BLOCK = BLOCKS.register("human_block", () ->
//            new Block (AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_PINK)
//                    .strength(1.5f, 20f)
//                    .harvestTool(ToolType.PICKAXE)
//                    .harvestLevel(2)
//                    .sound(SoundType.SLIME_BLOCK)
//                    .requiresCorrectToolForDrops()
//            ));

    public static final RegistryObject<Block> HUMAN_BLOCK = BLOCKS.register("human_block", () ->
            new HumanBlock(AbstractBlock.Properties.of(Material.SAND))
            );
}
