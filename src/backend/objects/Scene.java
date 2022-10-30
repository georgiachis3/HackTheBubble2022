package backend.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Scene {
    private final String name;
    private final List<String> items;

    @JsonCreator
    public Scene(@JsonProperty("name") String name, @JsonProperty("items") List<String> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }
}
