package backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.NoSuchGameObjectException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Game {

    public static void main(String[] args) throws IOException, NoSuchGameObjectException {
        byte[] jsonData = Files.readAllBytes(Path.of("game.json"));

        ObjectMapper objectMapper = new ObjectMapper();

        GameObjectStore objectStore = objectMapper.readValue(jsonData, GameObjectStore.class);

        System.out.println(objectStore.getItemById("item-1").getName());
    }

}
