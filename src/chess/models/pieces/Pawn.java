package chess.models.pieces;

import chess.*;
import chess.models.*;
import chess.utilities.ChessHelper;

/**
 * Defines the type and move behavior of this specific ChessPiece object
 * @author Stephen Eisen
 * @author Arthur Quintanilla
 */

public class Pawn extends ChessPiece {

	/**
	 * Constructs a Pawn object
	 * @param color The desired color of the Pawn object
	 */
	public Pawn(ChessColor color) {
		super(color);
	}
	
	private int turnEP;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean moveIsValid(int si, int sj, int di, int dj, BoardLocation[][] locations)
	{
		if (ChessHelper.isInBounds(di, dj))
		{
			if (color == ChessColor.BLACK)
			{
				if (numMoves == 0)
				{
					if (di == si + 1 && sj == dj && !locations[di][dj].hasPiece())
						return true;
					else if (di == si + 2 && sj == dj && !locations[si + 1][dj].hasPiece() && !locations[si + 2][dj].hasPiece())
					{
						turnEP = GameManager.turnNo;
						return true;
					}
					else if (di == si + 1 && dj == sj + 1 && locations[si + 1][sj + 1].hasPiece() && locations[si + 1][sj + 1].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else if (di == si + 1 && dj == sj - 1 && locations[si + 1][sj - 1].hasPiece() && locations[si + 1][sj - 1].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else return false;
				}
				else
				{
					if (di == si + 1 && dj == sj && !locations[di][dj].hasPiece())
						return true;
					else if (di == si + 1 && dj == sj + 1 && locations[si + 1][sj + 1].hasPiece() && locations[si + 1][sj + 1].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else if (di == si + 1 && dj == sj - 1 && locations[si + 1][sj - 1].hasPiece() && locations[si + 1][sj - 1].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else if (di == si + 1 && dj == sj - 1 && locations[si][sj - 1].hasPiece() && locations[si][sj - 1].getPiece() instanceof Pawn)
					{
						Pawn p = (Pawn)locations[si][sj - 1].getPiece();
						if (p.getEPTurn() == GameManager.turnNo - 1)
						{
							locations[si][sj - 1].setPiece(null);
							return true;
						}
						else
						{
							return false;
						}
					}
					else if (di == si + 1 && dj == sj + 1 && locations[si][sj + 1].hasPiece() && locations[si][sj + 1].getPiece() instanceof Pawn)
					{
						Pawn p = (Pawn)locations[si][sj + 1].getPiece();
						if (p.getEPTurn() == GameManager.turnNo - 1)
						{
							locations[si][sj + 1].setPiece(null);
							return true;
						}
						else
						{
							return false;
						}
					}
					else
						return false;
				}
			}
			else
			{
				if (numMoves == 0)
				{
					if (di == si - 1 && sj == dj && !locations[di][dj].hasPiece())
						return true;
					else if (di == si - 2 && sj == dj && !locations[si - 1][dj].hasPiece() && !locations[si - 2][dj].hasPiece())
					{
						turnEP = GameManager.turnNo;
						return true;
					}
					else if (di == si - 1 && dj == sj + 1 && locations[si - 1][sj + 1].hasPiece() && locations[si - 1][sj + 1].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else if (di == si - 1 && dj == sj - 1 && locations[si - 1][sj - 1].hasPiece() && locations[si - 1][sj - 1].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else 
						return false;
				}
				else
				{
					if (di == si - 1 && dj == sj && !locations[di][dj].hasPiece())
						return true;
					else if (di == si - 1 && dj == sj + 1 && locations[si - 1][sj + 1].hasPiece() && locations[si - 1][sj + 1].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else if (di == si - 1 && dj == sj - 1 && locations[si - 1][sj - 1].hasPiece() && locations[si - 1][sj - 1].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else if (di == si - 1 && dj == sj - 1 && locations[si][sj - 1].hasPiece() && locations[si][sj - 1].getPiece() instanceof Pawn)
					{
						Pawn p = (Pawn)locations[si][sj - 1].getPiece();
						if (p.getEPTurn() == GameManager.turnNo - 1)
						{
							locations[si][sj - 1].setPiece(null);
							return true;
						}
						else
						{
							return false;
						}
					}
					else if (di == si - 1 && dj == sj + 1 && locations[si][sj + 1].hasPiece() && locations[si][sj + 1].getPiece() instanceof Pawn)
					{
						Pawn p = (Pawn)locations[si][sj + 1].getPiece();
						if (p.getEPTurn() == GameManager.turnNo - 1)
						{
							locations[si][sj + 1].setPiece(null);
							return true;
						}
						else
						{
							return false;
						}
					}
					else 
						return false;
				}
			}
		}
		else return false;
	}
	
	public int getEPTurn()
	{
		return this.turnEP;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return color.toString() + "p";
	}

}
