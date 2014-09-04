package net.plommer.EnderVanish.Commands;

import net.plommer.EnderVanish.Utils.PlayerVanish;
import net.plommer.EnderVanish.Utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class VanishOtherCommand extends BaseCommand {

	public VanishOtherCommand() {
		bePlayer = false;
		name = " ";
		argLength = 0;
		permission = "vanish.other";
		usage = " <Player>";
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean execute() {
		if(!args.get(0).isEmpty()) {
			Player pl = Bukkit.getPlayer(args.get(0));
			if(pl != null) {
				PlayerVanish.Vanish(plugin, pl);
			} else {
				Utils.sendMessage(sender, "&eThat player is not online");
			}
			return false;
		}
		return false;
	}

}
