package com.penpennetworks.minecraft.VegetableMod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod( modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION )
public class VegetableModCore {

	public static Block tomato;
	public static Item tomato_i;

	// Proxy
	@SidedProxy( clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS )
	public static CommonProxy proxy;

	// Event Handlers
	@SuppressWarnings("deprecation")
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){

		tomato = new BlockTomato().setUnlocalizedName("tomato");
		tomato_i = new ItemSeedFood(3, 0.6F,tomato,Blocks.farmland ).setUnlocalizedName("tomato");
		GameRegistry.registerBlock(tomato, "tomatos");
		GameRegistry.registerItem(tomato_i, "tomato");

		/*
		sampleblock = new Block(Material.ground).setUnlocalizedName("sampleblock").setCreativeTab(CreativeTabs.tabBlock);
		//GameRegistry.registerItem( Item.getItemFromBlock(sampleblock), "sampleblock" );
		GameRegistry.registerBlock(sampleblock, "sampleblock");
		//GameRegistry.registerBlock(sampleblock, "aaaa");
		*/

		if( e.getSide() == Side.CLIENT ){

			ModelLoader.setCustomModelResourceLocation( tomato_i, 0,
					new ModelResourceLocation(Reference.MOD_ID + ":" + "tomato", "inventory"));

			/*
			ModelLoader.setCustomModelResourceLocation( Item.getItemFromBlock(sampleblock), 0,
					new ModelResourceLocation(Reference.MOD_ID + ":" + "sampleblock", "inventory"));
			*/
		}

		// リソースロケーションを設定する *これはあと
		proxy.registerRenders();

	}

}
