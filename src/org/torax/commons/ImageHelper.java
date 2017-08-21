package org.torax.commons;

/**
 * Helper class to work with images
 */
public class ImageHelper {
    
    /**
     * Creates a image representation
     * 
     * @param data Image data
     * @param range Image range
     * @return Image
     */
    public static Image create(int[][] data, Range<Integer> range) {
        int[][][] dataImage = new int[1][data.length][data[0].length];
        dataImage[0] = data;
        return new Image(dataImage, range);
    }
    
    /**
     * Creates a image representation
     * 
     * @param image Image
     * @param range Image range
     * @return Image
     */
    public static Image create(Image image, Range<Integer> range) {
        return new Image(ArrayHelper.copy(image.getData()), range);
    }

    /**
     * Returns the image data
     * 
     * @param image Image representation
     * @return int[][]
     */
    public static int[][] getData(Image image) {
        return image.getData()[0];
    }

}
