package com.project.pufferfish.block;

import com.project.pufferfish.Invaders;
import com.project.pufferfish.block.custom.ArcadeMachineBlock;
import com.project.pufferfish.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Invaders.MOD_ID);

    public static final RegistryObject<Block> ARCADE_MACHINE = registerBlock("arcade_machine",
            () -> new ArcadeMachineBlock(AbstractBlock.Properties.of(Material.DECORATION)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ItemGroup.TAB_MISC)));
    }

    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
