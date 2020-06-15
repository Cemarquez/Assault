package assault.team;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import assault.exceptions.PlayerInTeamException;
import net.md_5.bungee.api.ChatColor;

public abstract class Team {

	protected Location spawn;
	protected ArrayList<Player> players = new ArrayList<Player>();

	protected String name = "";

	public void joinTeam(Player p) throws PlayerInTeamException {
		if (playerIsInTeam(p.getName())) {
			throw new PlayerInTeamException("Este jugador ya se encuentra en el equipo");
		} else {
			players.add(p);
			sendMessageTeam(ChatColor.YELLOW + "El jugador " + p.getName() + " ha entrado al equipo. " + name);
		}
	}

	public void leaveTeam(Player p) {
		if (players.contains(p)) {
			players.remove(p);
		}

	}

	public Location getSpawn() {
		return spawn;
	}

	public void setSpawn(Location spawn) {
		this.spawn = spawn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEmpty() {
		if (players.size() == 0) {
			return true;
		}

		return false;
	}

	public boolean isFull() {
		if (players.size() >= 12) {
			return true;
		}

		return false;
	}

	public void sendMessageTeam(String msg) {
		for (Player p : players) {
			if (p != null) {
				p.sendMessage(msg);
			}
		}
	}

	public boolean playerIsInTeam(String name) {
		boolean is = false;

		for (Player p : players) {
			if (p != null) {
				if (p.getName().equals(name)) {
					is = true;
				}
			}

		}

		return is;
	}

	public Team(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

}
