package de.diskostu.demo.date4u.photo;

import de.diskostu.demo.date4u.FileSystem;
import org.springframework.stereotype.Service;

import java.io.UncheckedIOException;
import java.util.Optional;

@Service
public class PhotoServiceLocal implements PhotoService {

    private final FileSystem fileSystem;


    public PhotoServiceLocal(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }


    public Optional<byte[]> download(String imageName) {
        try {
            return Optional.of(fileSystem.load(imageName + ".jpg"));
        } catch (UncheckedIOException e) {
            return Optional.empty();
        }
    }
}
