package com.cyancaesar.humanmod.core.init;

import com.cyancaesar.humanmod.HumanMod;
import com.cyancaesar.humanmod.common.tiles.HumanTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeInit {
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, HumanMod.MODID);

    public static RegistryObject<TileEntityType<HumanTile>> HUMAN_BLOCK_TILE = TILE_ENTITY.register("human_tile", () -> TileEntityType.Builder.of(
            HumanTile::new, BlockInit.HUMAN_BLOCK.get()).build(null)
    );

}
