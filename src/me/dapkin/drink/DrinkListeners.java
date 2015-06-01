package me.dapkin.drink;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DrinkListeners implements Listener{
	
	public final DrinkPlugin ref;
	public DrinkListeners(DrinkPlugin inst) {
		this.ref = inst;
	}
	
	@EventHandler
	public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		Entity entity = e.getRightClicked();
		if(e.getRightClicked() instanceof Villager) {
			if(entity.getCustomName() != null) {
				if(((LivingEntity)entity).getCustomName().equals(ref.getConfig().getString("options.villagername"))) {
					e.setCancelled(true);
					p.openInventory(ref.barInv);
					p.sendMessage(ref.getConfig().getString("options.prefix").replaceAll("(&([a-f0-9]))", "\u00A7$2") + " " +  ref.getConfig().getString("options.openmessage").replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				}
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		Inventory inv = e.getInventory();
		String error = ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.DARK_RED + " You do not have sufficient funds.";
		if(inv.getName().equals(ref.barInv.getName())) {
			e.setCancelled(true);
			if(clicked == null || clicked.getType() == Material.AIR) return;
			else if(clicked.getItemMeta().getDisplayName().contains(ref.getConfig().getString("names.drink1"))) {
				if(DrinkPlugin.economy.getBalance(player) >= ref.getConfig().getInt("price.drink1")) {
					DrinkPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("price.drink1"));
					player.getInventory().addItem(ref.drink1);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink1")) +" has been taken from your account.");
					player.closeInventory();
				}else{
					player.closeInventory();
					player.sendMessage(error);
				}
			}else if(clicked.getItemMeta().getDisplayName().contains(ref.getConfig().getString("names.drink2"))) {
				if(DrinkPlugin.economy.getBalance(player) >= ref.getConfig().getInt("price.drink2")) {
					DrinkPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("price.drink2"));
					player.getInventory().addItem(ref.drink2);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink2")) +" has been taken from your account.");
					player.closeInventory();
				}else {
					player.closeInventory();
					player.sendMessage(error);
				}
			}else if(clicked.getItemMeta().getDisplayName().contains(ref.getConfig().getString("names.drink3"))) {
				if(DrinkPlugin.economy.getBalance(player) >= ref.getConfig().getInt("price.drink3")) {
					DrinkPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("price.drink3"));
					player.getInventory().addItem(ref.drink3);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink3")) +" has been taken from your account.");
					player.closeInventory();
				}else {
					player.closeInventory();
					player.sendMessage(error);
				}
			}else if(clicked.getItemMeta().getDisplayName().contains(ref.getConfig().getString("names.drink4"))) {
				if(DrinkPlugin.economy.getBalance(player) >= ref.getConfig().getInt("price.drink4")) {
					DrinkPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("price.drink4"));
					player.getInventory().addItem(ref.drink4);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink4")) +" has been taken from your account.");
					player.closeInventory();
				}else {
					player.closeInventory();
					player.sendMessage(error);
				}
			}else if(clicked.getItemMeta().getDisplayName().contains(ref.getConfig().getString("names.drink5"))) {
				if(DrinkPlugin.economy.getBalance(player) >= ref.getConfig().getInt("price.drink5")) {
					DrinkPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("price.drink5"));
					player.getInventory().addItem(ref.drink5);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink5")) +" has been taken from your account.");
					player.closeInventory();
				}else {
					player.closeInventory();
					player.sendMessage(error);
				}
			}else if(clicked.getItemMeta().getDisplayName().contains(ref.getConfig().getString("names.drink6"))) {
				if(DrinkPlugin.economy.getBalance(player) >= ref.getConfig().getInt("price.drink6")) {
					DrinkPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("price.drink6"));
					player.getInventory().addItem(ref.drink6);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink6")) +" has been taken from your account.");
					player.closeInventory();
				}else {
					player.closeInventory();
					player.sendMessage(error);
				}
			}else if(clicked.getItemMeta().getDisplayName().contains(ref.getConfig().getString("names.drink7"))) {
				if(DrinkPlugin.economy.getBalance(player) >= ref.getConfig().getInt("price.drink7")) {
					DrinkPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("price.drink7"));
					player.getInventory().addItem(ref.drink7);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink7")) +" has been taken from your account.");
					player.closeInventory();
				}else {
					player.closeInventory();
					player.sendMessage(error);
				}
			}else if(clicked.getType() == Material.COMPASS) {
				player.closeInventory();
			}else if(clicked.getType() == Material.PAPER) {
				player.sendMessage(ChatColor.GREEN + "Balance: " + ChatColor.RED + ref.getConfig().getString("options.currencysign") + DrinkPlugin.economy.getBalance(player));
			}
		}
	}
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent e) {
		int num = new Random().nextInt(99);
		Player p = e.getPlayer();
		Location loc = e.getPlayer().getLocation();
		if(e.getItem().getType() == Material.POTION) {
			if(e.getItem().equals(ref.drink1)) {
				if(num < ref.getConfig().getInt("options.chance")) {
					p.playSound(loc, Sound.LEVEL_UP, 100, 0);
					DrinkPlugin.economy.depositPlayer(p, ref.getConfig().getInt("price.drink1") * 2);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + "You've won " + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink1") * 2) + "!");
				}else {
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 20));
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 20));
				}
			}else if(e.getItem().equals(ref.drink2)) {
				if(num < ref.getConfig().getInt("options.chance")) {
					p.playSound(loc, Sound.LEVEL_UP, 100, 0);
					DrinkPlugin.economy.depositPlayer(p, ref.getConfig().getInt("price.drink2") * 2);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + "You've won " + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink2") * 2) + "!");
				}else {
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 20));
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 20));
				}
			}else if(e.getItem().equals(ref.drink3)) {
				if(num < ref.getConfig().getInt("options.chance")) {
					p.playSound(loc, Sound.LEVEL_UP, 100, 0);
					DrinkPlugin.economy.depositPlayer(p, ref.getConfig().getInt("price.drink3") * 2);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + "You've won " + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink3") * 2) + "!");
				}else {
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 20));
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 20));
				}
			}else if(e.getItem().equals(ref.drink4)) {
				if(num < ref.getConfig().getInt("options.chance")) {
					p.playSound(loc, Sound.LEVEL_UP, 100, 0);
					DrinkPlugin.economy.depositPlayer(p, ref.getConfig().getInt("price.drink4") * 2);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + "You've won " + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink4") * 2) + "!");
				}else {
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 20));
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 20));
				}
			}else if(e.getItem().equals(ref.drink5)) {
				if(num < ref.getConfig().getInt("options.chance")) {
					p.playSound(loc, Sound.LEVEL_UP, 100, 0);
					DrinkPlugin.economy.depositPlayer(p, ref.getConfig().getInt("price.drink5") * 2);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + "You've won " + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink5") * 2) + "!");
				}else {
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 20));
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 20));
				}
			}else if(e.getItem().equals(ref.drink6)) {
				if(num < ref.getConfig().getInt("options.chance")) {
					p.playSound(loc, Sound.LEVEL_UP, 100, 0);
					DrinkPlugin.economy.depositPlayer(p, ref.getConfig().getInt("price.drink6") * 2);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + "You've won " + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink6") * 2) + "!");
				}else {
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 20));
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 20));
				}
			}else if(e.getItem().equals(ref.drink7)) {
				if(num < ref.getConfig().getInt("options.chance")) {
					p.playSound(loc, Sound.LEVEL_UP, 100, 0);
					DrinkPlugin.economy.depositPlayer(p, ref.getConfig().getInt("price.drink7") * 2);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.GREEN + "You've won " + ref.getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("price.drink7") * 2) + "!");
				}else {
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 20));
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 20));
				}
			}
		}
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if(e.getEntity() instanceof Villager) {
				if(e.getEntity().getCustomName().equals(ref.getConfig().getString("options.villagername"))) {
					if(ref.getConfig().getBoolean("options.invinciblevillager") || p.isOp()) {
						e.setCancelled(true);
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.prefix")) + " " + ChatColor.translateAlternateColorCodes('&', ref.getConfig().getString("options.cantdamage")));
					}else {
						return;
					}
				}
			}
		}
	}
	
}
