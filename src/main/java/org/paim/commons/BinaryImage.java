package org.paim.commons;

/**
 * Binary image
 */
public class BinaryImage extends Image {
    
    public BinaryImage(Image image) {
        super(image);
    }

    public void set(int x, int y, boolean value) {
        super.set(0, x, y, value ? 1 : 0);
    }
    
    public boolean get(int x, int y) {
        return super.get(0, x, y) == 1;
    }
    
    /**
     * Returns a new binary image that is the difference of this image with the specified one
     * 
     * @param image
     * @return BinaryImage
     */
    public BinaryImage difference(BinaryImage image) {
        BinaryImage output = ImageFactory.buildBinaryImage(getWidth(), getHeight());
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                output.set(x, y, get(x, y) && !image.get(x, y));
            }
        }
        return output;
    }
    
}
