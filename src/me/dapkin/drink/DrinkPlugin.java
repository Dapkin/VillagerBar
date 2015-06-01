package me.dapkin.drink;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class DrinkPlugin extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {
		initialiseConfig();
		Bukkit.getServer().getPluginManager().registerEvents(new DrinkListeners(this), this);
		setupEconomy();
		setupInv();
	}
	@Override
	public void onDisable() {
		
	}
	public Inventory barInv = Bukkit.createInventory(null, 9, getConfig().getString("options.inventoryname"));
	public static Economy economy = null;
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
		}
		return (economy != null);
	}
	public void initialiseConfig() {
		FileConfiguration config = getConfig();
		
		config.options().copyDefaults(true);
		saveConfig();
	}
	public void reloadPlugin() {
		this.reloadConfig();
		setupInv();
	}
	ItemStack compass = new ItemStack(Material.COMPASS);
	ItemStack drink1 = new ItemStack(Material.POTION);
	ItemStack drink2 = new ItemStack(Material.POTION);
	ItemStack drink3 = new ItemStack(Material.POTION);
	ItemStack drink4 = new ItemStack(Material.POTION);
	ItemStack drink5 = new ItemStack(Material.POTION);
	ItemStack drink6 = new ItemStack(Material.POTION);
	ItemStack drink7 = new ItemStack(Material.POTION);
	ItemStack paper = new ItemStack(Material.PAPER);
	public void setupInv() {
		
		ItemMeta icompass = compass.getItemMeta();
		ItemMeta idrink1 = drink1.getItemMeta();
		ItemMeta idrink2 = drink2.getItemMeta();
		ItemMeta idrink3 = drink3.getItemMeta();
		ItemMeta idrink4 = drink4.getItemMeta();
		ItemMeta idrink5 = drink5.getItemMeta();
		ItemMeta idrink6 = drink6.getItemMeta();
		ItemMeta idrink7 = drink7.getItemMeta();
		ItemMeta ipaper = paper.getItemMeta();
		
		icompass.setDisplayName(ChatColor.WHITE + getConfig().getString("options.compassname"));
		idrink1.setDisplayName(ChatColor.WHITE + getConfig().getString("drinks.drink1.name"));
		idrink2.setDisplayName(ChatColor.WHITE + getConfig().getString("drinks.drink2.name"));
		idrink3.setDisplayName(ChatColor.WHITE + getConfig().getString("drinks.drink3.name"));
		idrink4.setDisplayName(ChatColor.WHITE + getConfig().getString("drinks.drink4.name"));
		idrink5.setDisplayName(ChatColor.WHITE + getConfig().getString("drinks.drink5.name"));
		idrink6.setDisplayName(ChatColor.WHITE + getConfig().getString("drinks.drink6.name"));
		idrink7.setDisplayName(ChatColor.WHITE + getConfig().getString("drinks.drink7.name"));
		ipaper.setDisplayName(ChatColor.WHITE + getConfig().getString("options.papername"));
		
		icompass.setLore(Arrays.asList(ChatColor.GREEN + getConfig().getString("options.compasslore")));
		idrink1.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("drinks.drink1.price"))));
		idrink2.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("drinks.drink2.price"))));
		idrink3.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("drinks.drink3.price"))));
		idrink4.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("drinks.drink4.price"))));
		idrink5.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("drinks.drink5.price"))));
		idrink6.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("drinks.drink6.price"))));
		idrink7.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + getConfig().getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("drinks.drink7.price"))));
		ipaper.setLore(Arrays.asList(ChatColor.GREEN + getConfig().getString("options.paperlore")));
		
		compass.setItemMeta(icompass);
		drink1.setItemMeta(idrink1);
		drink2.setItemMeta(idrink2);
		drink3.setItemMeta(idrink3);
		drink4.setItemMeta(idrink4);
		drink5.setItemMeta(idrink5);
		drink6.setItemMeta(idrink6);
		drink7.setItemMeta(idrink7);
		paper.setItemMeta(ipaper);
		
		
		
		barInv.setItem(0, compass);
		barInv.setItem(1, drink1);
		barInv.setItem(2, drink2);
		barInv.setItem(3, drink3);
		barInv.setItem(4, drink4);
		barInv.setItem(5, drink5);
		barInv.setItem(6, drink6);
		barInv.setItem(7, drink7);
		barInv.setItem(8, paper);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(!(p instanceof Player)) {
			p.sendMessage(ChatColor.RED + "You must run this command in-game!");
		}else {	
			if(cmd.getName().equalsIgnoreCase("villagerbar")) {
				if(args.length == 1 && args[0].equalsIgnoreCase("spawn")) {
					if(p.hasPermission("villagerbar.spawn") || p.isOp()) {
						Location loc = p.getLocation();
						p.getWorld().spawnEntity(loc, EntityType.VILLAGER).setCustomName(getConfig().getString("options.villagername".replaceAll("(&([a-f0-9]))", "\u00A7$2")));
						p.sendMessage(getConfig().getString("options.prefix").replaceAll("(&([a-f0-9]))", "\u00A7$2") + " " +  getConfig().getString("options.spawnsuccess").replaceAll("(&([a-f0-9]))", "\u00A7$2"));
					}
				}else if(args.length == 1 && args[0].equalsIgnoreCase("reload")) {
					if(p.hasPermission("villagerbar.reload") || p.isOp()) {
						p.sendMessage(getConfig().getString("options.prefix").replaceAll("(&([a-f0-9]))", "\u00A7$2") + " " +  getConfig().getString("options.reloadsuccess").replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						reloadPlugin();
					}
				}
			}else if(cmd.getName().equalsIgnoreCase("bar")) {
				if(p.hasPermission("villagerbar.virtual") || p.isOp()) {
					p.openInventory(barInv);
					p.sendMessage(getConfig().getString("options.prefix").replaceAll("(&([a-f0-9]))", "\u00A7$2") + " " +  getConfig().getString("options.openmessage").replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				}
			}
		}
		return true;
	}

}
