package tk.vaporwaves.clockmod.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class Render {
	private static FontRenderer fr = Minecraft.getInstance().fontRenderer;
	private static int winWidth = Minecraft.getInstance().getMainWindow().getWidth();
	@SubscribeEvent
	public static void RenderEvent(TickEvent.RenderTickEvent e) {
		if (Minecraft.getInstance().currentScreen == null) {
			winWidth = Minecraft.getInstance().getMainWindow().getWidth();
			fr.drawString("time",winWidth - fr.getStringWidth("time"), 0, -1);
		}
	}
}
