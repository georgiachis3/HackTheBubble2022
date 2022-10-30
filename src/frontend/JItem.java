package frontend;

import backend.Game;
import backend.GameObjectStore;
import backend.objects.Item;
import exceptions.NoSuchGameObjectException;

import javax.swing.*;

public class JItem extends JLabel {
    private final String itemId;

    public JItem(String itemId) throws NoSuchGameObjectException {
        this.itemId = itemId;
        Item item = GameObjectStore.getInstance().getItemById(itemId);

        ImageIcon icon = new ImageIcon(Game.getResource(item.getImage()));
        setIcon(icon);
    }

}
