package assault.objective;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import assault.main.Assault;
import assault.team.Team;

public class Objective {
	private ArrayList<Player> playersInObjec = new ArrayList<Player>();
    private ArrayList<Block> blocks = new ArrayList<Block>();
    private ArrayList<Block> blocksFilled = new ArrayList<Block>();
	private Location loc1;
	private Location loc2;
	private boolean captured = false;
	
	
	public Objective(Location l1, Location l2)
	{
		loc1 = l1;
		loc2 = l2;
		fillBlocksFilled();
		fillBlocks();
	}
	
	public Location getLoc1() {
		return loc1;
	}

	public void setLoc1(Location loc1) {
		this.loc1 = loc1;
	}

	public Location getLoc2() {
		return loc2;
	}

	public void setLoc2(Location loc2) {
		this.loc2 = loc2;
	}

	
	public void fillBlocksFilled()
	{
		int x1,x2,y1,y2,z1,z2;
        x1 = loc1.getX() > loc2.getX() ? (int) loc2.getX() : (int) loc1.getX();
        y1 = loc1.getY() > loc2.getY() ? (int) loc2.getY() : (int) loc1.getY();
        z1 = loc1.getZ() > loc2.getZ() ? (int) loc2.getZ() : (int) loc1.getZ();
     
        x2 = ((int) loc1.getX()) == x1 ? (int) loc2.getX() : (int) loc1.getX();
        y2 = ((int) loc1.getY()) == y1 ? (int) loc2.getY() : (int) loc1.getY();
        z2 = ((int) loc1.getZ()) == z1 ? (int) loc2.getZ() : (int) loc1.getZ();
             
        for (int x = x1; x <= x2; x++){
            for (int y = y1; y <= y2; y++){
                for (int z = z1; z <= z2; z++){
                	Location lTemp = new Location(loc1.getWorld(), x, y, z);
                	if((lTemp.getBlock().getType() != Material.AIR && lTemp.getBlock().getType() == Material.WOOL) ||lTemp.getBlock().getType() == Material.BEACON )
                	{

                        blocksFilled.add(lTemp.getBlock());
                	}
                }
            }
        }
        
        
        for(Block b : blocksFilled)
        {
        	b.setType(Material.WOOL);
        }
	}
	
	public ArrayList<Block> getBlocksFilled() {
		return blocksFilled;
	}

	public void setBlocksFilled(ArrayList<Block> blocksFilled) {
		this.blocksFilled = blocksFilled;
	}

	public void fillBlocks()
	{
		 int x1,x2,y1,y2,z1,z2;
	        x1 = loc1.getX() > loc2.getX() ? (int) loc2.getX() : (int) loc1.getX();
	        y1 = loc1.getY() > loc2.getY() ? (int) loc2.getY() : (int) loc1.getY();
	        z1 = loc1.getZ() > loc2.getZ() ? (int) loc2.getZ() : (int) loc1.getZ();
	     
	        x2 = ((int) loc1.getX()) == x1 ? (int) loc2.getX() : (int) loc1.getX();
	        y2 = ((int) loc1.getY()) == y1 ? (int) loc2.getY() : (int) loc1.getY();
	        z2 = ((int) loc1.getZ()) == z1 ? (int) loc2.getZ() : (int) loc1.getZ();
	             
	        for (int x = x1; x <= x2; x++){
	            for (int y = y1; y <= y2; y++){
	                for (int z = z1; z <= z2; z++){
	                	Location lTemp = new Location(loc1.getWorld(), x, y, z);
	                    blocks.add(lTemp.getBlock());
	                }
	            }
	        }
	     
	}
	public boolean playerInArea(Player p){
        int x1,x2,y1,y2,z1,z2;
        x1 = loc1.getX() > loc2.getX() ? (int) loc2.getX() : (int) loc1.getX();
        y1 = loc1.getY() > loc2.getY() ? (int) loc2.getY() : (int) loc1.getY();
        z1 = loc1.getZ() > loc2.getZ() ? (int) loc2.getZ() : (int) loc1.getZ();
     
        x2 = ((int) loc1.getX()) == x1 ? (int) loc2.getX() : (int) loc1.getX();
        y2 = ((int) loc1.getY()) == y1 ? (int) loc2.getY() : (int) loc1.getY();
        z2 = ((int) loc1.getZ()) == z1 ? (int) loc2.getZ() : (int) loc1.getZ();
             
        for (int x = x1; x <= x2; x++){
            for (int y = y1; y <= y2; y++){
                for (int z = z1; z <= z2; z++){
                        if (p.getWorld().getBlockAt(p.getLocation()).equals(loc1.getWorld().getBlockAt(new Location(loc1.getWorld(),x,y,z)))) 
                        {
                        	
                        	return true;
                        }
                        	
                    
                }
            }
        }
     
        return false;
    }

	public ArrayList<Player> getPlayersInObjec() {
		return playersInObjec;
	}

	public void addPlayerInObje (Player p)
	{
		if(p!=null)
		{
			if(!playersInObjec.contains(p))
			{
				playersInObjec.add(p);
			}
		}
	}
	
	public void removePlayerInObje(Player p)
	{
		if(playersInObjec.contains(p))
		{
			playersInObjec.remove(p);
		}
	}
	
	
	public boolean teamBlueInObj() {
		
		if(diferentTeamInObj())
		{

			return false;
		}
		
		for(Player p : playersInObjec)
		{
			Team t =Assault.getInstance().getTC().getTeamByPlayer(p);
			if(t!=null)
			{
				if(t.getName().equalsIgnoreCase("blue"))
					return true;
				
			}
		}
		
		return false;
	}
	public boolean diferentTeamInObj()
	{
		for(int i=0;i<playersInObjec.size();i++)
		{
			for(int j=0;j<playersInObjec.size();j++)
			{
				Player p1 = playersInObjec.get(i);
				Player p2 = playersInObjec.get(j);
				
				Team t1 = Assault.getInstance().getTC().getTeamByPlayer(p1);
				Team t2 = Assault.getInstance().getTC().getTeamByPlayer(p2);
				
				if(p1 !=null && p2 !=null)
				{
					if(t1 !=null && t2!=null) {
						if(!(t1.getName().equalsIgnoreCase(t2.getName())))
						{
							return true;
						}
					}
				}
			}
		}
		
		
		return false;
	}
	
	
	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(ArrayList<Block> blocks) {
		this.blocks = blocks;
	}

	public void setPlayersInObjec(ArrayList<Player> playersInObjec) {
		this.playersInObjec = playersInObjec;
	}

	public boolean isCaptured() {
		return captured;
	}

	public void setCaptured(boolean captured) {
		this.captured = captured;
	}
}
