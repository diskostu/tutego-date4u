package de.diskostu.demo.date4u.photo;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

/**
 * from https://gist.github.com/ullenboom/829b30521d9931268a59387e650dfdcc
 */
@Service
public class AwtBicubicThumbnail implements Thumbnail {
    private static BufferedImage create(BufferedImage source,
                                        int width, int height) {
        double thumbRatio = (double) width / height;
        double imageRatio = (double) source.getWidth() / source.getHeight();
        if (thumbRatio < imageRatio)
            height = (int) (width / imageRatio);
        else
            width = (int) (height * imageRatio);
        BufferedImage thumb = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = thumb.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.drawImage(source, 0, 0, width, height, null);
        g2.dispose();
        return thumb;
    }


    @Override
    public byte[] thumbnail(byte[] imageBytes) {
        try (InputStream is = new ByteArrayInputStream(imageBytes);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(create(ImageIO.read(is), 200, 200), "jpg", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
