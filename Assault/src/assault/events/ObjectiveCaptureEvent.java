package assault.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import assault.main.Assault;
import assault.team.Team;

public class ObjectiveCaptureEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	private Player player;
	private Team team;
	private boolean canceled = false;

	public ObjectiveCaptureEvent(Player p)
	{
		player = p;
		team = Assault.getInstance().getTC().getTeamByPlayer(player);
		
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	
	public static HandlerList getHandlerList() {
		return handlers;
	}

	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return null;
	}

}
