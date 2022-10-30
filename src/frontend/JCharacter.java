package frontend;

import backend.Game;
import backend.GameObjectStore;
import backend.objects.Character;
import exceptions.NoSuchGameObjectException;

import javax.swing.*;
import java.awt.*;

public class JCharacter extends JButton {
    private final String characterId;

    public JCharacter(String characterId) throws NoSuchGameObjectException {
        super("");
        this.characterId = characterId;
        Character character = GameObjectStore.getInstance().getCharacterById(characterId);

        ImageIcon icon = new ImageIcon(Game.getResource(character.getImage()));
        setIcon(icon);

        Dimension size = getPreferredSize();
        setBounds(character.getX(),character.getY(), size.width, size.height);

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

}
