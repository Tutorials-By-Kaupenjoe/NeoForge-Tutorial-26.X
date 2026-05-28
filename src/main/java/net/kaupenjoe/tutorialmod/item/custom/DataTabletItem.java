package net.kaupenjoe.tutorialmod.item.custom;

import net.kaupenjoe.tutorialmod.data.ModDataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class DataTabletItem extends Item {
    public DataTabletItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if(player.getItemInHand(hand).has(ModDataComponents.COORDINATES)) {
            player.getItemInHand(hand).remove(ModDataComponents.COORDINATES);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return itemStack.has(ModDataComponents.COORDINATES);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display,
                                Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if(itemStack.has(ModDataComponents.COORDINATES)) {
            BlockPos position = itemStack.get(ModDataComponents.COORDINATES);
            String foundPositionString = "(" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")";
            builder.accept(Component.literal(foundPositionString));
        }
    }
}
