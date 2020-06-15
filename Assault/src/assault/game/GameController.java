package assault.game;


public class GameController {

private Game game = null;
	
	public Game createGame() {
		Game game = new Game("");
		this.game = game;
		return game;
	}
	
	public void deleteGame() {
		game = null;
	}
	
	public void shutdown() {
		game.shutdown();
		game = null;
	 }
	 
	 public Game getGame() {
		 return game;
	 }
	 
    
}
