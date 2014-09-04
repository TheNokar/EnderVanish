package net.plommer.EnderVanish.Commands;

import net.plommer.EnderVanish.EnderVanish;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {
	private EnderVanish plugin;
	public CommandHandler(EnderVanish plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
		outer:
		for (BaseCommand command : plugin.commands.toArray(new BaseCommand[0])) {
			String[] cmds = null;
			int cmdl = 0;
			int argl = 0;
			if(args.length > 0) {
				cmds = command.name.split(" ");
				cmdl = cmds.length;
				argl = args.length;
			} else {
				cmdl = 0;
				argl = 1;
			}
			
			for (int i = 0; i < cmdl; i++)
				if (i >= argl || !cmds[i].equalsIgnoreCase(args[i])) continue outer;
			return command.run(plugin, sender, commandLabel, args);
		}
		return true;
	}
}
