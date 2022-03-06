package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

				button = ButtonModifier.setMarbleIcon(button);
				button2 = ButtonModifier.removeIcon(button2);
				ButtonModifier.removeIcon(Memory.getButton());

				Memory.deleteCoordinates();
				Matrix.deletePeg();

				if (Matrix.getPeg() == 1) {
					ExitWindow.exitFunction();
				}

			} else {
				Memory.setCoordinates(I, J);
				Memory.setButton(button);
			}

		}

	}
}