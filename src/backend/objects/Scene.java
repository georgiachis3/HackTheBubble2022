package backend.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Scene {
    private final String name;
    private final List<String> itemIds;
    private final List<String> characterIds;
    private final String backgroundImage;
    private final List<String> dialogueIds;
    private final String portal;

    @JsonCreator
    public Scene(@JsonProperty("name") String name,
                 @JsonProperty("items") List<String> items,
                 @JsonProperty("characters") List<String> characters,
                 @JsonProperty("background-image") String backgroundImage,
                 @JsonProperty("dialogues") List<String> dialogueIds,
                 @JsonProperty("portal") String portal) {
        this.name = name;
        this.itemIds = items;
        this.characterIds = characters;
        this.backgroundImage = backgroundImage;
        this.dialogueIds = dialogueIds;
        this.portal = portal;
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

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public List<String> getDialogueIds() {
        return dialogueIds;
    }

    public String getPortal() {
        return portal;
    }
}
