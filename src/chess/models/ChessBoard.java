package chess.models;

import chess.GameManager;
import chess.models.pieces.*;
import java.util.Scanner;
/**
 * The ChessBoard object controls the current state of the game as well as
 * all logic that can take place by each individual unit
 * @author Stephen Eisen
 * @author Arthur Quintanilla
 */

public class ChessBoard
{
	/**
	 * 2D array of all board locations and pieces associated with them
	 */
	private BoardLocation[][] locations;
	
	/**
	 * Constructs a ChessBoard object
	 */
	public ChessBoard()
	{
		locations = new BoardLocation[8][8];
		
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				locations[i][j] = new BoardLocation((char)(61 + j), i); //wrong - fix .. convert int to relevant char
			}
		}
		
		locations[0][0].setPiece(new Rook(ChessColor.BLACK));
		locations[0][1].setPiece(new Knight(ChessColor.BLACK));
		locations[0][2].setPiece(new Bishop(ChessColor.BLACK));
		locations[0][3].setPiece(new Queen(ChessColor.BLACK));
		locations[0][4].setPiece(new King(ChessColor.BLACK));
		locations[0][5].setPiece(new Bishop(ChessColor.BLACK));
		locations[0][6].setPiece(new Knight(ChessColor.BLACK));
		locations[0][7].setPiece(new Rook(ChessColor.BLACK));
		locations[1][0].setPiece(new Pawn(ChessColor.BLACK));
		locations[1][1].setPiece(new Pawn(ChessColor.BLACK));
		locations[1][2].setPiece(new Pawn(ChessColor.BLACK));
		locations[1][3].setPiece(new Pawn(ChessColor.BLACK));
		locations[1][4].setPiece(new Pawn(ChessColor.BLACK));
		locations[1][5].setPiece(new Pawn(ChessColor.BLACK));
		locations[1][6].setPiece(new Pawn(ChessColor.BLACK));
		locations[1][7].setPiece(new Pawn(ChessColor.BLACK));
		
		locations[6][0].setPiece(new Pawn(ChessColor.WHITE));
		locations[6][1].setPiece(new Pawn(ChessColor.WHITE));
		locations[6][2].setPiece(new Pawn(ChessColor.WHITE));
		locations[6][3].setPiece(new Pawn(ChessColor.WHITE));
		locations[6][4].setPiece(new Pawn(ChessColor.WHITE));
		locations[6][5].setPiece(new Pawn(ChessColor.WHITE));
		locations[6][6].setPiece(new Pawn(ChessColor.WHITE));
		locations[6][7].setPiece(new Pawn(ChessColor.WHITE));
		locations[7][0].setPiece(new Rook(ChessColor.WHITE));
		locations[7][1].setPiece(new Knight(ChessColor.WHITE));
		locations[7][2].setPiece(new Bishop(ChessColor.WHITE));
		locations[7][3].setPiece(new Queen(ChessColor.WHITE));
		locations[7][4].setPiece(new King(ChessColor.WHITE));
		locations[7][5].setPiece(new Bishop(ChessColor.WHITE));
		locations[7][6].setPiece(new Knight(ChessColor.WHITE));
		locations[7][7].setPiece(new Rook(ChessColor.WHITE));
		
		GameManager.wKingLoc = new BoardLocation('e', 1);
		GameManager.bKingLoc = new BoardLocation('e', 8);
		
		
	}
	
	/**
	 * Checks whether a king of a given color is in check
	 * @param kingColor The color of the king to be checked
	 * @return boolean value signifying check
	 */
	public boolean isInCheck(ChessColor kingColor)
	{
		int ki;
		int kj;
		
		
		if (kingColor == ChessColor.WHITE)
		{
			ki = 8 - GameManager.wKingLoc.getRank();
			kj = (int)GameManager.wKingLoc.getFile() - 97;
		}
		else
		{
			ki = 8 - GameManager.bKingLoc.getRank();
			kj = (int)GameManager.bKingLoc.getFile() - 97;
		}
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (locations[i][j].hasPiece() && locations[i][j].getPiece().getColor() != kingColor)
					if (locations[i][j].getPiece().moveIsValid(i, j, ki, kj, locations))
					{
						return true;
					}
			}
		}
		return false;
	}
	
	/**
	 * Temporarily moves a piece to determine if its displacement will result in the king being put in check
	 * @param i The rank of the piece to be tested
	 * @param j The file of the piece to be tested
	 * @param kingColor The color of the king to check
	 * @return boolean value signifying check
	 */
	public boolean testCheck(int i, int j, ChessColor kingColor)
	{
		boolean isInCheck = false;
		int ki;
		int kj;
		
		if (kingColor == ChessColor.WHITE)
		{
			ki = 8 - GameManager.wKingLoc.getRank();
			kj = (int)GameManager.wKingLoc.getFile() - 97;
		}
		else
		{
			ki = 8 - GameManager.bKingLoc.getRank();
			kj = (int)GameManager.bKingLoc.getFile() - 97;
		}
		
		if (kingColor == ChessColor.WHITE)
		{
			GameManager.wKingLoc.setLocation((char)(97 + j), 8 - i);
		}
		else
		{
			GameManager.bKingLoc.setLocation((char)(97 + j), 8 - i);
		}
		
		// do the thing
		isInCheck = isInCheck(kingColor);
		
		if (kingColor == ChessColor.WHITE)
		{
			GameManager.wKingLoc.setLocation((char)(97 + kj), 8 - ki);
		}
		else
		{
			GameManager.bKingLoc.setLocation((char)(97 + kj), 8 - ki);
		}
	
		return isInCheck;
	}
	
	/**
	 * Determines whether a player has put the other player in Checkmate
	 * @param kingColor The color of the king to be checked
	 * @return boolean value signifying checkmate
	 */
	public boolean isInCheckmate(ChessColor kingColor)
	{
		int ki;
		int kj;
		
		if (kingColor == ChessColor.WHITE)
		{
			ki = 8 - GameManager.wKingLoc.getRank();
			kj = (int)GameManager.wKingLoc.getFile() - 97;
		}
		else
		{
			ki = 8 - GameManager.bKingLoc.getRank();
			kj = (int)GameManager.bKingLoc.getFile() - 97;
		}
		
		// Check if king can move himself out
		if (locations[ki][kj].getPiece().moveIsValid(ki, kj, ki + 1, kj + 1, locations))
		{
			if (!testCheck(ki + 1, kj + 1, kingColor)) return false;
		}
		if (locations[ki][kj].getPiece().moveIsValid(ki, kj, ki + 1, kj - 1, locations))
		{
			if (!testCheck(ki + 1, kj - 1, kingColor)) return false;
		}
		if (locations[ki][kj].getPiece().moveIsValid(ki, kj, ki - 1, kj - 1, locations))
		{
			if (!testCheck(ki - 1, kj - 1, kingColor)) return false;
		}
		if (locations[ki][kj].getPiece().moveIsValid(ki, kj, ki - 1, kj + 1, locations))
		{
			if (!testCheck(ki - 1, kj + 1, kingColor)) return false;
		}
		if (locations[ki][kj].getPiece().moveIsValid(ki, kj, ki, kj - 1, locations))
		{
			if (!testCheck(ki, kj - 1, kingColor)) return false;
		}
		if (locations[ki][kj].getPiece().moveIsValid(ki, kj, ki, kj + 1, locations))
		{
			if (!testCheck(ki, kj + 1, kingColor)) return false;
		}
		if (locations[ki][kj].getPiece().moveIsValid(ki, kj, ki + 1, kj, locations))
		{
			if (!testCheck(ki + 1, kj, kingColor)) return false;
		}
		if (locations[ki][kj].getPiece().moveIsValid(ki, kj, ki - 1, kj, locations))
		{
			if (!testCheck(ki - 1, kj, kingColor)) return false;
		}
		
        // Check if an ally can block the check on the king
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                for (int k = 0; k < 8; k++)
                {
                    for (int l = 0; l < 8; l++)
                    {
                        if (locations[i][j].hasPiece() && locations[i][j].getPiece().getColor() == kingColor)
                        {
                            if (locations[i][j].getPiece().moveIsValid(i, j, k, l, locations))
                            {
                                ChessPiece temp = locations[i][j].getPiece();
                                
                                if (temp instanceof King)
                                {
                                    if (kingColor == ChessColor.WHITE)
                                    {
                                        GameManager.wKingLoc.setLocation((char)(97 + l), 8 - k);
                                    }
                                    else
                                    {
                                        GameManager.bKingLoc.setLocation((char)(97 + l), 8 - k);
                                    }
                                }
                                
                                locations[k][l].setPiece(temp);
                                locations[i][j].setPiece(null);
                                
                                if (!isInCheck(kingColor))
                                {
                                    System.out.println("" + i + j + k + l);
                                    locations[k][l].setPiece(null);
                                    locations[i][j].setPiece(temp);
                                    
                                    if (temp instanceof King)
                                    {
                                        if (kingColor == ChessColor.WHITE)
                                        {
                                            GameManager.wKingLoc.setLocation((char)(97 + kj), 8 - ki);
                                        }
                                        else
                                        {
                                            GameManager.bKingLoc.setLocation((char)(97 + kj), 8 - ki);
                                        }    
                                    }
                                    return false;
                                }
                                
                                if (temp instanceof King)
                                {
                                    if (kingColor == ChessColor.WHITE)
                                    {
                                        GameManager.wKingLoc.setLocation((char)(97 + kj), 8 - ki);
                                    }
                                    else
                                    {
                                        GameManager.bKingLoc.setLocation((char)(97 + kj), 8 - ki);
                                    }    
                                }
                                
                                locations[k][l].setPiece(null);
                                locations[i][j].setPiece(temp);
                            }
                        }
                    }
                }
            }
        }
		
		return true;
	}
	
	
	/**
	 * Retrieves input in the console from the user 
	 * @param src The chosen piece to be moved
	 * @param dest The desired location to move the piece
	 * @param turnColor The color of the turn during the move
	 * @return boolean value determing if the move is valid
	 */
	public boolean movePiece(BoardLocation src, BoardLocation dest, ChessColor turnColor)
	{
		boolean validMoveMade = false;
		
		int srcFile = (int)src.getFile() - 97;
		int srcRank = 8 - src.getRank();
		
		int destFile = (int)dest.getFile() - 97;
		int destRank = 8 - dest.getRank();
		
		if (locations[srcRank][srcFile].hasPiece())
		{
			ChessPiece srcPiece = locations[srcRank][srcFile].getPiece();
			
			if (srcPiece.getColor() == turnColor)
			{
				if (srcPiece.moveIsValid(srcRank, srcFile, destRank, destFile, locations))
				{
					if (srcRank == 7 && srcFile == 4 && destRank == 7 && destFile == 6)
					{
						if (testCheck(7, 6, ChessColor.WHITE))
						{
							System.out.println("Illegal move, try again");
							return false;
						}
						if (testCheck(7, 5, ChessColor.WHITE))
						{
							System.out.println("Illegal move, try again");
							return false;
						}	
					}
					
					if (srcRank == 0 && srcFile == 4 && destRank == 0 && destFile == 6)
					{
						if (testCheck(0, 6, ChessColor.BLACK))
						{
							System.out.println("Illegal move, try again");
							return false;
						}
						if (testCheck(0, 5, ChessColor.BLACK))
						{
							System.out.println("Illegal move, try again");
							return false;
						}
							
					}
					
					// update king location if king moved
					if (srcPiece instanceof King)
					{
						if (srcPiece.getColor() == ChessColor.WHITE)
						{
							GameManager.wKingLoc.setLocation((char)(97 + destFile), 8 - destRank);
						}
						else
						{
							GameManager.bKingLoc.setLocation((char)(97 + destFile), 8 - destRank);
						}
					}
					
					locations[srcRank][srcFile].setPiece(null);
					locations[destRank][destFile].setPiece(srcPiece);
					
					// check if own king in check
					if (isInCheck(turnColor))
					{
						System.out.println("Cannot put own King in check.");
						
						if (srcPiece instanceof King)
						{
							if (srcPiece.getColor() == ChessColor.WHITE)
							{
								GameManager.wKingLoc.setLocation((char)(97 + srcFile), 8 - srcRank);
							}
							else
							{
								GameManager.bKingLoc.setLocation((char)(97 + srcFile), 8 - srcRank);
							}
						}
						
						locations[srcRank][srcFile].setPiece(srcPiece);
						locations[destRank][destFile].setPiece(null);
						
						return false;
					}
					
					
					locations[destRank][destFile].getPiece().incrementNumMoves();					
					validMoveMade = true;
					
					if (srcPiece instanceof Pawn && (destRank == 0 || destRank == 7))
					{
						promote(destFile, destRank, turnColor);
					}
					
					if (srcPiece instanceof King)
					{
						if (srcPiece.getColor() == ChessColor.WHITE)
						{
							GameManager.wKingLoc.setLocation((char)(97 + destFile), 8 - destRank);
						}
						else
						{
							GameManager.bKingLoc.setLocation((char)(97 + destFile), 8 - destRank);
						}
					}
						
					
					GameManager.check = isInCheck(turnColor == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE);
					
					if (GameManager.check)
					{
						if(isInCheckmate(turnColor == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE))
							GameManager.winner = turnColor;
					}
				}
				else
					System.out.println("Illegal move, try again");
			}
			else
			{
				System.out.println(turnColor == ChessColor.WHITE ? "Cannot move a black piece on white's turn" : "Cannot move a white piece on black's turn");
			}
		}
		else
		{
			System.out.println("Illegal move, try again");
		}
		
		return validMoveMade;
	}
	
	/**
	 * Prints out the entirety of the ChessBoard including all piece positions and
	 * the file rank systems on the right side and bottom of the board
	 */
	@Override
	public String toString()
	{
		String retVal = "";
		
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (j == 8 && i != 8)
				{
					retVal += " " + (8 - i) + "\n";
				}
				else if (i != 8)
				{
					if (locations[i][j].hasPiece())
					{
						ChessPiece piece = locations[i][j].getPiece();
						retVal += piece.toString() + " ";
					}
					else
					{
						if (i % 2 == 0 && j % 2 == 0 ||
							i % 2 == 1 && j % 2 == 1)
						{
							retVal += "   ";
						}
						else
						{
							retVal += "## ";
						}
					}
				}
			}
			if (i == 8)
			{
				retVal += "a  b  c  d  e  f  g  h\n";
			}
		}
		return retVal;
	}
	
	/**
	 * Promote a pawn that has reached the other end of the board
	 * @param destFile The file of the pawn that has reached the end
	 * @param destRank The rank of the pawn that has reached the end
	 * @param turnColor The color of the pawn that has reached the end
	 */
	private void promote(int destFile, int destRank, ChessColor turnColor)
	{
		boolean valid = false;
		System.out.print("Pawn eligible for promotion. Type \"knight\", \"bishop\", \"rook\", or \"queen\" to promote: ");
		Scanner in = new Scanner(System.in);	
		
		do
		{	
			String cmd = in.nextLine();		
			
			if (cmd.equals("knight"))
			{
				valid = true;
				locations[destRank][destFile].setPiece(new Knight(turnColor));
			}
			else if (cmd.equals("bishop"))
			{
				valid = true;
				locations[destRank][destFile].setPiece(new Bishop(turnColor));
			}
			else if (cmd.equals("rook"))
			{
				valid = true;
				locations[destRank][destFile].setPiece(new Rook(turnColor));
			}
			else if (cmd.equals("queen"))
			{
				valid = true;
				locations[destRank][destFile].setPiece(new Queen(turnColor));
			}
			else
			{
				System.out.println("Invalid selection. Try again.");
			}
			
		} while (valid == false);
		
	}
}
