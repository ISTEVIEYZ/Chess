package chess;

/**
 * Entry point
 * @author Stephen Eisen
 * @author Arthur Quintanilla
 */

public class Chess {
	
	public static void main(String[] args)
	{
		GameManager game = new GameManager();
		
		game.startGame();
		while (game.update());
		
	}
}
