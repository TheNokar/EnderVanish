package net.plommer.EnderVanish.Listeners;

import net.plommer.EnderVanish.EnderVanish;
import net.plommer.EnderVanish.Utils.PlayerVanish;
import net.plommer.EnderVanish.Utils.Utils;
import net.plommer.EnderVanish.Utils.VanishPlayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LoginListener implements Listener {

	protected EnderVanish plugin;
	public LoginListener(EnderVanish plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void joinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		for (Player p : plugin.getServer().getOnlinePlayers()) {
        	if (plugin.vanishPlayer.containsKey(p.getUniqueId())) {
        		VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
        		if(vp.isVanish() == true && !player.hasPermission("endervanish.vanish")) {
        			player.hidePlayer(p);
        		}
        	}     
        } 
		if(plugin.vanishPlayer.containsKey(player.getUniqueId())) {
			VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
			if(vp.isVanish() && vp.getJoinVanish()) {
				for(Player p1 : Bukkit.getOnlinePlayers()) {
					if(p1.hasPermission("endervanish.vanish") && p1.getUniqueId() != player.getUniqueId()) {
						Utils.sendMessage(p1, "&a" + player.getName() + " &bhas joined vanished!");
					} else {
						p1.hidePlayer(player);
					}
				}
				event.setJoinMessage(null);
			}
		}
	}
	
	@EventHandler
	public void logoutEvent(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if(plugin.vanishPlayer.containsKey(player.getUniqueId())) {
			VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
			if(vp.isVanish()) {
				if(vp.getJoinVanish()) {
					event.setQuitMessage(null);
				} else {
					PlayerVanish.Vanish(plugin, player);
				}
			}
		}
	}
	
}
