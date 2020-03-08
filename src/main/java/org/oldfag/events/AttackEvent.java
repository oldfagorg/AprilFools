package org.oldfag.events;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

/**
 *  @author x1D, 03/08/2020
 */
public class AttackEvent implements Listener {

    private Random rand = new Random();

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        Player entity = (Player) event.getEntity();
        if (event.getEntity().getType() == EntityType.PLAYER &&
                event.getDamager().getType() == EntityType.PLAYER) {
            // 10% chance of executing
            if (rand.nextInt(10) == 0) {
                Bukkit.getWorld(entity.getLocation().getWorld().getName()).dropItemNaturally(
                        entity.getLocation(), entity.getInventory().getItemInMainHand());
                entity.getInventory().remove(entity.getInventory().getItemInMainHand());
                entity.updateInventory();
            }

        }
    }

}