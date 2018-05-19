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
        return toBufferedImage(image, new RenderingOptions());
    }

    /**
     * Converts a image to a buffered image
     *
     * @param image
     * @param options
     * @return BufferedImage
     */
    public static BufferedImage toBufferedImage(Image image, RenderingOptions options) {
        if (image == null) {
            return new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        }
        if (image.getPixelValueRange().isDICOM()) {
            return ConverterWLWW.getBufferedImage(image, options.getDicomWindowLevel(), options.getDicomWindowWidth());
        }
        BufferedImage buff = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int r, g, b;
                if (image instanceof BinaryImage) {
                    r = g = b = (((BinaryImage) image).get(x, y) ? 255 : 0);
                } else if (image.getPixelValueRange().isBinary()) {
                    r = g = b = (image.get(0, x, y) == 1 ? 255 : 0);
                } else {
                    if (image.getChannelCount() == Image.CHANNELS_RGB) {
                        r = image.getPixelValueRange().limit(image.get(Image.CHANNEL_RED, x, y));
                        g = image.getPixelValueRange().limit(image.get(Image.CHANNEL_GREEN, x, y));
                        b = image.getPixelValueRange().limit(image.get(Image.CHANNEL_BLUE, x, y));
                    } else {
                        r = g = b = image.getPixelValueRange().limit(image.get(0, x, y));
                    }
                }
                buff.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
        return buff;
    }

}
