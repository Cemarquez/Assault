package assault.events;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import assault.lobby.LobbyGameController;
import assault.main.Assault;
import assault.menus.TeamsMenu;
import assault.objective.CapturingObjectiveRuntime;
import assault.objective.Objective;
import assault.objective.ObjectiveController;
import assault.team.Team;
import assault.team.TeamBlue;

public class PlayerListener implements Listener{
	
	
	private LobbyGameController lobby = LobbyGameController.getLobby();
	private Assault plugin = Assault.getInstance();
	private HashMap<String, CapturingObjectiveRuntime> runtimes = new HashMap<String, CapturingObjectiveRuntime>();
	
	
	@EventHandler
	public void onInteractue(PlayerInteractEvent e)
	{
		if(e.getItem() !=null)
		{
			if(e.getItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN+"Selector De Equipos"))
			{
				e.setCancelled(true);
				new TeamsMenu(e.getPlayer());
			}
		}
		
	}
	
	@EventHandler
	public void onCaptured(ObjectiveCaptureEvent e)
	{
	   Player p = e.getPlayer();
	   Team t = e.getTeam();
	   
	   if(p!=null && t !=null)
	   {
		   TeamBlue team = (TeamBlue) t;
		   team.addLife(10);
		   Bukkit.broadcastMessage(ChatColor.YELLOW + "El equipo azul ha capturado y se le han sido otorgadas 10 vidad más.");
	   }
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e)
	{
		Player p = e.getPlayer();
		if(playerInObjective(p))
		{
			Objective o = getObjecByPlayer(p);
			o.addPlayerInObje(p);
			addRuntime(p);
		}else {
			removePlayerObjec(p);
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		lobby.prepareForLobby(e.getPlayer(), false);
	}
	public void addRuntime(Player p)
	{
		if(!runtimes.containsKey(p.getName().toLowerCase()))
		{
			runtimes.put(p.getName().toLowerCase(), new CapturingObjectiveRuntime(p));
		}
	}
	
	public Objective getObjecByPlayer(Player p)
	{
		for(Objective o : plugin.getObjectives())
		{
			if(o.playerInArea(p))
			{
				return o;
			}
		}
		
		return null;
	}
	
	public void removePlayerObjec(Player p)
	{
		for(Objective o : plugin.getObjectives())
		{
			if(o.getPlayersInObjec().contains(p))
			{
				o.getPlayersInObjec().remove(p);
			}
		}
	}
	public boolean playerInObjective(Player p )
	{
		for(Objective o : plugin.getObjectives())
		{
			if(o.playerInArea(p))
			{
				return true;
			}
		}
		
		return false;
	}
	
}
