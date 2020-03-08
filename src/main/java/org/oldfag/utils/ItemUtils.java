package org.oldfag.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.oldfag.AprilFools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author John200410 3/8/2020 for OldfagAprilFools
 */
public class ItemUtils {

	public static ItemStack getRandomBlock() {
		Random rand = new Random();
		return AprilFools.blockList.get(rand.nextInt(AprilFools.blockList.size()));
	}

	public static ItemStack getRandomOPItem() {
		Random rand = new Random();
		return AprilFools.opItems.get(rand.nextInt(AprilFools.opItems.size()));
	}

	public static boolean isFlower(ItemStack item) {
		for (ItemStack flower : AprilFools.flowers) {
			if(flower.isSimilar(item)) {
				return true;
			}
		}
		return false;
	}

}
