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
    private final Container frame;
    private final Runnable sceneClickHandler;

    public JItem(String itemId, Container frame) throws NoSuchGameObjectException {
        super("");
        this.itemId = itemId;
        this.frame = frame;
        this.sceneClickHandler = sceneClickHandler;
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
            //JDialogue jDialogue = new JDialogue("dialogue-inv", frame);
            //frame.add(jDialogue);
            frame.remove(this);
            frame.invalidate();
            frame.validate();
            frame.repaint();
            sceneClickHandler.run();
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }
}
