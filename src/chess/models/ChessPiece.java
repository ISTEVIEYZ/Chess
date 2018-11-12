package chess.models;

/**
 * Defines the current state, color, and BoardLocation of
 * each ChessPiece present on the ChessBoard
 * @author Stephen Eisen
 * @author Arthur Quintanilla
 */
public abstract class ChessPiece {
	
	/**
	 * Determines the color of the ChessPiece
	 */
	protected ChessColor color;
	
	/**
	 * Determines the number of moves the piece has made
	 */
	protected int numMoves;
	
	/**
	 * Super constructor for classes that extend ChessPiece
	 * @param color The desired color of this ChessPiece
	 */
	public ChessPiece(ChessColor color)
	{
		this.color = color;
		this.numMoves = 0;
	}
	
	/**
	 * Gets the color of the ChessPiece
	 * Always return either BLACK or WHITE
	 * @return color An enumeration of type color 
	 */
	public ChessColor getColor()
	{
		return color;
	}
	
	
	/**
	 * Get the number of moves this piece has made.
	 * @return The number of moves the piece has made
	 */
	public int getNumMoves()
	{
		return this.numMoves;
	}
	
	/**
	 * Sets the current color of the ChessPiece
	 * This will never be used during runtime as a piece cannot change color
	 * @param color ChessColor enumerator that can either be BLACK or WHITE
	 */
	public void setColor(ChessColor color)
	{
		this.color = color;
	}
	
	/**
	 * Increment the number of moves this piece has made.
	 */
	public void incrementNumMoves()
	{
		numMoves++;
	}
	
	/**
	 * toString override that states the color and unit type of this object
	 * @return A string containing the ChessPiece color and type
	 */
	@Override
	public abstract String toString();

	/**
	 * Determines all possible moves associated with the current board location of this object
	 * @param si The current horizontal board location of this object
	 * @param sj The current vertical board location of this object
	 * @param di The desired horizontal board location of this object
	 * @param dj The desired vertical board location of this object
	 * @param locations The current state of the board including all active pieces
	 * @return Returns a boolean determining whether or not the move is valid
	 */
	public abstract boolean moveIsValid(int si, int sj, int di, int dj, BoardLocation[][] locations);
}
