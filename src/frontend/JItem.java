package frontend;

import backend.Game;
import backend.GameObjectStore;
import backend.objects.Item;
import exceptions.NoSuchGameObjectException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JItem extends JButton {
    private final String itemId;
    private final JFrame frame;

    public JItem(String itemId, JFrame frame) throws NoSuchGameObjectException {
        super("");
        this.itemId = itemId;
        this.frame = frame;
        Item item = GameObjectStore.getInstance().getItemById(itemId);

        ImageIcon icon = new ImageIcon(Game.getResource(item.getImage()));
        setIcon(icon);

        Dimension size = getPreferredSize();
        setBounds(item.getX(),item.getY(), size.width, size.height);

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);

        addActionListener(this::clickHandler);
    }

    private void clickHandler(ActionEvent e) {
        try {
            Game.getInstance().getPlayer().addItem(itemId);
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }
}
