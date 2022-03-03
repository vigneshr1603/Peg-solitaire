package GUI;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Made by Vignesh
 */
public class PegSolitaire {

	public static void main(String args[]) throws Exception {
		InitializeGUI();
	}

	/**
	 * Initializes GUI
	 */
	public static void InitializeGUI() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Peg Solitaire");
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				GameWindow window = new GameWindow();
				frame.getContentPane().add(window);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}