package org.oldfag.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * @author John200410 3/5/2020 for OldfagAprilFools
 */
public class ExplosionUtils {

	public static void createExplosion(Player player, int power, Boolean fire, Boolean damage) {
		Location l = player.getLocation();
		player.getWorld().createExplosion(l.getX(), l.getY(), l.getZ(), power, fire, damage);
	}

}
