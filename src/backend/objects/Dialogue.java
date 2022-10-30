package backend.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Dialogue {
    private final List<String> text;

    @JsonCreator
    public Dialogue(@JsonProperty("text") List<String> text) {
        this.text = text;
    }


}
