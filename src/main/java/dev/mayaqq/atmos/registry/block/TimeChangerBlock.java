package dev.mayaqq.atmos.registry.block;

import com.mojang.serialization.MapCodec;
import dev.mayaqq.atmos.registry.AtmosBlockEntities;
import dev.mayaqq.atmos.registry.block.entity.TimeChangerBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TimeChangerBlock extends BlockWithEntity {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty CORRUPTED = BooleanProperty.of("corrupted");

    public TimeChangerBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(CORRUPTED, false));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TimeChangerBlockEntity(blockPos, blockState);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, CORRUPTED);
    }

    @Override
    public BlockState rotate(BlockState blockState, BlockRotation rotation) {
        return blockState.with(FACING, rotation.rotate(blockState.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockState, BlockMirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.get(FACING)));
    }

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient()) {
            NamedScreenHandlerFactory screenHandlerFactory = blockState.createScreenHandlerFactory(world, blockPos);
            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState blockState, BlockEntityType<T> type) {
        return validateTicker(type, AtmosBlockEntities.TIME_CHANGER, TimeChangerBlockEntity::tick);
    }
}
