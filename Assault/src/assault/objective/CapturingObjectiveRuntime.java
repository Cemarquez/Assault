package assault.objective;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import assault.events.ObjectiveCaptureEvent;
import assault.main.Assault;
import assault.team.TeamBlue;

public class CapturingObjectiveRuntime {

	private ArrayList<Integer> numbersRandom = new ArrayList<Integer>();
	private Assault plugin = Assault.getInstance();
	private Player p;
	private int con=0;
	private Objective lastObje;
	public CapturingObjectiveRuntime(Player p)
	{
		this.p = p;
		
		
		Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
			
			@Override
			public void run() {
				Objective obj = getObjecByPlayer(p);
				if(obj !=null)
				{
					lastObje = obj;
					if(!obj.isCaptured())
					{
						if(obj.teamBlueInObj())
						{
							if(con<obj.getBlocksFilled().size())
							{
								int ran = getNumberRandom(obj);
								if(obj.getBlocksFilled().get(ran).getType() != Material.AIR && obj.getBlocksFilled().get(ran).getType() == Material.WOOL)
								{
									obj.getBlocksFilled().get(ran).setType(Material.BEACON);
									
								}
								con++;
								if(con == obj.getBlocksFilled().size())
                 				{
	                                 obj.setCaptured(true);
	                                 TeamBlue team = (TeamBlue) plugin.getTC().getTeamByPlayer(p);
	                      		     team.addLife(10);
	                      		     Bukkit.broadcastMessage(ChatColor.YELLOW + "El equipo azul ha capturado un objetivo y se le han sido otorgadas 10 vidas más.");
								}
							}
						}else {
							con =0;
							numbersRandom.clear();
							for(Block b : obj.getBlocksFilled())
							{
								if(b.getType()!= Material.AIR && b.getType() == Material.BEACON)
								{
									b.setType(Material.WOOL);
								}
							}
						}
					}
					
				}else {
					
					if(!lastObje.isCaptured())
					{
						con=0;
						numbersRandom.clear();
						for(Block b : lastObje.getBlocksFilled())
						{
							if(b.getType() == Material.BEACON)
							{
								b.setType(Material.WOOL);
							}
						}
					}
						
				}
				
			}
		
		}, 10, 10);
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
	
	public int getNumberRandom(Objective obj)
	{
		int num=0;
		Random random = new Random();
		int nex = random.nextInt(obj.getBlocksFilled().size());
		
		for(int i=0;i<obj.getBlocksFilled().size();i++)
		{
			nex = random.nextInt(obj.getBlocksFilled().size());
			
			while(numbersRandom.contains(nex))
			{
				nex = random.nextInt(obj.getBlocksFilled().size());
			}
			
		}
		numbersRandom.add(nex);
		num = nex;
		return num;
	}
	public boolean playerInObjective(Player p )
	{
		for(Objective o : plugin.getObjectives())
		{
			if(o.playerInArea(p))
			{
				p.sendMessage("estás en el obj");
				return true;
			}
		}
		
		return false;
	}
}
