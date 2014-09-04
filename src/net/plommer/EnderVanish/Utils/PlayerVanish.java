package net.plommer.EnderVanish.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.plommer.EnderVanish.EnderVanish;

public class PlayerVanish {
	
	public static void Vanish(EnderVanish plugin, Player player) {
		ConsoleCommandSender console = plugin.getServer().getConsoleSender();
		if(plugin.vanishPlayer.containsKey(player.getUniqueId())) {
			VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
			if(vp.isVanish()) {
				vp.setVanish(false);
				plugin.ess.unvanish(player);
				for(Player p1 : Bukkit.getOnlinePlayers()) {
					if(p1.hasPermission("endervanish.vanish") && p1.getUniqueId() != player.getUniqueId()) {
						Utils.sendMessage(p1, "&a" + player.getName() + " &bhas unvanished!");
					}
					p1.showPlayer(player);
				}
				player.setDisplayName(player.getName());
				Utils.sendMessage(player, "&bYou have been uvanished!");
				Utils.sendMessage(console, "&a" + player.getName() + " &bhas unvanished!");
			} else {
				vp.setVanish(true);
				plugin.ess.vanish(player);
				for(Player p1 : Bukkit.getOnlinePlayers()) {
					if(p1.hasPermission("endervanish.vanish") && p1.getUniqueId() != player.getUniqueId()) {
						Utils.sendMessage(p1, "&a" + player.getName() + " &bhas vanished!");
					} else {
						p1.hidePlayer(player);
					}
				}
				player.setDisplayName(Utils.buildString("&7[&6V&7]&r" + player.getName()));
				Utils.sendMessage(player, "&bYou have been vanished!");
				Utils.sendMessage(console, "&a" + player.getName() + " &bhas vanished!");
			}
		} else {
			plugin.vanishPlayer.put(player.getUniqueId(), new VanishPlayer(player.getUniqueId(), player.getName(), false, true, false, false, false, true));
			PlayerVanish.Vanish(plugin, player);
		}
	}
	
}
