package GUI.Service;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Model.Board;
import Model.Coordinates;

public class MyActionListener implements ActionListener {

    public static Board game = new Board();

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        Point rv = new Point();

        int J = button.getLocation(rv).x / 100;
        int I = button.getLocation(rv).y / 100;

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
                Image Marble;
                try {
                    Marble = ImageIO.read(new FileInputStream("Peg solitaire/src/GUI/assets/marble.jpeg"));
                    Marble = Marble.getScaledInstance(90, 90, Image.SCALE_DEFAULT);
                    button.setIcon(new ImageIcon(Marble));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Memory.deleteCoordinates();
            } else {
                Memory.setCoordinates(I, J);
                Memory.setButton(button);
            }

        }

    }
}