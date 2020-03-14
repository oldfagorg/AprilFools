package org.oldfag.events;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * @author John200410 3/7/2020 for OldfagAprilFools
 */
public class DeathEvent implements Listener {

	/**
	 * Called when an entity dies
	 */
	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		/*
		 * Spawn tnt when entity dies
		 */
		if(event.getEntity() instanceof Monster || event.getEntity() instanceof Player) {
			event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.PRIMED_TNT);
		}
		if ((event.getEntity() instanceof Player)) {
			ItemStack head = new ItemStack(Material.SKULL_ITEM, 1);
			head.setDurability((short)3);
			SkullMeta headMeta = (SkullMeta)head.getItemMeta();
			headMeta.setOwningPlayer(((Player)event.getEntity()).getPlayer());
			headMeta.setUnbreakable(true);
			headMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
			head.setItemMeta(headMeta);
			event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), head);
		}
	}
}
