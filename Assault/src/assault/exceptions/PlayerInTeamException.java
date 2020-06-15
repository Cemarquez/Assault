package assault.exceptions;

@SuppressWarnings("serial")
public class PlayerInTeamException extends Exception {

	public PlayerInTeamException(String n)
	{
		super(n);
	}
}
