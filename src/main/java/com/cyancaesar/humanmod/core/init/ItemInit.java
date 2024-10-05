package com.cyancaesar.humanmod.core.init;

import com.cyancaesar.humanmod.HumanMod;
import com.cyancaesar.humanmod.core.init.tool.ModItemTier;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HumanMod.MODID);

    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties().tab(HumanMod.HUMANMOD_GROUP)));

    public static final RegistryObject<Item> DEMON_SWORD = ITEMS.register("demon_sword",
            () -> new Item(new Item.Properties().tab(HumanMod.HUMANMOD_GROUP)));

    public static final RegistryObject<Item> ROUGH_PICKAXE = ITEMS.register("rough_pickaxe",
            () -> new PickaxeItem(ModItemTier.ROUGH, 2, 3f, new Item.Properties().tab(HumanMod.HUMANMOD_GROUP)));

    public static final RegistryObject<Item> CALCITE_PICKAXE = ITEMS.register("calcite_pickaxe",
            () -> new PickaxeItem(ModItemTier.CALCITE, 2, 3f, new Item.Properties().tab(HumanMod.HUMANMOD_GROUP)));


    // Block item
    public static final RegistryObject<BlockItem> HUMAN_BLOCK = ITEMS.register("human_block",
            () -> new BlockItem(BlockInit.HUMAN_BLOCK.get(), new Item.Properties().tab(HumanMod.HUMANMOD_GROUP)));
}
