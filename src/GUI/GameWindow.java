package GUI;

import java.awt.*;
import javax.swing.*;

/**
 * Initializes Game window
 */
public class GameWindow extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Initializes Game window
	 */
	public GameWindow() {
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {

				gbc.gridx = col;
				gbc.gridy = row;

				JButton button = new JButton();

				if ((row <= 2 && col > 2 && col < 6) || (row > 2 && row < 6 || (row > 5 && col > 2 && col < 6))) {
					if (row != 4 || col != 4) {

						button = ButtonModifier.setMarbleIcon(button);
					} else {
						button = ButtonModifier.removeIcon(button);
					}

					button.setBackground(java.awt.Color.WHITE);
					button.setContentAreaFilled(false);
					button.setOpaque(true);
					button.setBackground(java.awt.Color.WHITE);
				} else {

					button.setEnabled(false);
					button.setBackground(java.awt.Color.GRAY);
				}
				Matrix.addButton(row, col, button);

				button.setContentAreaFilled(false);
				button.setBorderPainted(true);
				button.setPreferredSize(new Dimension(60, 60));
				MyActionListener mal = new MyActionListener();
				button.addActionListener(mal);

				add(button, gbc);

			}
		}
	}
}