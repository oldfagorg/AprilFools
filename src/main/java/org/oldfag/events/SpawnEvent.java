package org.oldfag.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

/**
 * @author John200410 3/7/2020 for OldfagAprilFools
 */
public class SpawnEvent implements Listener {

	/**
	 * Called when an entity spawns
	 */
	@EventHandler
	public void onSpawn(EntitySpawnEvent event) {
		if(event.getEntity() instanceof Wither) {
			event.setCancelled(true);
			event.getEntity().getWorld().spawnEntity(event.getLocation(), EntityType.GIANT);
		}
	}

}
