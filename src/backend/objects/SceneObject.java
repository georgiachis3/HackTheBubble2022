package backend.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SceneObject {
    private final String name;
    private final String image;
    private final int x;
    private final int y;

    @JsonCreator
    public SceneObject(@JsonProperty("name") String name, @JsonProperty("image") String image, @JsonProperty("x") int x, @JsonProperty("y") int y) {
        this.name = name;
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
