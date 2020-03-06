package org.oldfag;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.oldfag.events.RightClickBedEvent;

/**
 * @author John200410 3/5/2020 for OldfagAprilFools
 */
public class AprilFools extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {

		Bukkit.getServer().getPluginManager().registerEvents(new RightClickBedEvent(), this);

	}

}
