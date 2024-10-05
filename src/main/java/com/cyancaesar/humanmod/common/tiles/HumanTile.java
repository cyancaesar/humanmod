package com.cyancaesar.humanmod.common.tiles;

import com.cyancaesar.humanmod.core.init.TileEntityTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class HumanTile extends TileEntity {
    private final ItemStackHandler itemStackHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemStackHandler);

    public HumanTile(TileEntityType<?> p_i48289_1_)
    {
        super(p_i48289_1_);
    }

    public HumanTile()
    {
        this(TileEntityTypeInit.HUMAN_BLOCK_TILE.get());
    }

    private ItemStackHandler createHandler()
    {
        return new ItemStackHandler(2)
        {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot)
                {
                    case 0: return stack.getItem() == Items.IRON_SWORD;
                    case 1: return stack.getItem() == Items.SHIELD;
                    default:
                        return false;
                }
            }

            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack))
                {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Override
    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        itemStackHandler.deserializeNBT(p_230337_2_.getCompound("inv"));
        super.load(p_230337_1_, p_230337_2_);
    }

    @Override
    public CompoundNBT save(CompoundNBT p_189515_1_) {
        p_189515_1_.put("inv", itemStackHandler.serializeNBT());
        return super.save(p_189515_1_);
    }
}
