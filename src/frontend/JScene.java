package frontend;

import backend.Game;
import backend.GameObjectStore;
import backend.Player;
import backend.objects.Portal;
import backend.objects.Scene;
import exceptions.NoSuchGameObjectException;

import frontend.JCharacter;
import javax.swing.*;
import java.util.List;

public class JScene extends JLabel {
    private final String sceneId;
    private final String scenePortalId;
    public SceneChanger sc;

    public JScene(String sceneId, SceneChanger sc) throws NoSuchGameObjectException {
        super ("");
        this.sceneId = sceneId;
        Scene scene = GameObjectStore.getInstance().getSceneById(sceneId);
        scenePortalId = scene.getPortal();
        this.sc = sc;

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

            Portal portal = GameObjectStore.getInstance().getPortalById(scenePortalId);

            int noCorrectItems = 0;
            System.out.println("here");
            List<String> reqItems = portal.getItems();
            System.out.println(reqItems);
            for (int i=0; i<reqItems.size(); i++) {
                System.out.println(reqItems.get(i));
                if (player.hasItem(reqItems.get(i))) {
                    noCorrectItems++;
                }
                if (noCorrectItems == reqItems.size()) {
                    Game.getInstance().setScene(portal.getToId());
                    sc.changeScene();
                }
            }
        } catch (Exception ex) {}
    }
}
