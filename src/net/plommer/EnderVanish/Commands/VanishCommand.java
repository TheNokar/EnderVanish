package net.plommer.EnderVanish.Commands;

import net.plommer.EnderVanish.Utils.PlayerVanish;

public class VanishCommand extends BaseCommand {

	public VanishCommand() {
		bePlayer = true;
		name = "";
		argLength = 0;
		permission = "vanish";
		usage = "To vanish";
	}
	
	@Override
	public boolean execute() {
		PlayerVanish.Vanish(plugin, player);
		return false;
	}

}
