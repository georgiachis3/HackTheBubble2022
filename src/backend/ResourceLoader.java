package backend;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ResourceLoader {
    private ResourceLoader instance = null;

    public ResourceLoader getInstance() {
        if (instance == null) {
            instance = new ResourceLoader();
        }

        return instance;
    }

    private ResourceLoader() {}

    private BufferedImage getImage(String path) throws IOException {
        URL resourcePath = this.getClass().getResource(path);
        if (resourcePath == null) {
            throw new IOException();
        }
        return ImageIO.read(resourcePath);
    }
}
