package frontend;

import frontend.Config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import backend.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameWindow extends JFrame{
    private JPanel contentPane;
    public GameWindow() {
        setup();
        loadMenu();
        refresh();
    }

    private void setup() {
        setTitle(Config.WINDOW_TITLE);
        setSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);

        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        setContentPane(contentPane);
        setVisible(true);
    }

    public void refresh() {
        contentPane.invalidate();
        contentPane.validate();
        contentPane.repaint();
    }

    private void loadMenu() {
        JLabel background = new JLabel(new ImageIcon(Game.getResource("/img/menu.png")));
        contentPane.add(background);
        background.setLayout(null);

        JButton b1 = new JButton("Play");
        b1.setFont(new Font("Sans-Serif", Font.PLAIN, 40));
        Dimension size = b1.getPreferredSize();
        b1.setBounds(900,700, size.width, size.height);
        b1.setBackground(Color.yellow);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                loadGame();
            }
        });

        b1.setOpaque(true);
        background.add(b1);
    }

    private void loadGame() {
        contentPane.removeAll();
        refresh();
    }
}
