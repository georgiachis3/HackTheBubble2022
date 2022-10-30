import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Game {

    public static void main(String[] args) throws IOException {
        byte[] jsonData = Files.readAllBytes(Path.of("game.json"));

        ObjectMapper objectMapper = new ObjectMapper();

        Item item = objectMapper.readValue(jsonData, Item.class);

        System.out.println(item.getId());
    }

}
