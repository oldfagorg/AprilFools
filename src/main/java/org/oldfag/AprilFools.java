package org.oldfag;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.oldfag.events.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author John200410 3/5/2020 for OldfagAprilFools
 */
public class AprilFools extends JavaPlugin implements Listener {

	/*
	 * TODO:
	 * flowers drop OP stuff
	 * noteblock music
	 */

	/**
	 * Constants
	 */
	public static List<ItemStack> blockList = new ArrayList<>();

	@Override
	public void onEnable() {

		/*
		 * Interact event
		 */
		Bukkit.getServer().getPluginManager().registerEvents(new RightClickEvent(), this);

		/*
		 * Chat modifications
		 */
		Bukkit.getServer().getPluginManager().registerEvents(new ChatEvent(), this);

		/*
		 * Spawn tnt when entity dies
		 */
		Bukkit.getServer().getPluginManager().registerEvents(new DeathEvent(), this);

		/*
		 * Spawn giant instead of wither
		 */
		Bukkit.getServer().getPluginManager().registerEvents(new SpawnEvent(), this);

		/*
		 * Spawn random block when you break a block
		 */
		//create list of all blocks at start so i wouldn't have to do it everytime the event was called
		generateBlockList();
		System.out.println(blockList);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockBreakEvent(), this);
	}

	private void generateBlockList() {
		for (Iterator<Recipe> it = Bukkit.recipeIterator(); it.hasNext(); ) {
			Recipe item = it.next();
			if(item.getResult().getType().isBlock()) {
				blockList.add(item.getResult());
			}
		}
	}

}
