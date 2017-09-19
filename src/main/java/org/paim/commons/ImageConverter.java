package org.paim.commons;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Class for converting an image to other formats
 */
public class ImageConverter {
    
    /**
     * Converts a image to a buffered image
     * 
     * @param image
     * @return BufferedImage
     */
    public static BufferedImage toBufferedImage(Image image) {
        if (image == null) {
            return new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        }
        BufferedImage buff = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int r, g, b;
                if (image.getChannelCount() == Image.CHANNELS_RGB) {
                    r = image.get(Image.CHANNEL_RED, x, y);
                    g = image.get(Image.CHANNEL_GREEN, x, y);
                    b = image.get(Image.CHANNEL_BLUE, x, y);
                } else {
                    r = image.get(0, x, y);
                    g = image.get(0, x, y);
                    b = image.get(0, x, y);
                }
                buff.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
        return buff;
    }
    
}
