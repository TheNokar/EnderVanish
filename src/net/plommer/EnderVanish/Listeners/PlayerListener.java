package net.plommer.EnderVanish.Listeners;

import net.plommer.EnderVanish.EnderVanish;
import net.plommer.EnderVanish.Utils.VanishPlayer;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
	
	protected EnderVanish plugin;
	public PlayerListener(EnderVanish plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onBowShoot(EntityShootBowEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if(plugin.vanishPlayer.containsKey(player.getUniqueId())) {
				VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
				if(vp.isVanish() && vp.getBow() == false) {
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
	    final Entity smacked = event.getEntity();
	    if(smacked instanceof Player) {
	        Player player = (Player) smacked;
        	if(plugin.vanishPlayer.containsKey(player.getUniqueId())) {
				VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
				if(vp.getGodMode() == false) {
					event.setCancelled(true);
				}
	        }
	    }
	}
	
	@EventHandler
	public void onHungerLoose(FoodLevelChangeEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
        	if(plugin.vanishPlayer.containsKey(player.getUniqueId())) {
				VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
				if(vp.getGodMode() == false) {
					event.setCancelled(true);
				}
	        }
		}
	}
	
	@EventHandler
	public void getDamage(EntityDamageByEntityEvent event) {
		final EntityDamageByEntityEvent ev = (EntityDamageByEntityEvent) event;
	    final Entity damager = ev.getDamager();
	    if (damager instanceof Player) {
	        Player player = (Player) damager;
        	if(plugin.vanishPlayer.containsKey(player.getUniqueId())) {
				VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
				if(vp.getGodMode() == false) {
					event.setCancelled(true);
				}
	        }
	    }	
	}
	
	@EventHandler
	public void EnityTargetChange(EntityTargetLivingEntityEvent event) {
		if(event.getTarget() instanceof Player) {
			Player player = (Player) event.getTarget();
        	if(plugin.vanishPlayer.containsKey(player.getUniqueId())) {
				VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
				if(vp.isVanish()) {
					event.setCancelled(true);
				}
	        }
		}
	}
	
	@EventHandler
	public void PlayerInteract(PlayerInteractEvent event) {
    	if(plugin.vanishPlayer.containsKey(event.getPlayer().getUniqueId())) {
			VanishPlayer vp = plugin.vanishPlayer.get(event.getPlayer().getUniqueId());
			if(vp.isVanish()) {
				if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
					if(event.getPlayer().getItemInHand().equals(Material.SNOW_BALL) || event.getPlayer().getItemInHand().equals(Material.EGG)) {
						event.setCancelled(true);
					}
				}
			}
		}
	}
	@EventHandler
	public void test(ProjectileLaunchEvent event) {
		if(event.getEntity().getShooter() instanceof Player) {
			Player player = (Player) event.getEntity().getShooter();
			if(plugin.vanishPlayer.containsKey(player.getUniqueId())) {
				VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
				if(vp.isVanish()) {
					event.setCancelled(true);
				}
			}
		}
	}
	
    @EventHandler
	public void PotionThrow(PotionSplashEvent event) {
    	Player player = (Player) event.getPotion().getShooter();
    	if(plugin.vanishPlayer.containsKey(player.getUniqueId())) {
			VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
	 		if (event.getPotion().getShooter() instanceof Player) {
				if(vp.getPotion() == false) {
					event.setCancelled(true);
				}
	    	}
	 	}
	}
}
