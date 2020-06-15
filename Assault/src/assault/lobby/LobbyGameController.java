package assault.lobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import assault.utilidad.ItemUtils;

public class LobbyGameController {
	
	private static LobbyGameController Lobby = null;
	private int startinglobby = 30;
	public static ItemUtils kits = new ItemUtils(Material.BOW, (short) 0, 1, ChatColor.GREEN+"Kits", ChatColor.GRAY+"Click para seleccionar tu kit");
	public static ItemUtils teamselector = new ItemUtils(Material.WOOL, (short) 9, 1, ChatColor.GREEN+"Selector De Equipos", ChatColor.GRAY+"Click para seleccionar equipo");
	
	
	public void prepareForLobby(Player p, boolean teleport)
	{
		p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.setFlying(false);
		p.setAllowFlight(false);
		p.setFireTicks(0);
		p.setFoodLevel(20);
		p.setHealth(20D);
		p.setGameMode(GameMode.SURVIVAL);
    	//Online.getInventory().setItem(TSWMain.getCfg().getLobbyMenuSlot(), TSWMain.getCfg().getLobbyMenuItem());
		for (PotionEffect effect : p.getActivePotionEffects()) {
			p.removePotionEffect(effect.getType());
		}
		p.getInventory().setItem(0, kits);
		p.getInventory().setItem(1, teamselector);
	}
	
	public static LobbyGameController getLobby() {
		if(Lobby == null) {
			Lobby = new LobbyGameController();
		}
		
			return Lobby;
	}
}
