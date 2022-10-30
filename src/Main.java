import javax.swing.*;

import backend.Game;
import frontend.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Game game = Game.getInstance();
        JFrame frame = new GameWindow();
    }
}
