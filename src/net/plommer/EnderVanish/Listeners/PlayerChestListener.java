package net.plommer.EnderVanish.Listeners;

import net.plommer.EnderVanish.EnderVanish;
import net.plommer.EnderVanish.Utils.Inventorys;
import net.plommer.EnderVanish.Utils.VanishPlayer;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerChestListener implements Listener {
	EnderVanish plugin;
	public PlayerChestListener(EnderVanish endervanish) {
        plugin = endervanish;
    }
	private boolean chestOpen = false;
	
	@EventHandler
    public void onPlayerInteract(final PlayerInteractEvent event) {
		Block block = event.getClickedBlock();
		if(plugin.vanishPlayer.containsKey(event.getPlayer().getUniqueId())) {
			VanishPlayer vp = plugin.vanishPlayer.get(event.getPlayer().getUniqueId());
			if(vp.isVanish() == true) {
				if(vp.getSilentChest() == true) {
					if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
		    			BlockState state = block.getState();
		    			Location loc = block.getLocation();
		    			Block xplus = loc.getWorld().getBlockAt(loc.getBlockX()+1,loc.getBlockY(), loc.getBlockZ());
		    			Block xneg = loc.getWorld().getBlockAt(loc.getBlockX()-1,loc.getBlockY(), loc.getBlockZ());
		    			Block zplus = loc.getWorld().getBlockAt(loc.getBlockX(),loc.getBlockY(), loc.getBlockZ()+1);
		    			Block zneg = loc.getWorld().getBlockAt(loc.getBlockX(),loc.getBlockY(), loc.getBlockZ()-1);
		    			if(xplus.getType() == Material.CHEST) {
		    				event.setCancelled(true);
		    				Chest chest1 = (Chest) xplus.getState();
		    				Chest chest2 = (Chest) block.getState(); 
		    				Inventory inv = Inventorys.chestBig(event.getPlayer());
		    				ItemStack[] item1 = chest1.getInventory().getContents();
		    				ItemStack[] item2 = chest2.getInventory().getContents();
		    				inv.setContents(item1);
		    				inv.setContents(item2);
		    				event.getPlayer().openInventory(inv);
		    			} else if(xneg.getType() == Material.CHEST) {
		    				event.setCancelled(true);
		    				Chest chest1 = (Chest) xneg.getState();
		    				Chest chest2 = (Chest) block.getState(); 
		    				Inventory inv = Inventorys.chestBig(event.getPlayer());
		    				ItemStack[] item1 = chest1.getInventory().getContents();
		    				ItemStack[] item2 = chest2.getInventory().getContents();
		    				inv.setContents(item1);
		    				inv.setContents(item2);
		    				event.getPlayer().openInventory(inv);
		    			} else if(zplus.getType() == Material.CHEST) {
		    				event.setCancelled(true);
		    				Chest chest1 = (Chest) zplus.getState();
		    				Chest chest2 = (Chest) block.getState(); 
		    				Inventory inv = Inventorys.chestBig(event.getPlayer());
		    				ItemStack[] item1 = chest1.getInventory().getContents();
		    				ItemStack[] item2 = chest2.getInventory().getContents();
		    				inv.setContents(item1);
		    				inv.setContents(item2);
		    				event.getPlayer().openInventory(inv);
		    			} else if(zneg.getType() == Material.CHEST) {
		    				event.setCancelled(true);
		    				Chest chest1 = (Chest) zneg.getState();
		    				Chest chest2 = (Chest) block.getState(); 
		    				Inventory inv = Inventorys.chestBig(event.getPlayer());
		    				ItemStack[] item1 = chest1.getInventory().getContents();
		    				ItemStack[] item2 = chest2.getInventory().getContents();
		    				inv.setContents(item1);
		    				inv.setContents(item2);
		    				event.getPlayer().openInventory(inv);
		    			} else if(state instanceof Chest) {
		    				event.setCancelled(true);
		    				Chest chest = (Chest) block.getState();
		    				Inventory inv = Inventorys.chestSmall(event.getPlayer());
		    				ItemStack[] item = chest.getInventory().getContents();
		    				inv.setContents(item);
		    				event.getPlayer().openInventory(inv);
		    			}
		    			chestOpen = true;
		    		}
				}
			}
		}
	}
	
	@EventHandler
	public void closeInv(InventoryCloseEvent event) {
		if(plugin.vanishPlayer.containsKey(event.getPlayer().getUniqueId())) {
			if(chestOpen == true) {
				chestOpen = false;
			} else {return;}
		}
	}
	
	@EventHandler
	public void invTest(InventoryClickEvent event) {
		if(plugin.vanishPlayer.containsKey(event.getWhoClicked().getUniqueId())) {
			if(chestOpen == true) {
				event.setCancelled(true);
			} else {return;}
		}
	}
}
