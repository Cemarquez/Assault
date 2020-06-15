package assault.team;

public class TeamBlue extends Team {
	
	private int reamingLives;
	public TeamBlue(String name) {
		super(name);

		setReamingLives(35);
	}
	
    public void addLife(int cantidad)
    {
    	reamingLives+=cantidad;
    }
    
    public void removeLife()
    {
    	reamingLives--;
    }
	public int getReamingLives() {
		return reamingLives;
	}
	public void setReamingLives(int reamingLives) {
		this.reamingLives = reamingLives;
	}

}
