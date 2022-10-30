package backend;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Game {
    private static final String GAME_JSON_FILE = "/game.json";

    private static Game instance = null;

    public static Game getInstance() throws IOException, URISyntaxException {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public static URL getResource(String path) {
        return Objects.requireNonNull(Game.class.getResource(path));
    }

    private final Player player;

    private String scene;

    private Game() throws IOException, URISyntaxException {
        player = new Player();

        byte[] jsonData = Files.readAllBytes(Path.of(this.getClass().getResource(GAME_JSON_FILE).toURI()));

        ObjectMapper objectMapper = new ObjectMapper();

        GameObjectStore objectStore = objectMapper.readValue(jsonData, GameObjectStore.class);

        scene = objectStore.getInitialScene();
    }

    public Player getPlayer() {
        return player;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }
}
