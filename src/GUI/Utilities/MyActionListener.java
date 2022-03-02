package GUI.Utilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Service.Model.Board;
import Service.Model.Coordinates;

public class MyActionListener implements ActionListener {

    public static Board game = new Board();

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        Point rv = new Point();

        int J = button.getLocation(rv).x / 100;
        int I = button.getLocation(rv).y / 100;
        
        if (Memory.getCorrdinates() == null) {
            Memory.setCorrdinates(I, J);
            Memory.setButton(button);
            return;
        } else {
            if (game.isMoveValid(Memory.getCorrdinates(), new Coordinates(I, J))) {
                game.MakeMove(Memory.getCorrdinates(), new Coordinates(I, J));
                int A = (I + Memory.getCorrdinates().getX()) / 2;
                int B = (J + Memory.getCorrdinates().getY()) / 2;

                Memory.getButton().setIcon(null);
                Image Marble;
                try {
                    Marble = ImageIO.read(new FileInputStream("Peg solitaire/src/GUI/assets/marble.jpeg"));
                    Marble = Marble.getScaledInstance(90, 90, Image.SCALE_DEFAULT);
                    button.setIcon(new ImageIcon(Marble));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Memory.deleteCorrdinates();
            } else {
                Memory.setCorrdinates(I, J);
                Memory.setButton(button);
            }

        }

    }
}