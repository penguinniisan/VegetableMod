package com.penpennetworks.minecraft.VegetableMod;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTomato extends BlockCrops {
	private static final AxisAlignedBB[] CARROT_AABB = {
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1875D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.4791D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.6457D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.90625D, 1.0D),
		new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.00D, 1.0D) };

	public BlockTomato() {
	}

	protected Item getSeed() {
		return VegetableModCore.tomato_i;
	}

	protected Item getCrop() {
		return VegetableModCore.tomato_i;
	}

	public AxisAlignedBB getBoundingBox(IBlockState p_getBoundingBox_1_,
			IBlockAccess p_getBoundingBox_2_, BlockPos p_getBoundingBox_3_) {
		return CARROT_AABB[((Integer) p_getBoundingBox_1_.getValue(getAge()))
				.intValue()];
	}


	@Override
	public boolean canBlockStay(World p_canBlockStay_1_,
			BlockPos p_canBlockStay_2_, IBlockState p_canBlockStay_3_) {

		boolean result = super.canBlockStay(p_canBlockStay_1_, p_canBlockStay_2_, p_canBlockStay_3_);

		if( result == true ){
			IBlockState soil = p_canBlockStay_1_.getBlockState(p_canBlockStay_2_.down());
			System.out.println("---------> " + soil.toString());

			result = soil.getBlock() == Blocks.farmland;
		}

		return result;
	}

}
