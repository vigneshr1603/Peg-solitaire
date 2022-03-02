package GUI.Utilities;

import javax.swing.JButton;

import Service.Model.Coordinates;

public class Memory {
    private static Coordinates corrdinates = null;
    private static JButton button = null;

    public static Coordinates getCorrdinates() {
        return corrdinates;
    }

    public static void setCorrdinates(int X, int Y) {
        corrdinates = new Coordinates(X, Y);
    }

    public static JButton getButton() {
        return button;
    }

    public static void setButton(JButton button) {
        Memory.button = (JButton) button;
    }

    public static void deleteCorrdinates() {
        corrdinates = null;
        button = null;
    }

}
