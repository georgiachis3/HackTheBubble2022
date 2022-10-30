package backend.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Scene {
    private final String name;
    private final List<String> itemIds;
    private final List<String> characterIds;

    @JsonCreator
    public Scene(@JsonProperty("name") String name, @JsonProperty("items") List<String> items, @JsonProperty("characters") List<String> characters) {
        this.name = name;
        this.itemIds = items;
        this.characterIds = characters;
    }

    public String getName() {
        return name;
    }

    public List<String> getItemIds() {
        return itemIds;
    }

    public List<String> getCharacterIds() {
        return characterIds;
    }
}
