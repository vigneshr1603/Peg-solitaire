package GUI.Service;

import javax.swing.JButton;

import Model.Coordinates;

public class Memory {
    private static Coordinates corrdinates = null;
    private static JButton button = null;

    public static Coordinates getCoordinates() {
        return corrdinates;
    }

    public static void setCoordinates(int X, int Y) {
        corrdinates = new Coordinates(X, Y);
    }

    public static JButton getButton() {
        return button;
    }

    public static void setButton(JButton button) {
        Memory.button = (JButton) button;
    }

    public static void deleteCoordinates() {
        corrdinates = null;
        button = null;
    }

}
