package GUI;

import javax.swing.JOptionPane;

/**
 * Exit Window
 */
public class ExitWindow {
	public static void exitFunction() {

		String[] options = { "Quit" };
		JOptionPane.showOptionDialog(null, "Congrats! You won!!!", "Game over", JOptionPane.DEFAULT_OPTION, 0, null, options, options[0]);
		System.exit(0);

	}

}
