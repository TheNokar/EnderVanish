package net.plommer.EnderVanish.Hooks;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import net.ess3.api.IEssentials;
import net.plommer.EnderVanish.EnderVanish;

public class EssentialsHook {
	  private IEssentials essentials;
	  EnderVanish plugin;
	  public EssentialsHook(EnderVanish plugin) {
	        this.plugin = plugin;
	  }
	  public void onEnable(EnderVanish plugin){
		  final Plugin grab = this.plugin.getServer().getPluginManager().getPlugin("Essentials");
		  	if (grab != null) {
		    	this.essentials = ((IEssentials) grab);
		    	this.plugin.getLogger().info("Now hooking into Essentials");
		   	} else {
		   		this.plugin.getLogger().info("Could not find Essentials.");
		    	this.essentials = null;
		   	}	  
	  }
	  public void unvanish(Player player) {
		  this.setHidden(player, false);
	  }
	  public void vanish(Player player) {
		  this.setHidden(player , true);
	  }
	  private void setHidden(Player player, boolean hide) {
		  if(plugin.getServer().getPluginManager().getPlugin("Essentials") != null) {
	            this.essentials.getUser(player).setHidden(hide);
		  }
	  }
}
