package de.diskostu.demo.date4u.shell;

import de.diskostu.demo.date4u.photo.PhotoService;
import org.springframework.boot.ImageBanner;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Optional;

@ShellComponent
public class PhotoCommands {

    private final PhotoService photoService;


    public PhotoCommands(PhotoService photoService) {
        this.photoService = photoService;
    }


    @ShellMethod("show photo")
    void showPhoto(String imageName) {
        final Optional<byte[]> maybeBytes = photoService.download(imageName);
        maybeBytes.ifPresentOrElse(bytes -> new ImageBanner(new ByteArrayResource(bytes))
                        .printBanner(new StandardEnvironment(), null, System.out),
                () -> System.out.println("Unknown photo: " + imageName));
    }
}
