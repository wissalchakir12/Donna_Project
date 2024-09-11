package org.example.donnabackend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageUtil {
    public static byte[] convertImageToBytes(String imagePath) throws IOException {
        Path path = Path.of(imagePath);
        return Files.readAllBytes(path);
    }
}
