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
