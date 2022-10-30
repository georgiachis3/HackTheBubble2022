package backend.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Portal {
    private final String toId;
    private final List<String> items;

    private final int x;
    private final int y;

    @JsonCreator
    public Portal(@JsonProperty("to") String to,
                  @JsonProperty("items") List<String> items,
                  @JsonProperty("x") int x,
                  @JsonProperty("y") int y) {
        this.toId = to;
        this.items = items;
        this.x = x;
        this.y = y;
    }

    public String getToId() {
        return toId;
    }

    public List<String> getItems() {
        return items;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
