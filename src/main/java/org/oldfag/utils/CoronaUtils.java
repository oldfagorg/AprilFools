package org.oldfag.utils;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * @author John200410 3/14/2020 for OldfagAprilFools
 */
public class CoronaUtils {

	public static void giveVirus(Player player) {
		player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 1, true, true));
		player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, Integer.MAX_VALUE, 1, true, true));
		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1, true, true));
		player.sendMessage("You have been infected with COVID-19");
	}

	public static boolean hasCorona(Player player) {
		return player.hasPotionEffect(PotionEffectType.WEAKNESS) && player.hasPotionEffect(PotionEffectType.HUNGER) && player.hasPotionEffect(PotionEffectType.SLOW);
	}

}
