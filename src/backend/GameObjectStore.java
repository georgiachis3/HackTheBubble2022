package backend;

import backend.objects.Character;
import backend.objects.Item;
import backend.objects.Portal;
import backend.objects.Scene;
import com.fasterxml.jackson.annotation.JsonCreator;
import exceptions.NoSuchGameObjectException;

import java.util.Map;

public class GameObjectStore {
    private static GameObjectStore instance = null;

    @JsonCreator
    public static GameObjectStore getInstance() {
        if (instance == null) {
            instance = new GameObjectStore();
        }
        return instance;
    }

    private Map<String, Scene> scenes;
    private Map<String, Item> items;
    private Map<String, Character> characters;
    private Map<String, Portal> portals;

    private GameObjectStore() {}

    public void setScenes(Map<String, Scene> scenes) {
        this.scenes = scenes;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    public void setCharacters(Map<String, Character> characters) {
        this.characters = characters;
    }

    public void setPortals(Map<String, Portal> portals) {
        this.portals = portals;
    }

    public Scene getSceneById(String id) throws NoSuchGameObjectException {
        if (scenes.containsKey(id)) {
            return scenes.get(id);
        } else {
            throw new NoSuchGameObjectException();
        }
    }

    public Item getItemById(String id) throws NoSuchGameObjectException {
        if (items.containsKey(id)) {
            return items.get(id);
        } else {
            throw new NoSuchGameObjectException();
        }
    }

    public Character getCharacterById(String id) throws NoSuchGameObjectException {
        if (characters.containsKey(id)) {
            return characters.get(id);
        } else {
            throw new NoSuchGameObjectException();
        }
    }

    public Portal getPortalById(String id) throws NoSuchGameObjectException {
        if (portals.containsKey(id)) {
            return portals.get(id);
        } else {
            throw new NoSuchGameObjectException();
        }
    }
}
