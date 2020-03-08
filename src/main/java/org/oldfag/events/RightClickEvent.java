package org.oldfag.events;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.oldfag.utils.ExplosionUtils;

/**
 * @author John200410 3/5/2020 for OldfagAprilFools
 */
public class RightClickEvent implements Listener {

	/**
	 * Using PlayerInteractEvent because the sleep event was only fired post sleep :/
	 */
	@EventHandler
	public void onSleep(PlayerInteractEvent event) {
		/*
		 * Exploding beds
		 */
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.BED_BLOCK) {
			ExplosionUtils.createExplosion(event.getPlayer(), 10, true, true);
		}

		/*
		 * Spawn witches when opening a chest
		 */
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.CHEST) {
			event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.WITCH);
		}

		/*
		 * Cancel placing water in worlds other than the nether
		 */
		if(event.getItem() != null) {
			if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getItem().getType() == Material.WATER_BUCKET && (event.getPlayer().getWorld().getEnvironment() == World.Environment.NORMAL || event.getPlayer().getWorld().getEnvironment() == World.Environment.THE_END)) {
				event.setCancelled(true);
				event.getPlayer().sendMessage("§cPlacing water is temporarily disabled due to an exploit. Please place them in the nether instead");
			}
		}

		/*
		 * Set block to water if player tries to place water in nether
		 */
		if(event.getItem() != null) {
			if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getItem().getType() == Material.WATER_BUCKET && event.getPlayer().getWorld().getEnvironment() == World.Environment.NETHER) {
				event.setCancelled(true);
				Block lookingAt = event.getPlayer().getTargetBlock(null, 5);
				lookingAt.getRelative(0, 1, 0).setType(Material.WATER);
			}
		}

	}

}
