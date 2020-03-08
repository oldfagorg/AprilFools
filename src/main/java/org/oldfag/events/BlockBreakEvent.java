package org.oldfag.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.oldfag.utils.ItemUtils;

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
		if(ItemUtils.isFlower(new ItemStack(event.getBlock().getType()))) {
			event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), ItemUtils.getRandomOPItem());
		} else {
			event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), ItemUtils.getRandomBlock());
		}
	}

}
