package backend.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item extends SceneObject {

    public Item(String name, String image, int x, int y) {
        super(name, image, x, y);
    }
}
