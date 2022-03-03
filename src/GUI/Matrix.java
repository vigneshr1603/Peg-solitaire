package GUI;

import javax.swing.JButton;

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
}
