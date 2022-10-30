package frontend;

import javax.swing.*;
import java.awt.*;
import backend.Game;
import exceptions.NoSuchGameObjectException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameWindow extends JFrame{
    private JPanel contentPane;
    public GameWindow() {
        setup();
        loadMenu();
        refresh();
    }

    private void setup() {
        setResizable(false);
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
        loadNewScene();
    }

    public void loadNewScene() {
        contentPane.removeAll();
        try {
            Game game = Game.getInstance();
            String sceneId = game.getScene();
            contentPane.add(new JScene(sceneId, this::changeScene));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (NoSuchGameObjectException e) {
            throw new RuntimeException(e);
        }
        refresh();
    }

    public void changeScene() {
        loadNewScene();
    }
}
