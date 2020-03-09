package org.oldfag.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffectType;
import org.oldfag.AprilFools;

import java.util.ArrayList;
import java.util.Random;

public class EatEvent implements Listener {

    Random rand = new Random();

    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        event.getPlayer().addPotionEffect(AprilFools.potionEffects.get(rand.nextInt(AprilFools.potionEffects.size())));
    }

}
