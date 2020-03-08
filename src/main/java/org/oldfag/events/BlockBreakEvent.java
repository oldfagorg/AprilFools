package org.oldfag.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.oldfag.utils.BlockUtils;

/**
 * @author John200410 3/7/2020 for OldfagAprilFools
 */
public class BlockBreakEvent implements Listener {

	/**
	 * Called when a player breaks a block
	 */
	@EventHandler
	public void onSpawn(org.bukkit.event.block.BlockBreakEvent event) {
		event.setDropItems(false);
		event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), BlockUtils.getRandomBlock());
	}

}
