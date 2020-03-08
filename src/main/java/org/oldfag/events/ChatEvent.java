package org.oldfag.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * @author John200410 3/5/2020 for OldfagAprilFools
 */
public class ChatEvent implements Listener {

	/**
	 * Replace text in chat
	 */
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		String msg = event.getMessage().replaceAll("(?i)nigger", "John200410").replaceAll("(?i)ass", "butt").replaceAll("(?i)hell", "nether").replaceAll("(?i)bitch", "x1D").replaceAll("(?i)damn", "darn").replaceAll("(?i)nigga", "black friend").replaceAll("(?i)hitler", "nazi").replaceAll("(?i)hause", "retard").replaceAll("(?i)2b2t", "dogshit").replaceAll("(?i)rusherhack", "§c§lrusherhack§r").replaceAll("(?i)no u", "yes me").replaceAll("(?i)6b6t", "ABSOLUTE GARBAGE").replaceAll("(?i)discord", "furrycord").replaceAll("(?i)future", "shit").replaceAll("(?i)x1D", "§6§l§oRETARD§r").replaceAll("(?i)popbob", "fat cunt").replaceAll("(?i)fuck", "frick").replaceAll("(?i)john", "nigger").replaceFirst("(?i)fit", "fucking pedophile named Peter Larsen who lives at 581 Elk Cir Marco Island, FL 34145. he scams little kids for money");
		event.setMessage(msg);
	}

}
