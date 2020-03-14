package org.oldfag.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.oldfag.utils.CoronaUtils;

/**
 * @author John200410
 */
public class MoveEvent implements Listener {

	/**
	 * Corona Virus
	 */
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if(CoronaUtils.hasCorona(event.getPlayer())) {
			event.getPlayer().getNearbyEntities(4, 4, 4).forEach(entity -> {
				if(entity.getType().equals(EntityType.PLAYER) && !CoronaUtils.hasCorona((Player) entity)) {
					CoronaUtils.giveVirus((Player) entity);
				}
			});
		}
	}

}
