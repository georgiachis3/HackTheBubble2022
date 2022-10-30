package frontend;

import backend.Game;
import backend.GameObjectStore;
import backend.objects.Dialogue;
import backend.objects.Item;
import exceptions.NoSuchGameObjectException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JDialogue extends JButton {
    private final String dialogueId;
    private final Container parentElement;
    private ArrayList<String> dialogueList = new ArrayList<String>();

    public JDialogue(String dialogueId, Container parentElement) throws NoSuchGameObjectException {
        super("");
        this.dialogueId = dialogueId;
        this.parentElement = parentElement;
        Dialogue dialogue = GameObjectStore.getInstance().getDialogueById(dialogueId);

        Dimension size = getPreferredSize();
        setBounds(0,800, Config.SCREEN_WIDTH, 100);
        setFont(new Font("Sans-Serif", Font.PLAIN, 24));

        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);

        dialogueList = (ArrayList<String>) dialogue.getText();

        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                nextDialogue();
            }
        });

        nextDialogue();
    }

    private void nextDialogue() {
        if (dialogueList.size() == 0) {
            parentElement.remove(this);
            return;
        }
        setText(dialogueList.get(0));
        dialogueList.remove(0);

    }

}