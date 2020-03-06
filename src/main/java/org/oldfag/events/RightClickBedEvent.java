package org.oldfag.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.oldfag.utils.ExplosionUtils;

/**
 * @author John200410 3/5/2020 for OldfagAprilFools
 */
public class RightClickBedEvent implements Listener {

	/**
	 * Using PlayerInteractEvent because the sleep event was only fired post sleep :/
	 */
	@EventHandler
	public void onSleep(PlayerInteractEvent event) {
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.BED_BLOCK) {
			ExplosionUtils.createExplosion(event.getPlayer(), 10, true, true);
		}
	}

}
