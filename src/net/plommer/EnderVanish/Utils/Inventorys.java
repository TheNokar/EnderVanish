package net.plommer.EnderVanish.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
public class Inventorys {
	public static Inventory chestSmall(Player player) {
		return Bukkit.getServer().createInventory(player, 9*3, "Chest Contents");
	}
	public static Inventory chestBig(Player player) {
		return Bukkit.getServer().createInventory(player, 9*6, "Chest Contents");
	}
}
