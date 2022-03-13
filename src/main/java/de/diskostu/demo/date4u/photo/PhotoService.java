package de.diskostu.demo.date4u.photo;

import java.util.Optional;

public interface PhotoService {

    Optional<byte[]> download(String imageName);

    String upload(byte[] imageBytes);
}
