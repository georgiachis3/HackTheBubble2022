package frontend;

import backend.Game;
import backend.GameObjectStore;
import backend.Player;
import backend.objects.Scene;
import exceptions.NoSuchGameObjectException;

import frontend.JCharacter;
import javax.swing.*;

public class JScene extends JLabel {
    private final String sceneId;

    public JScene(String sceneId, SceneChanger sc) throws NoSuchGameObjectException {
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
                add(new JCharacter(characterId, this));
            }
            for (String itemId : scene.getItemIds()) {
                add(new JItem(itemId, this, this::itemClickHandler));
            }
            for (String dialogueId : scene.getDialogueIds()) {
                add(new JDialogue(dialogueId, this));
            }
        } catch (NoSuchGameObjectException e) {
            throw new RuntimeException(e);
        }
    }

    private void itemClickHandler() {
        try {
            Player player = Game.getInstance().getPlayer();
        } catch (Exception ex) {}
    }
}
