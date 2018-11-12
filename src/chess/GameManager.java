package chess;

import java.util.Scanner;
import chess.models.*;
import chess.utilities.*;

/**
 * Controls the overall state of the game and keeps the chessboard updated
 * @author Stephen Eisen
 * @author Arthur Quintanilla
 */

public class GameManager
{	
	/**
	 * The current turn number of the game
	 */
	public static int turnNo;
	
	/**
	 * The current location of the black king
	 */
	public static BoardLocation bKingLoc;
	
	/**
	 * The current location of the white king
	 */
	public static BoardLocation wKingLoc;
	
	/**
	 * Signifies if there is a king in check
	 */
	public static boolean check = false;
	
	/**
	 * Color of the winner after a checkmate
	 */
	public static ChessColor winner = null;
	
	/**
	 * Checks if a draw was recently offered
	 */
	public static boolean drawOffered = false;
	
	/**
	 * The current ChessBoard object being used 
	 */
	private ChessBoard chessBoard;
	
	/**
	 * The current turn represented as a color
	 */
	private ChessColor turnColor;
	
	/**
	 * Construsts a GameManager object
	 */
	public GameManager()
	{
		turnNo = 0;
		chessBoard = new ChessBoard();
		turnColor = ChessColor.WHITE;
	}
	
	/** 
	 * Prints the message "Game Start"
	 */
	public void startGame()
	{
		System.out.println("Game Start\n");
		System.out.println(chessBoard.toString());
	}
	
	/**
	 * Updates the state of the game and board
	 * Returns true if the game is still running
	 * @return boolean value that determines the current state of the game
	 */
	public boolean update()
	{
		turnNo++;
		
		Scanner in = new Scanner(System.in);
		
		if (check)
		{
			System.out.println("Check\n");
		}
		
		if (winner != null)
		{
			System.out.println("Checkmate");
			System.out.println(turnColor == ChessColor.WHITE ? "Black wins" : "White wins");
			return false;
		}
		
		System.out.print((turnColor == ChessColor.WHITE ? "White" : "Black") + "'s turn: ");
		String cmd = in.nextLine();
		String[] locs = cmd.split(" ");
		
		if (locs.length == 2)
		{
			drawOffered = false;
			
			char srcFile = locs[0].charAt(0);
			int srcRank = Integer.parseInt("" + locs[0].charAt(1));
			BoardLocation srcLoc = new BoardLocation(srcFile, srcRank);
			
			char destFile = locs[1].charAt(0);
			int destRank = Integer.parseInt("" + locs[1].charAt(1));
			BoardLocation destLoc = new BoardLocation(destFile, destRank);
			
			boolean validMoveMade = chessBoard.movePiece(srcLoc, destLoc, turnColor);
			
			if (validMoveMade) 
			{
				System.out.println(chessBoard.toString());
				switchTurn();
			}
		}
		else if (locs.length == 1)
		{
			if (locs[0].equals("resign"))
			{
				System.out.println(turnColor == ChessColor.WHITE ? 
						"White player resigned.\nBlack Wins." : 
						"Black player resigned.\nWhite Wins.");
				return false;
			}
			else if (drawOffered && locs[0].equals("draw"))
			{
				System.out.println("Draw");
				return false;
			}
		}
		else if (locs.length == 3)
		{
			drawOffered = false;
			
			char srcFile = locs[0].charAt(0);
			int srcRank = Integer.parseInt("" + locs[0].charAt(1));
			BoardLocation srcLoc = new BoardLocation(srcFile, srcRank);
			
			char destFile = locs[1].charAt(0);
			int destRank = Integer.parseInt("" + locs[1].charAt(1));
			BoardLocation destLoc = new BoardLocation(destFile, destRank);
			
			boolean validMoveMade = chessBoard.movePiece(srcLoc, destLoc, turnColor);
			
			if (validMoveMade) 
			{
				System.out.println(chessBoard.toString());
				switchTurn();
				
				if (locs[2].equals("draw?"))
				{
					drawOffered = true;
				}
			}
		}
		else
		{
			System.out.println("Illegal command. Try again.");
		}
		
		return true;
	}
	
	/**
	 * Switches the player turn when a valid move is made
	 */
	private void switchTurn()
	{
		if (turnColor == ChessColor.WHITE)
		{
			turnColor = ChessColor.BLACK;
		}
		else
		{
			turnColor = ChessColor.WHITE;
		}
	}
}
