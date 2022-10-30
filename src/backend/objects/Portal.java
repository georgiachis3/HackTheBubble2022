package backend.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Portal {
    private final List<String> toIds;

    @JsonCreator
    public Portal(@JsonProperty("to") List<String> to) {
        this.toIds = to;
    }

    public List<String> getToIds() {
        return toIds;
    }
}
