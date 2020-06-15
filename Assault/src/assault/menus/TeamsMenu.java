package assault.menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.google.common.collect.Lists;

import assault.exceptions.PlayerInTeamException;
import assault.main.Assault;
import assault.team.Team;
import assault.team.TeamRed;
import assault.utilidad.IconMenu;

public class TeamsMenu {

	private static final int menuSlotsPerRow = 9;
	private static final int menuSize = 9;
	private static final String timeMenuName = "Menú de Equipos";
	private Assault plugin = Assault.getInstance();
	private IconMenu menu;

	public TeamsMenu(final Player jug) {

		int rowCount = menuSlotsPerRow;
		while (rowCount < 18 && rowCount < menuSize) {
			rowCount += menuSlotsPerRow;
		}

		menu = new IconMenu(timeMenuName, rowCount, new IconMenu.OptionClickEventHandler() {
			@Override
			public void onOptionClick(IconMenu.OptionClickEvent event) {
//            	if(TSWMain.getGC().getGame().getState() != GameState.LOBBY) {
//            		event.setWillClose(true);
//                    event.setWillDestroy(true);
//            		return;
//            	}
				Team gtp = plugin.getTC().getTeamByPlayer(event.getPlayer());
				if (gtp != null) {
					gtp.leaveTeam(event.getPlayer());
					event.getPlayer().sendMessage(ChatColor.GREEN + "Saliste del equipo " + gtp.getName() + "!");
				}
				Team teamRed = plugin.getTC().getTeamRed();
				Team teamBlue = plugin.getTC().getTeamBlue();
				if(event.getPosition() == 2)
				{
					if (teamRed != null) {
						ItemStack is = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
			            ItemMeta im = is.getItemMeta();
			            im.setDisplayName(ChatColor.RED + teamRed.getName());
			           
						if (teamRed.isFull()) {
							event.getPlayer().sendMessage(ChatColor.RED + "El equipo esta completo!");
							event.setWillDestroy(false);
						} else {
							try {
								teamRed.joinTeam(event.getPlayer());
								 List<String> loreListRed = getLoreString(teamRed);
						            im.setLore(loreListRed);
						            is.setItemMeta(im);
								event.getPlayer().getInventory().setItem(8, is);
							} catch (PlayerInTeamException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							event.getPlayer()
									.sendMessage(ChatColor.GREEN + "Entraste al equipo " + teamRed.getName() + "!");
							event.setWillClose(true);
						}
					}
					
				}else if(event.getPosition() ==6)
				{
					if (teamBlue != null) {

						ItemStack is = new ItemStack(Material.WOOL, 1, DyeColor.BLUE.getData());
			            ItemMeta im = is.getItemMeta();
			            im.setDisplayName(ChatColor.BLUE + teamBlue.getName());
			            
						if (teamBlue.isFull()) {
							event.getPlayer().sendMessage(ChatColor.RED + "El equipo esta completo!");
							event.setWillDestroy(false);
						} else {
							try {
								teamBlue.joinTeam(event.getPlayer());
								List<String> loreListBlue = getLoreString(teamBlue);
					            im.setLore(loreListBlue);
					            is.setItemMeta(im);
								event.getPlayer().getInventory().setItem(8, is);
							} catch (PlayerInTeamException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							event.getPlayer()
									.sendMessage(ChatColor.GREEN + "Entraste al equipo " + teamBlue.getName() + "!");
							event.setWillClose(true);
						}
					}
				}
				

				

				

			}
		}, plugin, true);

		
		int n = 0;
		Team teamRed = plugin.getTC().getTeamRed();
		Team teamBlue = plugin.getTC().getTeamBlue();
		List<String> loreListRed = getLoreString(teamRed);
		List<String> loreListBlue = getLoreString(teamBlue);
		int statusRed = 0, statusBlue = 0;
		if (teamRed.isFull()) {
			statusRed = 14;
		} else if (teamRed.isEmpty()) {
			statusRed = 5;
		} else {
			statusRed = 4;
		}

		if (teamBlue.isFull()) {
			statusBlue = 14;
		} else if (teamBlue.isEmpty()) {
			statusBlue = 5;
		} else {
			statusBlue = 4;
		}

		menu.setOption(2, new ItemStack(Material.WOOL, teamRed.getPlayers().size(), (short) 14), ChatColor.DARK_RED + "Equipo rojo",
				loreListRed.toArray(new String[loreListRed.size()]));
		
		menu.setOption(6, new ItemStack(Material.WOOL, teamBlue.getPlayers().size(), DyeColor.BLUE.getData()), ChatColor.DARK_BLUE + "Equipo azul",
				loreListBlue.toArray(new String[loreListBlue.size()]));
		loreListRed.clear();
		loreListBlue.clear();
		n++;

		menu.open(jug);
	}

	public List<String> getLoreString(Team t) {
		List<String> loreList = Lists.newLinkedList();
        for(Player p : t.getPlayers())
        {
        	if(t instanceof TeamRed)
        	{

            	loreList.add(ChatColor.RED + p.getName());
        	}else {

            	loreList.add(ChatColor.BLUE + p.getName());
        	}
        }
		
		return loreList;
	}

}
