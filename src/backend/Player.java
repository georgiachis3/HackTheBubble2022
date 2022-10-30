package backend;


import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<String> inventory;

    public Player() {
        inventory = new ArrayList<>();
    }

    public boolean hasItem(String itemId) {
        return inventory.contains(itemId);
    }

    public void removeItem(String itemId) {
        inventory.remove(itemId);
    }

    public void addItem(String itemId) {
        inventory.add(itemId);
    }
}
