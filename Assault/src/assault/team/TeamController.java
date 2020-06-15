package assault.team;

import org.bukkit.entity.Player;

import assault.exceptions.PlayerInTeamException;

public class TeamController {

	
	private TeamBlue teamBlue;
	private TeamRed  teamRed;
	
	
	public TeamController()
	{
		teamBlue = new TeamBlue("Blue");
		teamRed = new TeamRed("Red");
	}


	public boolean joinFirstEmpty(Player p)
	{
		if(isAlreadyInTeam(p))
		{
			return false;
			
		}
		if(!teamBlue.isFull())
		{
			try {
				teamBlue.joinTeam(p);
				return true;
			} catch (PlayerInTeamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(!teamRed.isFull())
		{
			try {
				teamRed.joinTeam(p);
				return true;
			} catch (PlayerInTeamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public TeamBlue getTeamBlue() {
		return teamBlue;
	}

	public boolean isComplete()
	{
		if(teamBlue.isFull() && teamRed.isFull())
		{
			return true;
		}
		return false;
	}
	public boolean isAlreadyInTeam (Player p)
	{
		if(getTeamByPlayer(p) !=null)
		{
			return true;
		}
		return false;
	}
    public Team getTeamByPlayer(Player p)
    {
    	Team team =null;
    	if(teamBlue.playerIsInTeam(p.getName()))
    	{
    		team = teamBlue;
    	}else if(teamRed.playerIsInTeam(p.getName()))
    	{
    		team = teamRed;
    	}
    	
    	return team;
    }
	public void setTeamBlue(TeamBlue teamBlue) {
		this.teamBlue = teamBlue;
	}


	public TeamRed getTeamRed() {
		return teamRed;
	}


	public void setTeamRed(TeamRed teamRed) {
		this.teamRed = teamRed;
	}
	
	
	
}
