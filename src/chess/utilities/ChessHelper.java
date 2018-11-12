package chess.utilities;

public class ChessHelper {

	public final static boolean isInBounds(int i, int j)
	{
		return i >= 0 && i <= 7 && j >= 0 && j<= 7;
	}
}
