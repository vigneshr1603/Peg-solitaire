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

		Point rv = new Point();

		int J = button.getLocation(rv).x / 70;
		int I = button.getLocation(rv).y / 70;

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
				button2.setIcon(null);

				Memory.getButton().setIcon(null);
				Image Marble = null;
				try {
					Marble = ImageIO.read(getClass().getResource("assets/marble.jpeg"));
					Marble = Marble.getScaledInstance(50, 50, Image.SCALE_DEFAULT);

				} catch (IOException e1) {
				}
				button.setIcon(new ImageIcon(Marble));

				Memory.deleteCoordinates();
			} else {
				Memory.setCoordinates(I, J);
				Memory.setButton(button);
			}

		}

	}
}