package chess.models;
/**
 * Wrapper class for the file and rank of a board location
 * @author Stephen Eisen
 * @author Arthur Quintanilla
 */

public class BoardLocation {

	/**
	 * Reference to a ChessPiece object. NULL = Empty space
	 */
	private ChessPiece piece;
	
	/**
	 * The horizontal position of this board location
	 */
	private char file;
	
	/**
	 * The vertical position of this board location
	 */
	private int rank;
	
	/**
	 * Constructs a new instantiation of a BoardLocation wrapper object
	 * @param file The horizontal position of this location
	 * @param rank The vertical position of this location
	 */
	public BoardLocation(char file, int rank){
		this.file = file;
		this.rank = rank;
	}
	
	/**
	 * Sets the location of this BoardLocation object
	 * @param file The horizontal position of the new desired location
	 * @param rank The vertical position of the new desired location
	 */
	public void setLocation(char file, int rank){
		this.file = file;
		this.rank = rank;
	}
	
	/**
	 * Gets the current vertical position of this object
	 * @return the vertical position of this object as a char
	 */
	public int getRank(){
		return this.rank;
	}
	
	/**
	 * Gets the current horizontal position of this object
	 * @return the horizontal position of this object as an int
	 */
	public char getFile(){
		return this.file;
	}
	
	/**
	 * Gets the ChessPiece object associated with this BoardLocation
	 * This may be null if the space is not occupied by a piece
	 * @return reference to the ChessPiece at this board location
	 */
	public ChessPiece getPiece()
	{
		return piece;
	}
	
	/**
	 * References a ChessPiece to assign to this board location
	 * @param piece the ChessPiece object to be referenced
	 */
	public void setPiece(ChessPiece piece)
	{
		this.piece = piece;
	}
	
	/**
	 * Gets the state of this current board location
	 * @return true if this board location has a ChessPiece reference
	 */
	public boolean hasPiece()
	{
		return this.piece != null;
	}
}
