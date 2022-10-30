package frontend;

import backend.Game;
import backend.GameObjectStore;
import backend.objects.Character;
import exceptions.NoSuchGameObjectException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JCharacter extends JButton {
    private final String characterId;
    private final String dialogueId;
    private final Container frame;

    public JCharacter(String characterId, Container frame) throws NoSuchGameObjectException {
        super("");
        this.characterId = characterId;
        this.frame = frame;
        Character character = GameObjectStore.getInstance().getCharacterById(characterId);
        dialogueId = character.getDialogueId();

        ImageIcon icon = new ImageIcon(Game.getResource(character.getImage()));
        setIcon(icon);

        Dimension size = getPreferredSize();
        setBounds(character.getX(),character.getY(), size.width, size.height);

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);

        addActionListener(this::clickHandler);
    }

    public void clickHandler(ActionEvent e) {
        try {
            JDialogue jDialogue = new JDialogue(dialogueId, frame);
            frame.add(jDialogue);
        } catch (NoSuchGameObjectException err) {}
    }

}
