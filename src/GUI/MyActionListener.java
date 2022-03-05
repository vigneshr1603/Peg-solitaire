package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Model.Board;
import Model.Coordinates;

/**
 * Class to detect action performed
 */
public class MyActionListener implements ActionListener {

	public static Board game = new Board();

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		Coordinates C = Matrix.getCoordinatesOfButton(button);

		int I = C.getX();
		int J = C.getY();

		if (Memory.getCoordinates() == null) {
			Memory.setCoordinates(I, J);
			Memory.setButton(button);
			return;
		} else {
			if (game.isMoveValid(Memory.getCoordinates(), new Coordinates(I, J))) {
				game.MakeMove(Memory.getCoordinates(), new Coordinates(I, J));
				int A = (I + Memory.getCoordinates().getX()) / 2;
				int B = (J + Memory.getCoordinates().getY()) / 2;

				JButton button2 = Matrix.getButton(A, B);

				Image Marble = null;

				try {
					Marble = ImageIO.read(getClass().getResource("assets/marble.png"));
					Marble = Marble.getScaledInstance(70, 70, Image.SCALE_DEFAULT);

				} catch (IOException e1) {

				}

				button.setIcon(new ImageIcon(Marble));
				Memory.getButton().setIcon(null);
				button2.setIcon(null);

				Memory.deleteCoordinates();
			} else {
				Memory.setCoordinates(I, J);
				Memory.setButton(button);
			}

		}

	}
}