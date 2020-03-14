package org.oldfag.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.oldfag.AprilFools;
import org.oldfag.utils.CoronaUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author John200410
 */
public class EatEvent implements Listener {

    Random rand = new Random();

    /**
     * Corona Virus
     */
    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        if(this.rand.nextInt(100) == 0) {
            CoronaUtils.giveVirus(event.getPlayer());
        }
    }

}
