package chess.models;
/**
 * Enumeration that defines the color of a ChessPiece object
 * @author Stephen Eisen
 * @author Arthur Quintanilla
 */

public enum ChessColor {
	WHITE("w"),
	BLACK("b");
	
	/**
	 * The String representation of this enumeration
	 */
	private String stringVal;
	
	/**
	 * Constructs a ChessColor enumeration 
	 * @param stringVal ChessColor parameter for either BLACK(b) or WHITE(w) 
	 */
	private ChessColor(String stringVal)
	{
		this.stringVal = stringVal;
	}
	
	/**
	 * Overridden toString for this enumeration to print either "w" or "b"
	 * @return stringVal The selected color enumeration chosen
	 */
	@Override
	public String toString()
	{
		return stringVal;
	}
}
