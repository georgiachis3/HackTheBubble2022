package frontend;

import backend.Game;
import backend.GameObjectStore;
import backend.objects.Scene;
import exceptions.NoSuchGameObjectException;

import javax.swing.*;

public class JScene extends JLabel {
    private final String sceneId;

    public JScene(String sceneId) throws NoSuchGameObjectException {
        super ("");
        this.sceneId = sceneId;
        Scene scene = GameObjectStore.getInstance().getSceneById(sceneId);

        ImageIcon icon = new ImageIcon(Game.getResource(scene.getBackgroundImage()));
        setIcon(icon);

        setLayout(null);

        createObjects(scene);
    }

    public void addObject(JButton obj) {
        add(obj);
    }

    private void createObjects(Scene scene) {
        for (String characterId : scene.getCharacterIds()) {

        }
    }
}
