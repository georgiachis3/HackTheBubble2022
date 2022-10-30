package backend.objects;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Character extends SceneObject {

    private final String dialogue;

    @JsonCreator
    public Character(
            @JsonProperty("name") String name,
            @JsonProperty("image") String image,
            @JsonProperty("x") int x,
            @JsonProperty("y") int y,
            @JsonProperty("dialogues") String dialogue) {
        super(name, image, x, y); {
            this.dialogue = dialogue;
        }
    }

    public String getDialogueId() {
        return dialogue;
    }
}
