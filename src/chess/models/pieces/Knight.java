package chess.models.pieces;

import chess.models.*;
import chess.utilities.ChessHelper;

/**
 * Defines the type and move behavior of this specific ChessPiece object
 * @author Stephen Eisen
 * @author Arthur Quintanilla
 */

public class Knight extends ChessPiece {

	/**
	 * Constructs a Knight object
	 * @param color The desired color this object
	 */
	public Knight(ChessColor color) {
		super(color);
	}

	/**
	 *  {@inheritDoc}
	 */
	@Override
	public boolean moveIsValid(int si, int sj, int di, int dj, BoardLocation[][] locations)
	{
		if (ChessHelper.isInBounds(di, dj))
		{
			if (color == ChessColor.BLACK)
			{
				if (di == si + 2 && dj == sj + 1)
				{
					if (locations[si + 2][sj + 1].hasPiece())
					{
						if (locations[si + 2][sj + 1].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si + 2 && dj == sj - 1)
				{
					if (locations[si + 2][sj - 1].hasPiece())
					{
						if (locations[si + 2][sj - 1].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si - 2 && dj == sj + 1)
				{
					if (locations[si - 2][sj + 1].hasPiece())
					{
						if (locations[si - 2][sj + 1].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si - 2 && dj == sj - 1)
				{
					if (locations[si - 2][sj - 1].hasPiece())
					{
						if (locations[si - 2][sj - 1].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si + 1 && dj == sj + 2)
				{
					if (locations[si + 1][sj + 2].hasPiece())
					{
						if (locations[si + 1][sj + 2].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si + 1 && dj == sj - 2)
				{
					if (locations[si + 1][sj - 2].hasPiece())
					{
						if (locations[si + 1][sj - 2].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si - 1 && dj == sj + 2)
				{
					if (locations[si - 1][sj + 2].hasPiece())
					{
						if (locations[si - 1][sj + 2].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si - 1 && dj == sj - 2)
				{
					if (locations[si - 1][sj - 2].hasPiece())
					{
						if (locations[si - 1][sj - 2].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else 
					return false;
			}
			else
			{
				if (di == si + 2 && dj == sj + 1)
				{
					if (locations[si + 2][sj + 1].hasPiece())
					{
						if (locations[si + 2][sj + 1].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si + 2 && dj == sj - 1)
				{
					if (locations[si + 2][sj - 1].hasPiece())
					{
						if (locations[si + 2][sj - 1].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si - 2 && dj == sj + 1)
				{
					if (locations[si - 2][sj + 1].hasPiece())
					{
						if (locations[si - 2][sj + 1].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si - 2 && dj == sj - 1)
				{
					if (locations[si - 2][sj - 1].hasPiece())
					{
						if (locations[si - 2][sj - 1].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si + 1 && dj == sj + 2)
				{
					if (locations[si + 1][sj + 2].hasPiece())
					{
						if (locations[si + 1][sj + 2].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si + 1 && dj == sj - 2)
				{
					if (locations[si + 1][sj - 2].hasPiece())
					{
						if (locations[si + 1][sj - 2].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si - 1 && dj == sj + 2)
				{
					if (locations[si - 1][sj + 2].hasPiece())
					{
						if (locations[si - 1][sj + 2].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else if (di == si - 1 && dj == sj - 2)
				{
					if (locations[si - 1][sj - 2].hasPiece())
					{
						if (locations[si - 1][sj - 2].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else 
							return false;
					}
					else
						return true;
				}
				else 
					return false;
			}
		}
		else return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() 
	{
		return color.toString() + "N";
	}

}
