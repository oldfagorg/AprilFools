package org.oldfag;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.oldfag.events.ChatEvent;
import org.oldfag.events.RightClickEvent;

/**
 * @author John200410 3/5/2020 for OldfagAprilFools
 */
public class AprilFools extends JavaPlugin implements Listener {

	/**
	 * TODO:
	 * Chat modifications
	 * place water only in nether
	 * when entity dies spawn primed tnt
	 * spawning withers spawns giants instead
	 * mining blocks drops a random block instead of the block you mined
	 * flowers drop OP stuff
	 * noteblock music
	 */

	@Override
	public void onEnable() {

		/*
		 * Exploding beds
		 */
		Bukkit.getServer().getPluginManager().registerEvents(new RightClickEvent(), this);

		/*
		 * Chat modifications
		 */
		Bukkit.getServer().getPluginManager().registerEvents(new ChatEvent(), this);
	}

}
