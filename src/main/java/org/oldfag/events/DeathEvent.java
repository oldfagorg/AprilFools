package org.oldfag.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * @author John200410 3/7/2020 for OldfagAprilFools
 */
public class DeathEvent implements Listener {

	/**
	 * Called when an entity dies
	 */
	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		/*
		 * Spawn tnt when entity dies
		 */
		if(event.getEntity() instanceof Monster || event.getEntity() instanceof Player) {
			event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.PRIMED_TNT);
		}
	}
}
