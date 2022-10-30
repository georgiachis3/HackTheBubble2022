package frontend;

import backend.Game;
import backend.GameObjectStore;
import backend.objects.Item;
import exceptions.NoSuchGameObjectException;

import javax.swing.*;

public class JScene extends JLabel {
    private final String sceneId;

    public JScene(String sceneId) throws NoSuchGameObjectException {
        super ("");
        this.sceneId = sceneId;
        Item item = GameObjectStore.getInstance().getItemById(sceneId);

        ImageIcon icon = new ImageIcon(Game.getResource(item.getImage()));
        setIcon(icon);

        setLayout(null);
    }

    public void addObject(JButton obj) {
        add(obj);
    }
}
