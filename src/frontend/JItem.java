package frontend;

import backend.Game;
import backend.GameObjectStore;
import backend.objects.Item;
import exceptions.NoSuchGameObjectException;

import javax.swing.*;
import java.awt.*;

public class JItem extends JButton {
    private final String itemId;

    public JItem(String itemId) throws NoSuchGameObjectException {
        super("");
        this.itemId = itemId;
        Item item = GameObjectStore.getInstance().getItemById(itemId);

        ImageIcon icon = new ImageIcon(Game.getResource(item.getImage()));
        setIcon(icon);

        Dimension size = getPreferredSize();
        setBounds(1000,500, size.width, size.height);

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

}
