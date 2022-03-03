package Model;

/**
 * Stores (X,Y) as Coordinates
 */

public class Coordinates {
	private int x, y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns if a point is valid
	 */
	
	public boolean isPointValid() {
		return (x >= 0 && y >= 0 && x < 9 && y < 9);
	}

	/**
	 * Returns the midpoint of Coordinate A and Coordinate B
	 */

	public static Coordinates getMidPoint(Coordinates from, Coordinates to) {
		return new Coordinates((from.getX() + to.getX()) / 2, (from.getY() + to.getY()) / 2);
	}

}
