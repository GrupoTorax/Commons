
package org.torax.commons;

/**
 *
 * @author Nícolas Pohren
 */
public class ImageFactory {

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
    
}
