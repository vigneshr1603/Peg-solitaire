package GUI;

import javax.swing.JButton;

import Model.Coordinates;

/**
 * Stores buttons in a matrix
 */

public class Matrix {

	static JButton[][] buttons = new JButton[9][9];

	public static void addButton(int i, int j, JButton button) {
		buttons[i][j] = button;
	}

	public static JButton getButton(int i, int j) {
		return buttons[i][j];
	}

	public static Coordinates getCoordinatesOfButton(JButton button) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (buttons[i][j] == button)
					return new Coordinates(i, j);
			}
		}
		return null;
	}
}
