package org.oldfag.utils;

import org.bukkit.inventory.ItemStack;
import org.oldfag.AprilFools;

import java.util.Random;

/**
 * @author John200410 3/8/2020 for OldfagAprilFools
 */
public class BlockUtils {

	public static ItemStack getRandomBlock() {
		Random rand = new Random();
		return AprilFools.blockList.get(rand.nextInt(AprilFools.blockList.size()));
	}

}
