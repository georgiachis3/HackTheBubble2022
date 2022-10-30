package backend.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item extends SceneObject {

    @JsonCreator
    public Item(
            @JsonProperty("name") String name,
            @JsonProperty("image") String image,
            @JsonProperty("x") int x,
            @JsonProperty("y") int y) {
        super(name, image, x, y);
    }
}
