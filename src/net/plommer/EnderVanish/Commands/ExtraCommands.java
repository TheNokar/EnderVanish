package net.plommer.EnderVanish.Commands;

import net.plommer.EnderVanish.Utils.Utils;
import net.plommer.EnderVanish.Utils.VanishPlayer;

public class ExtraCommands extends BaseCommand {

	public ExtraCommands() {
		bePlayer = true;
		name = "extra";
		argLength = 1;
		permission = "vanish.extra";
		usage = "enable and disable those extra stuff!";
	}
	
	@Override
	public boolean execute() {
		System.out.print("TEST");
		String s = args.get(0);
		if(plugin.vanishPlayer.containsKey(player.getUniqueId())) {
			VanishPlayer vp = plugin.vanishPlayer.get(player.getUniqueId());
			if(s.equalsIgnoreCase("block") || s.equalsIgnoreCase("b")) {
				String whuut = null;
				if(vp.getBlock() == true) {
					whuut = "disabled";
					vp.setBlock(false);
				} else {
					whuut = "enabled";
					vp.setBlock(true);
				}
				Utils.sendMessage(sender, "&eYou have " + whuut + " block interacting!");
			} else if(s.equalsIgnoreCase("silentchest") || s.equalsIgnoreCase("sc")) {
				String whuut = null;
				if(vp.getSilentChest() == true) {
					whuut = "disabled";
					vp.setSilentChest(false);
				} else {
					whuut = "enabled";
					vp.setSilentChest(true);
				}
				Utils.sendMessage(sender, "&eYou have " + whuut + " silent chests!");
			} else if(s.equalsIgnoreCase("joinvanish") || s.equalsIgnoreCase("jv")) {
				String whuut = null;
				if(vp.getJoinVanish() == true) {
					whuut = "disabled";
					vp.setJoinVanish(false);
				} else {
					whuut = "enabled";
					vp.setJoinVanish(true);
				}
				Utils.sendMessage(sender, "&eYou have " + whuut + " joining vanished!");
			} else if(s.equalsIgnoreCase("bow")) {
				String whuut = null;
				if(vp.getBow() == true) {
					whuut = "disabled";
					vp.setBow(false);
				} else {
					whuut = "enabled";
					vp.setBow(true);
				}
				Utils.sendMessage(sender, "&eYou have " + whuut + " bowing!");
			} else if(s.equalsIgnoreCase("bow")) {
				String whuut = null;
				if(vp.getBow() == true) {
					whuut = "disabled";
					vp.setBow(false);
				} else {
					whuut = "enabled";
					vp.setBow(true);
				}
				Utils.sendMessage(sender, "&eYou have " + whuut + " bowing!");
			} else if(s.equalsIgnoreCase("godmode") || s.equalsIgnoreCase("god")) {
				String whuut = null;
				if(vp.getGodMode() == true) {
					whuut = "disabled";
					vp.setGodMode(false);
				} else {
					whuut = "enabled";
					vp.setGodMode(true);
				}
				Utils.sendMessage(sender, "&eYou have " + whuut + " god mode!");
			} else if(s.equalsIgnoreCase("potions") || s.equalsIgnoreCase("potion") || s.equalsIgnoreCase("pot")) {
				String whuut = null;
				if(vp.getPotion() == true) {
					whuut = "disabled";
					vp.setPotion(false);
				} else {
					whuut = "enabled";
					vp.setPotion(true);
				}
				Utils.sendMessage(sender, "&eYou have " + whuut + " potions!");
			}
		} else {
			Utils.sendMessage(sender, "&cYou have to vanish first!");
		}
		return false;
	}
	
}
