package dev.mayaqq.atmos.registry.block;

import com.mojang.serialization.MapCodec;
import dev.mayaqq.atmos.Atmos;
import dev.mayaqq.atmos.registry.AtmosBlockEntities;
import dev.mayaqq.atmos.registry.AtmosParticles;
import dev.mayaqq.atmos.registry.block.entity.LightningChargerBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LightningChargerBlock extends BlockWithEntity {
    public static final MapCodec<LightningChargerBlock> CODEC = createCodec(LightningChargerBlock::new);
    public LightningChargerBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient) {
            if (world.getBlockState(pos.add(0, 1, 0)).getBlock() instanceof LightningRodBlock) {
                if (world.getBlockState(pos.add(0, 1, 0)).get(LightningRodBlock.POWERED)) {
                    world.playSound(null, pos, SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.BLOCKS, 1, 1);
                    world.addParticle(AtmosParticles.LIGHTNING_OVERCHARGE, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0, 0, 0);
                }
            }

        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LightningChargerBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState blockState, BlockEntityType<T> type) {
        return validateTicker(type, AtmosBlockEntities.LIGHTNING_CHARGER, LightningChargerBlockEntity::tick);
    }
}
