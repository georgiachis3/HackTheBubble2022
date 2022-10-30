package frontend;

import frontend.Config;
import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame{
    private JPanel contentPane;

    public GameWindow() {
        setup();
        imageTest();
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

    private void imageTest() {
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/background-hospital.png"));
        JLabel test = new JLabel();
        test.setIcon(icon);
        contentPane.add(test);

        refresh();
    }

    public void refresh() {
        contentPane.invalidate();
        contentPane.validate();
        contentPane.repaint();
    }
}
