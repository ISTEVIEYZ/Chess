package chess.models.pieces;

import chess.models.*;
import chess.utilities.ChessHelper;

/**
 * Defines the type and move behavior of this specific ChessPiece object
 * @author Stephen Eisen
 * @author Arthur Quintanilla
 */

public class Queen extends ChessPiece{

	/**
	 * Constructs a Queen object
	 * @param color The desired color of the Queen object
	 */
	public Queen(ChessColor color) {
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
			if (Math.abs(di - si) == Math.abs(dj - sj))
			{
				// WHITE
				if (color == ChessColor.BLACK)
				{
					// DOWN
					if (di > si)
					{
						if (dj > sj) // DOWN RIGHT
						{
							for (int i = 1; i < dj - sj; i++)
							{
								if (locations[si + i][sj + i].hasPiece())
									return false;
							}
							if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
								return true;
							else if (!locations[di][dj].hasPiece())
								return true;
							else 
								return false;
						}// END DOWN RIGHT
						else // DOWN LEFT
						{
							for (int i = 1; i < sj - dj; i++)
							{
								if (locations[si + i][sj - i].hasPiece())
									return false;
							}
							if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
								return true;
							else if (!locations[di][dj].hasPiece())
								return true;
							else 
								return false;
						}// END DOWN LEFT
						
					} // END DOWN
					
					// UP
					else
					{
						if (dj > sj) // UP RIGHT
						{
							for (int i = 1; i < dj - sj; i++)
							{
								
								if (locations[si + i][sj + i].hasPiece())
									return false;
							}
							if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
								return true;
							else if (!locations[di][dj].hasPiece())
								return true;
							else 
								return false;
						} // END UP RIGHT
						else // UP LEFT
						{
							for (int i = di; i < si; i++)
							{
								if (locations[si - i][dj - i].hasPiece())
									return false;
							}
							if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
								return true;
							else if (!locations[di][dj].hasPiece())
								return true;
							else 
								return false;
						} // END UP LEFT
					} // END UP
				}// END WHITE
				
				//BLACK
				else
				{
					// DOWN
					if (di > si)
					{
						if (dj > sj) // DOWN RIGHT
						{
							for (int i = 1; i < dj - sj; i++)
							{
								if (locations[si + i][sj + i].hasPiece())
									return false;
							}
							if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
								return true;
							else if (!locations[di][dj].hasPiece())
								return true;
							else 
								return false;
						} // END DOWN RIGHT
						else // DOWN LEFT
						{
							for (int i = si; i < di; i++)
							{
								if (locations[si + i][dj - i].hasPiece())
									return false;
							}
							if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
								return true;
							else if (!locations[di][dj].hasPiece())
								return true;
							else 
								return false;
						} // END DOWN LEFT
					} //END DOWN
					
					// UP
					else
					{
						if (dj > sj) // UP RIGHT
						{
							for (int i = 1; i < dj - sj; i++)
							{
								if (locations[si - i][sj + i].hasPiece())
								{
									return false;	
								}
							}
							if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
								return true;
							else if (!locations[di][dj].hasPiece())
								return true;
							else 
								return false;
						} // END UP RIGHT
						else // UP LEFT
						{
							for (int i = 1; i < (sj - dj); i++)
							{
								if (locations[si - i][sj - i].hasPiece())
									return false;
							}
							if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
								return true;
							else if (!locations[di][dj].hasPiece())
								return true;
							else 
								return false;
						} // END UP LEFT
					} // END UP
				} // END BLACK
				
			} // END EQUAL MOVE DISTANCE
			else if ((di == si && dj != sj) || (di != si && dj == sj))
			{
				if (color == ChessColor.BLACK)
				{
					if (di > si) //DOWN
					{
						for (int i = 1; i < di - si; i++)
						{
							if (locations[si + i][dj].hasPiece())
								return false;
						}
						if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else if (!locations[di][dj].hasPiece())
							return true;
						else 
							return false;
					}
					else if (di < si) // UP
					{
						for (int i = 1; i < si - di; i++)
						{
							if (locations[si - i][dj].hasPiece())
								return false;
						}
						if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else if (!locations[di][dj].hasPiece())
							return true;
						else 
							return false;
					}
					else if (dj > sj) // RIGHT
					{
						for (int i = 1; i < dj - sj; i++)
						{
							if (locations[si][sj + i].hasPiece())
								return false;
						}
						if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else if (!locations[di][dj].hasPiece())
							return true;
						else 
							return false;
					}
					else if (dj < sj) // LEFT
					{
						for (int i = 1; i < sj - dj ; i++)
						{
							if (locations[si][sj - i].hasPiece())
								return false;
						}
						if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.WHITE)
							return true;
						else if (!locations[di][dj].hasPiece())
							return true;
						else 
							return false;
					}
					else
						return false;
							
				}
				
				// BLACK
				else
				{
					if (di > si) //DOWN
					{
						for (int i = 1; i < di - si; i++)
						{
							if (locations[si + i][dj].hasPiece())
								return false;
						}
						if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else if (!locations[di][dj].hasPiece())
							return true;
						else 
							return false;
					}
					else if (di < si) // UP
					{
						for (int i = 1; i < si - di; i++)
						{
							if (locations[si - i][dj].hasPiece())
								return false;
						}
						if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else if (!locations[di][dj].hasPiece())
							return true;
						else 
							return false;
					}
					else if (dj > sj) // RIGHT
					{
						for (int i = 1; i < dj - sj; i++)
						{
							if (locations[si][sj + i].hasPiece())
								return false;
						}
						if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else if (!locations[di][dj].hasPiece())
							return true;
						else 
							return false;
					}
					else if (dj < sj) // LEFT
					{
						for (int i = 1; i < sj - dj ; i++)
						{
							if (locations[si][sj - i].hasPiece())
								return false;
						}
						if (locations[di][dj].hasPiece() && locations[di][dj].getPiece().getColor() == ChessColor.BLACK)
							return true;
						else if (!locations[di][dj].hasPiece())
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
		else return false;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return color.toString() + "Q";
	}

}
