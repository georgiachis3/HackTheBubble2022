package frontend;

import frontend.Config;
import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame{
    private JPanel contentPane;

    public GameWindow() {
        setTitle(Config.WINDOW_TITLE);
        setSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);

        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        setContentPane(contentPane);

        setVisible(true);
    }
}
