package GUI;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Class to change button Icons
 */
public class ButtonModifier {

	private static String MarbleUrl = "assets/marble.png";

	public static JButton setMarbleIcon(JButton button) {
		Image Marble = null;
		try {
			Marble = ImageIO.read(ButtonModifier.class.getResource(MarbleUrl));
			Marble = Marble.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		} catch (IOException e) {
		}
		button.setIcon(new ImageIcon(Marble));
		return button;

	}

	public static JButton removeIcon(JButton button) {

		button.setIcon(null);
		return button;

	}
}
