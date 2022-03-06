package GUI;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import Model.Board;

/**
 * Created by Vignesh
 */
public class PegSolitaireGUI {

	public static Board game;
	public static void main(String args[]) throws Exception {
		game = new Board();
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