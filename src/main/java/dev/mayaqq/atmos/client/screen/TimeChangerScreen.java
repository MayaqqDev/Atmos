package dev.mayaqq.atmos.client.screen;

import dev.mayaqq.atmos.Atmos;
import dev.mayaqq.atmos.screen.TimeChangerScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TimeChangerScreen extends HandledScreen<TimeChangerScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(Atmos.MOD_ID, "textures/gui/time_changer.png");
    TimeChangerScreenHandler handler;
    public TimeChangerScreen(TimeChangerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.handler = handler;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }
}
