package backend.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Portal {
    private final List<String> toIds;
    private final List<String> items;

    @JsonCreator
    public Portal(@JsonProperty("to") List<String> to, @JsonProperty("items") List<String> items) {
        this.toIds = to;
        this.items = items;
    }

    public List<String> getToIds() {
        return toIds;
    }

    public List<String> getItems() {
        return items;
    }
}
