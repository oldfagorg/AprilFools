package org.oldfag;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.oldfag.events.ChatEvent;
import org.oldfag.events.DeathEvent;
import org.oldfag.events.RightClickEvent;
import org.oldfag.events.SpawnEvent;

/**
 * @author John200410 3/5/2020 for OldfagAprilFools
 */
public class AprilFools extends JavaPlugin implements Listener {

	/**
	 * TODO:
	 * mining blocks drops a random block instead of the block you mined
	 * flowers drop OP stuff
	 * noteblock music
	 */

	@Override
	public void onEnable() {

		/*
		 * Interact event
		 */
		Bukkit.getServer().getPluginManager().registerEvents(new RightClickEvent(), this);

		/*
		 * Chat modifications
		 */
		Bukkit.getServer().getPluginManager().registerEvents(new ChatEvent(), this);

		/*
		 * Spawn tnt when entity dies
		 */
		Bukkit.getServer().getPluginManager().registerEvents(new DeathEvent(), this);

		/*
		 * Spawn tnt when entity dies
		 */
		Bukkit.getServer().getPluginManager().registerEvents(new SpawnEvent(), this);
	}

}
