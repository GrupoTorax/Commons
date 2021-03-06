package org.paim.commons;

import java.awt.image.BufferedImage;

/**
 * Image factory
 */
public class ImageFactory {

    /**
     * Creates a new image
     *
     * @param baseImage
     * @return Image
     */
    public static Image buildRGBImage(BufferedImage baseImage) {
        Image image = ImageFactory.
                buildEmptyImage(Image.CHANNELS_RGB,
                        baseImage.getWidth(),
                        baseImage.getHeight(),
                        new Range(0, 255));
        for (int x = 0; x < baseImage.getWidth(); x++) {
            for (int y = 0; y < baseImage.getHeight(); y++) {
                int value = baseImage.getRGB(x, y);
                image.set(Image.CHANNEL_RED, x, y, (value >> 16 & 0xFF));
                image.set(Image.CHANNEL_GREEN, x, y, (value >> 8 & 0xFF));
                image.set(Image.CHANNEL_BLUE, x, y, (value & 0xFF));
            }
        }
        return image;
    }

    /**
     * Creates a new empty image with an existing image configuration
     *
     * @param baseImage
     * @return Image
     */
    public static Image buildImage(Image baseImage) {
        return new Image(baseImage);
    }
    
    /**
     * Creates a new empty image with an existing image configuration
     *
     * @param baseImage
     * @return Image
     */
    public static Image buildEmptyImage(Image baseImage) {
        return buildEmptyImage(baseImage.getChannelCount(), baseImage.getWidth(), baseImage.getHeight(), baseImage.getPixelValueRange());
    }

    /**
     * Creates a new empty image
     *
     * @param channels
     * @param width
     * @param height
     * @param pixelRange
     * @return Image
     */
    public static Image buildEmptyImage(int channels, int width, int height, Range<Integer> pixelRange) {
        return new Image(new int[channels][width][height], pixelRange);
    }

    /**
     * Creates a new empty image
     *
     * @return Image
     */
    public static Image buildEmptyImage() {
        return buildEmptyImage(1, 1, 1, new Range<>(0, 1));
    }
    
    /**
     * Creates a new BinaryImage
     * 
     * @param width
     * @param height
     * @return BinaryImage
     */
    public static BinaryImage buildBinaryImage(int width, int height) {
        return new BinaryImage(buildEmptyImage(1, width, height, new Range<>(0, 1)));
    }

}
