package assault.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import assault.commands.TeamCommand;
import assault.events.LobbyListener;
import assault.events.PlayerListener;
import assault.objective.Objective;
import assault.objective.ObjectiveController;
import assault.team.TeamController;

public class Assault extends JavaPlugin{

	private static ObjectiveController OC;
	private static TeamController tc;
	private static Assault instance;
	public void onEnable() {
		OC = new ObjectiveController();
		tc = new TeamController();
		instance = this;
		getCommand("team").setExecutor(new TeamCommand());
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		getServer().getPluginManager().registerEvents(new LobbyListener(), this);
		
	}
	
	
	
	
	public static Assault getInstance()
	{
		if (instance ==null)
		{
			instance = new Assault();
			return instance;
		}
		
		return instance;
	}

	public ObjectiveController getOC()
	{
		return OC;
	}
	
	public ArrayList<Objective> getObjectives() {
		return OC.getObjectives();
	}
    public TeamController getTC()
    {
    	return tc;
    }
	
}
