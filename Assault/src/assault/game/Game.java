package assault.game;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;


import assault.main.Assault;
import assault.team.Team;



public class Game {

	public enum GameState {
		RUNNING, WAITING, STTOPED
	}
	private GameState state;
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Player> spectators = new ArrayList<Player>();
    private HashMap<String, Integer> kills = new HashMap<String, Integer>();
    private String mapName;
    private Assault plugin = Assault.getInstance();
	private int minPlayers=8;
	private int maxPlayers = 24;
	
	public Game(String map)
	{
		this.mapName = map;
	}
	
	
	public void addPlayer(Player j, boolean pregame) {
		if (players.contains(j)) {
			players.remove(j);
			spectateMode(j, getSpawn());
			return;
		}
		j.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		if ((plugin.getTC().isComplete() && !plugin.getTC().isAlreadyInTeam(j)) || state == GameState.RUNNING || state == GameState.STTOPED) {
			spectateMode(j, getSpawn());
		} else if(plugin.getTC().joinFirstEmpty(j)) {
			if (j != null) {
				players.add(j);
				kills.put(j.getName(), 0);
				preparePlayerForPreGame(j, pregame);
			}
		} else {
			spectateMode(j, getSpawn());
		}
	}
	
	private void preparePlayerForPreGame(final Player jug, final boolean pregame) {
		if(jug.getGameMode() != GameMode.SURVIVAL) {
			jug.setGameMode(GameMode.SURVIVAL);
		}
		
		Team gt = plugin.getTC().getTeamByPlayer(jug);
		Location spawnloc = gt.getSpawn();
		
		if(!spawnloc.getChunk().isLoaded()) {
			spawnloc.getChunk().load();
		}
		final Location location = new Location(spawnloc.getWorld(), spawnloc.getX() + 0.5, spawnloc.getY() + 1,spawnloc.getZ() + 0.5);

		
		
			jug.teleport(location);
		
	}
	public void spectateMode(final Player jug, Location location) {
		if (jug != null) {
			addSpectator(jug);
			jug.setFoodLevel(20);
			if (jug.getLocation().getWorld() != location.getWorld())
				jug.teleport(location);
			jug.getInventory().clear();
			Bukkit.getScheduler().runTaskLater(Assault.getInstance(), new Runnable() {
				@Override
				public void run() {
					jug.setGameMode(GameMode.SPECTATOR);
					jug.setAllowFlight(true);
					jug.setFlying(true);
					jug.setFlySpeed(0.2f);
					jug.setWalkSpeed(0.2f);
					}
			}, 1L);
		}
	}
	public GameState getState() {
		return state;
	}
	
	public void addSpectator(Player jug) {
		if (players.contains(jug))
			players.remove(jug);

		if (!spectators.contains(jug))
			spectators.add(jug);
	}

	public Location getSpawn() {
		return null;
	}
	public void setState(GameState state) {
		this.state = state;
	}
}
