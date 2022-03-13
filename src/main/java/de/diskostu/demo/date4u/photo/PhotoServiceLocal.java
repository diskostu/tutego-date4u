package de.diskostu.demo.date4u.photo;

import de.diskostu.demo.date4u.FileSystem;
import org.springframework.stereotype.Service;

import java.io.UncheckedIOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhotoServiceLocal implements PhotoService {

    private final FileSystem fileSystem;
    private final Thumbnail thumbnail;


    public PhotoServiceLocal(FileSystem fileSystem, Thumbnail thumbnail) {
        this.fileSystem = fileSystem;
        this.thumbnail = thumbnail;
    }


    public Optional<byte[]> download(String imageName) {
        try {
            return Optional.of(fileSystem.load(imageName + ".jpg"));
        } catch (UncheckedIOException e) {
            return Optional.empty();
        }
    }


    @Override
    public String upload(byte[] imageBytes) {
        String imageName = UUID.randomUUID().toString();

        // First: store original image
        fileSystem.store(imageName + ".jpg", imageBytes);

        // Second: store thumbnail
        byte[] thumbnailBytes = thumbnail.thumbnail(imageBytes);
        fileSystem.store(imageName + "-thumb.jpg", thumbnailBytes);

        return imageName;
    }
}
