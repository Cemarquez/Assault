package assault.objective;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class ObjectiveController {
	private ArrayList<Objective> objectives = new ArrayList<Objective>();
	
	
	public ObjectiveController()
	{
		loadLocTest();
	}
	
	public ArrayList<Objective> getObjectives() {
		return objectives;
	}


	public void loadLocTest()
	{
		Location l1 = new Location(Bukkit.getPlayer("cemarquez").getWorld(),-57 , 70, 140);
		
		Location l2 = new Location(Bukkit.getPlayer("cemarquez").getWorld(),-52 , 74, 146);
		
		Objective ob = new Objective(l1, l2);
		
		objectives.add(ob);
		
	}
	
	public void clearObjectives()
	{
		for(Objective o : objectives) {
			for(Block b : o.getBlocksFilled())
			{
				if(b.getType() == Material.BEACON)
				{
					b.setType(Material.WOOL);
				}
			}
		}
	}
	public void setObjectives(ArrayList<Objective> objectives) {
		this.objectives = objectives;
	}
}
