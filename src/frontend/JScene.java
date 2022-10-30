package frontend;

import backend.Game;
import backend.GameObjectStore;
import backend.objects.Scene;
import exceptions.NoSuchGameObjectException;

import frontend.JCharacter;
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
        try {
            for (String characterId : scene.getCharacterIds()) {
                add(new JCharacter(characterId));
            }
            for (String itemId : scene.getItemIds()) {
                add(new JItem(itemId, this));
            }
            for (String dialogueId : scene.getDialogueIds()) {
                add(new JDialogue(dialogueId, this));
            }
        } catch (NoSuchGameObjectException e) {
            throw new RuntimeException(e);
        }
    }
}
