package org.oldfag.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

/**
 * @author x1D
 */
public class AttackEvent implements Listener {
	private Random rand = new Random();

	/**
	 * random chance of dropping item
	 */
	@EventHandler
	public void onAttack(EntityDamageByEntityEvent event) {
		if((event.getEntity().getType() == EntityType.PLAYER) && (event.getDamager().getType() == EntityType.PLAYER)) {
			Player attacker = (Player) event.getDamager();
			Player entity = (Player) event.getEntity();
			if((this.rand.nextInt(10) == 0) && (entity.getInventory().getItemInMainHand() != null)) {
				Bukkit.getWorld(entity.getLocation().getWorld().getName()).dropItemNaturally(entity.getLocation(), entity.getInventory().getItemInMainHand());
				entity.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
				entity.updateInventory();
			}
			if((attacker.getInventory().getItemInMainHand().getType() != Material.DIAMOND_AXE) && (attacker.getInventory().getItemInMainHand().getType() != Material.DIAMOND_SWORD)) {
				event.setCancelled(true);
				attacker.damage(event.getFinalDamage());
			}
		}
	}
}
