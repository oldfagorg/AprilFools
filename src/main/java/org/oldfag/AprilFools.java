package org.oldfag;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
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
	 * opening a chest causes a witch to spawn
	 * leaderboard of top kills
	 * creeper sounds randomly played
	 * eating gives you a random potion effect
	 * hitting something with a tool that isn't a sword or axe deals the damage to the player instead of what they are attacking
	 * player heads
	 * if you punch a player with your fist they have a 10% chance of dropping their item
	 * noteblock music
	 */

	/**
	 * Constants
	 */
	public static List<ItemStack> blockList = new ArrayList<>();
	public static List<ItemStack> flowers = new ArrayList<>();
	public static List<ItemStack> opItems = new ArrayList<>();

	@Override
	public void onEnable() {

		/*
		 * Init
		 */
		//create list of all blocks at start so i wouldn't have to do it every time the event was called
		generateBlockList();
		//create list of flowers
		flowers.add(new ItemStack(Material.YELLOW_FLOWER));
		flowers.add(new ItemStack(Material.CHORUS_FLOWER));
		flowers.add(new ItemStack(Material.DEAD_BUSH));
		flowers.add(new ItemStack(Material.RED_ROSE));
		flowers.add(new ItemStack(Material.DOUBLE_PLANT));
		//create list of op items

		/*
		 * Sword
		 */
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta swordItemMeta = sword.getItemMeta();
		swordItemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		swordItemMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		swordItemMeta.addEnchant(Enchantment.DURABILITY, 3, true);
		swordItemMeta.addEnchant(Enchantment.MENDING, 1, true);
		swordItemMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
		sword.setItemMeta(swordItemMeta);
		opItems.add(sword);

		/*
		 * Pickaxe
		 */
		ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta pickItemMeta = pick.getItemMeta();
		pickItemMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
		pickItemMeta.addEnchant(Enchantment.DURABILITY, 3, true);
		pickItemMeta.addEnchant(Enchantment.MENDING, 1, true);
		pickItemMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
		pick.setItemMeta(pickItemMeta);
		opItems.add(pick);

		/*
		 * Helmet
		 */
		ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta helmItemMeta = helm.getItemMeta();
		helmItemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		helmItemMeta.addEnchant(Enchantment.DURABILITY, 3, true);
		helmItemMeta.addEnchant(Enchantment.MENDING, 1, true);
		helmItemMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
		helm.setItemMeta(helmItemMeta);
		opItems.add(helm);

		/*
		 * Chestplate
		 */
		ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta chestItemMeta = chest.getItemMeta();
		chestItemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		chestItemMeta.addEnchant(Enchantment.DURABILITY, 3, true);
		chestItemMeta.addEnchant(Enchantment.MENDING, 1, true);
		chestItemMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
		chest.setItemMeta(chestItemMeta);
		opItems.add(chest);

		/*
		 * Leggings
		 */
		ItemStack leg = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta legItemMeta = leg.getItemMeta();
		legItemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		legItemMeta.addEnchant(Enchantment.DURABILITY, 3, true);
		legItemMeta.addEnchant(Enchantment.MENDING, 1, true);
		legItemMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
		leg.setItemMeta(legItemMeta);
		opItems.add(leg);

		/*
		 * Boots
		 */
		ItemStack boot = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta bootItemMeta = helm.getItemMeta();
		bootItemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		bootItemMeta.addEnchant(Enchantment.DURABILITY, 3, true);
		bootItemMeta.addEnchant(Enchantment.MENDING, 1, true);
		bootItemMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
		boot.setItemMeta(bootItemMeta);
		opItems.add(boot);

		/*
		 * Random items
		 */
		opItems.add(new ItemStack(Material.END_CRYSTAL));
		opItems.add(new ItemStack(Material.BEDROCK));
		opItems.add(new ItemStack(Material.TNT));
		opItems.add(new ItemStack(Material.OBSIDIAN));
		opItems.add(new ItemStack(Material.TOTEM));
		opItems.add(new ItemStack(Material.ENDER_PORTAL_FRAME));
		opItems.add(new ItemStack(Material.EYE_OF_ENDER));

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
		 * Flower power
		 */
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
