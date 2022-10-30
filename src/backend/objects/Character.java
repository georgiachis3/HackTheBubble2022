package backend.objects;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Character extends SceneObject {

    private final List<String> dialogueIds;

    @JsonCreator
    public Character(
            @JsonProperty("name") String name,
            @JsonProperty("image") String image,
            @JsonProperty("x") int x,
            @JsonProperty("y") int y,
            @JsonProperty("dialogues") List<String> dialogueIds) {
        super(name, image, x, y); {
            this.dialogueIds = dialogueIds;
        }
    }
}
