package tk.vaporwaves.clockmod.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Render {
	private static String timeString;
	private static long millis;
	private static FontRenderer fr = Minecraft.getInstance().fontRenderer;
	@SubscribeEvent
	public static void RenderEvent(TickEvent.RenderTickEvent e) {
		if (Minecraft.getInstance().currentScreen == null) {
			millis = System.currentTimeMillis();
			timeString = DateFormatUtils.format(millis,"hh:mm aa") + "";
			//remove the 0 if the string starts with 0
			if (timeString.startsWith("0")) {
				timeString = timeString.replaceFirst("0","");
			}
			fr.drawStringWithShadow(timeString,Minecraft.getInstance().getMainWindow().getScaledWidth() - (fr.getStringWidth(timeString) + 3), 3, -1);
		}
	}
}
