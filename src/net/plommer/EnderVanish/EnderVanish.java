package net.plommer.EnderVanish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import net.plommer.EnderVanish.Commands.*;
import net.plommer.EnderVanish.Hooks.EssentialsHook;
import net.plommer.EnderVanish.Listeners.*;
import net.plommer.EnderVanish.Utils.PlayerVanish;
import net.plommer.EnderVanish.Utils.VanishPlayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderVanish extends JavaPlugin {

	public ArrayList<BaseCommand> commands = new ArrayList<BaseCommand>();
	public HashMap<UUID, VanishPlayer> vanishPlayer = new HashMap<UUID, VanishPlayer>();
    public EssentialsHook ess = new EssentialsHook(this);
	
	public void onEnable() {
		//Register commands
		registerCommands();
		//Hooks
		registerHooks();
		//
		registerListeners(getServer().getPluginManager());
	}
	
	public void onDisable() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(vanishPlayer.containsKey(p.getUniqueId())) {
				VanishPlayer vp = vanishPlayer.get(p.getUniqueId());
				if(vp.isVanish()) {
					PlayerVanish.Vanish(this, p);
				}
			}
		}
	}
	
	public void registerListeners(PluginManager pm) {
		pm.registerEvents(new LoginListener(this), this);
		pm.registerEvents(new PlayerChestListener(this), this);
		pm.registerEvents(new PlayerListener(this), this);
	}
	
	public void registerCommands() {
		this.getCommand("vanish").setExecutor(new CommandHandler(this));
		//Vanish command always on top!
		commands.add(new VanishCommand());
		commands.add(new ExtraCommands());
		commands.add(new VanishOtherCommand());
	}
	
	public void registerHooks() {
		ess.onEnable(this);
	}
	
}