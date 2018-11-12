package chess.models.pieces;

import chess.models.*;
import chess.utilities.ChessHelper;

/**
 * Defines the type and move behavior of this specific ChessPiece object
 * @author Stephen Eisen
 * @author Arthur Quintanilla
 */

public class King extends ChessPiece{

	/**
	 * Constructs a king object
	 * @param color The desired color of this object
	 */
	public King(ChessColor color) {
		super(color);
	}

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
				// Castling
				if (numMoves == 0)
				{
					if (di == si && dj == sj + 2 && !locations[di][sj +1].hasPiece() && !locations[di][sj + 2].hasPiece())
					{
						if (locations[di][sj + 3].getPiece().getNumMoves() == 0)
						{
							locations[si][sj + 1].setPiece(locations[di][sj + 3].getPiece());
							locations[si][sj + 3].setPiece(null);
							return true;
						}
					}
				}
				
				// DOWN
				if (di == si + 1 && sj == dj && !locations[di][dj].hasPiece())
					return true;
				else if (di == si + 1 && sj == dj && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else
						return false;
				}
				// DOWN RIGHT
				else if (di == si + 1 && dj == sj + 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si + 1 && dj == sj + 1 && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else
						return false;
				}
				// DOWN LEFT
				else if (di == si + 1 && dj == sj - 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si + 1 && dj == sj - 1 && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else
						return false;
				}
				// UP
				else if (di == si - 1 && sj == dj && !locations[di][dj].hasPiece())
					return true;
				else if (di == si - 1 && sj == dj && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else
						return false;
				}
				// UP RIGHT
				else if (di == si - 1 && dj == sj + 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si - 1 && dj == sj + 1 && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else
						return false;
				}
				// UP LEFT
				else if (di == si - 1 && dj == sj - 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si - 1 && dj == sj - 1 && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else
						return false;
				}
				// LEFT
				else if (di == si && dj == sj - 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si && dj == sj - 1  && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else
						return false;
				}
				// RIGHT
				else if (di == si && dj == sj + 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si && dj == sj + 1  && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
						return true;
					else
						return false;
				}
				else 
					return false;
				
			}
			else
			{
				// Castling
				if (numMoves == 0)
				{
					if (di == si && dj == sj + 2 && !locations[di][sj +1].hasPiece() && !locations[di][sj + 2].hasPiece())
					{
						if (locations[di][sj + 3].getPiece().getNumMoves() == 0)
						{
							locations[si][sj + 1].setPiece(locations[di][sj + 3].getPiece());
							locations[si][sj + 3].setPiece(null);
							return true;
						}
					}
				}
				// DOWN
				if (di == si + 1 && sj == dj && !locations[di][dj].hasPiece())
					return true;
				else if (di == si + 1 && sj == dj && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else
						return false;
				}
				// DOWN RIGHT
				else if (di == si + 1 && dj == sj + 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si + 1 && dj == sj + 1 && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else
						return false;
				}
				// DOWN LEFT
				else if (di == si + 1 && dj == sj - 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si + 1 && dj == sj - 1 && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else
						return false;
				}
				// UP
				else if (di == si - 1 && sj == dj && !locations[di][dj].hasPiece())
					return true;
				else if (di == si - 1 && sj == dj && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else
						return false;
				}
				// UP RIGHT
				else if (di == si - 1 && dj == sj + 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si - 1 && dj == sj + 1 && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else
						return false;
				}
				// UP LEFT
				else if (di == si - 1 && dj == sj - 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si - 1 && dj == sj - 1 && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else
						return false;
				}
				// LEFT
				else if (di == si && dj == sj - 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si && dj == sj - 1  && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else
						return false;
				}
				// RIGHT
				else if (di == si && dj == sj + 1 && !locations[di][dj].hasPiece())
					return true;
				else if (di == si && dj == sj + 1  && locations[di][dj].hasPiece())
				{
					if (locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
						return true;
					else
						return false;
				}
				else 
					return false;
			}
		}
		else
			return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() 
	{
		return color.toString() + "K";
	}

}
