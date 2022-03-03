package Model;

public class Board {

	private Type board[][];

	public Board() {

		board = new Type[9][9];
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if ((row <= 2 && col > 2 && col < 6) || (row > 2 && row < 6 || (row > 5 && col > 2 && col < 6))) {
					if (row != 4 || col != 4) {
						board[row][col] = Type.PRESENT;
					} else {
						board[row][col] = Type.ABSENT;
					}
				} else {
					board[row][col] = Type.INVALID;
				}
			}
		}

	}

	public Type getStatus(int x, int y) {
		return board[x][y];

	}

	public Type getStatus2(Coordinates p) {
		return board[p.getX()][p.getY()];
	}

	/**
	 * Checks if a move is valid from Coordinate A to Coordinate B
	 */
	public boolean isMoveValid(Coordinates from, Coordinates to) {

		if (from.isPointValid() == false || to.isPointValid() == false) {
			return false;
		}
		if ((from.getX() == to.getX()) != (from.getY() == to.getY())) {

			if (Math.abs(from.getX() - to.getX()) == 2 || Math.abs(from.getY() - to.getY()) == 2) {

				Coordinates mid = Coordinates.getMidPoint(from, to);
				if (getStatus2(from) == Type.PRESENT && getStatus2(to) == Type.ABSENT
						&& getStatus2(mid) == Type.PRESENT)
					return true;

			}
		}
		return false;
	}

	/**
	 * Makes a move from Coordinate A to Coordinate B
	 */
	public void MakeMove(Coordinates from, Coordinates to) {
		Coordinates mid = Coordinates.getMidPoint(from, to);
		board[from.getX()][from.getY()] = Type.ABSENT;
		board[mid.getX()][mid.getY()] = Type.ABSENT;
		board[to.getX()][to.getY()] = Type.PRESENT;
	}

}