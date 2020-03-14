package org.oldfag;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.oldfag.events.*;
import org.oldfag.utils.MusicUtils;
import org.primesoft.midiplayer.MidiPlayerMain;
import org.primesoft.midiplayer.midiparser.MidiParser;
import org.primesoft.midiplayer.track.GlobalTrack;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author John200410, x1D 3/5/2020 for OldfagAprilFools
 */
public class AprilFools extends JavaPlugin implements Listener {

	/**
	 * Constants
	 */
	public static List<ItemStack> blockList = new ArrayList<>();
	public static List<ItemStack> flowers = new ArrayList<>();
	public static List<ItemStack> opItems = new ArrayList<>();
	public static MidiPlayerMain midiPlayer;
	public static List<GlobalTrack> tracks = new ArrayList<>();

	public static List<PotionEffect> potionEffects = new ArrayList<>();

	@Override
	public void onEnable() {

		/*
		 * Init
		 */

		//declare midiplayer instance
		midiPlayer = MidiPlayerMain.getInstance();

		//create list of all blocks at start so i wouldn't have to do it every time the event was called
		generateBlockList();

		//init music player hook
		initMusicPlayer();
		midiPlayer.getMusicPlayer().playTrack(MusicUtils.getRandomTrack());

		//check every second if a track is playing, if not then play a new one
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if(midiPlayer.getMusicPlayer().getPlayingTracks().size() == 0) {
					System.out.println("Playing new track");

					midiPlayer.getMusicPlayer().playTrack(MusicUtils.getRandomTrack());
				}
			}
		}, 0, 20);

		//create list of flowers
		flowers.add(new ItemStack(Material.YELLOW_FLOWER));
		flowers.add(new ItemStack(Material.CHORUS_FLOWER));
		flowers.add(new ItemStack(Material.DEAD_BUSH));
		flowers.add(new ItemStack(Material.RED_ROSE));
		flowers.add(new ItemStack(Material.DOUBLE_PLANT));

		//create list of potion effects
		this.initPotions();

		//create list of op items
		this.initItems();

		//register events
		registerEvents(this, new RightClickEvent(), new ChatEvent(), new DeathEvent(), new SpawnEvent(), new BlockBreakEvent(), new AttackEvent(), new EatEvent(), new MoveEvent());

	}

	private void initItems() {
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
	}

	private void initPotions() {
		potionEffects.add(new PotionEffect(PotionEffectType.ABSORPTION, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.BLINDNESS, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.CONFUSION, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.FAST_DIGGING, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.GLOWING, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.HARM, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.HEAL, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.HEALTH_BOOST, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.HUNGER, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.INVISIBILITY, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.JUMP, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.LEVITATION, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.LUCK, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.NIGHT_VISION, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.POISON, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.REGENERATION, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.SATURATION, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.SLOW, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.SLOW_DIGGING, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.SPEED, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.UNLUCK, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.WATER_BREATHING, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.WEAKNESS, 300, 0, true, false));
		potionEffects.add(new PotionEffect(PotionEffectType.WITHER, 300, 0, true, false));

	}

	private void initMusicPlayer() {
		File[] dir = midiPlayer.getDataFolder().listFiles(pathname -> pathname.getName().endsWith(".mid"));
		if(dir != null) {
			for (File file : dir) {
				this.getLogger().info("added midi file " + file.getName());
				tracks.add(new GlobalTrack(this, MidiParser.loadFile(file).getNotes()));
			}
		}
	}

	private void generateBlockList() {
		for (Iterator<Recipe> it = Bukkit.recipeIterator(); it.hasNext(); ) {
			Recipe item = it.next();
			if(item.getResult().getType().isBlock()) {
				blockList.add(item.getResult());
			}
		}
	}

	/**
	 * Condense code
	 */
	private void registerEvents(Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}

}
