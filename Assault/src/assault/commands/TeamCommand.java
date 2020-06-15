package assault.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import assault.exceptions.PlayerInTeamException;
import assault.main.Assault;

public class TeamCommand implements CommandExecutor{

	private Assault plugin = Assault.getInstance();
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player p = (Player) sender;
		if(args[0].equalsIgnoreCase("red")) {
			try {
				plugin.getTC().getTeamRed().joinTeam(p);
			} catch (PlayerInTeamException e) {
				
				e.printStackTrace();
			}
			
			return true;
		}else {
			try {
				plugin.getTC().getTeamBlue().joinTeam(p);
			} catch (PlayerInTeamException e) {
				
				e.printStackTrace();
			}
		}
		
		return false;
	}

}
