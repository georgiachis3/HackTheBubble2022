package backend.objects;

import backend.GameObjectStore;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import exceptions.NoSuchGameObjectException;

import java.util.List;

public class Portal {
    private final List<String> to;

    @JsonCreator
    public Portal(@JsonProperty("to") List<String> to) {
        this.to = to;
    }

    public List<String> getTo() {
        return to;
    }
}
