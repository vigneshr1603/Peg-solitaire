package GUI.Utilities;

import java.awt.*;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.*;


public class GameWindow extends JPanel {

    public GameWindow() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                gbc.gridx = col;
                gbc.gridy = row;

                JButton button = new JButton();

                Image Marble = null;

                if ((row <= 2 && col > 2 && col < 6) || (row > 2 && row < 6 || (row > 5 && col > 2 && col < 6))) {
                    if (row != 4 || col != 4) {
                        try {
                            Marble = ImageIO.read(new FileInputStream("Peg solitaire/src/GUI/assets/marble.jpeg"));
                            Marble = Marble.getScaledInstance(90, 90, Image.SCALE_DEFAULT);

                        }

                        catch (Exception e) {

                        }

                        button.setIcon(new ImageIcon(Marble));
                    }

                    button.setBackground(java.awt.Color.WHITE);
                    button.setContentAreaFilled(false);
                    button.setOpaque(true);
                    button.setBackground(java.awt.Color.WHITE);
                } else {

                    button.setEnabled(false);
                    button.setBackground(java.awt.Color.GRAY);
                }

                button.setBorderPainted(true);
                button.setPreferredSize(new Dimension(100, 100));
                MyActionListener mal = new MyActionListener();
                button.addActionListener(mal);

                add(button, gbc);

            }
        }
    }
}