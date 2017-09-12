package org.paim.commons;

/**
 * Binary image
 */
public class BinaryImage extends Image {

    /** Cached bounds */
    private Bounds bounds;

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
     * Returns a new binary image that is the difference of this image with the
     * specified one
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

    /**
     * Returns a new binary image that is the intersection of this image with
     * the specified one
     *
     * @param image
     * @return BinaryImage
     */
    public BinaryImage intersection(BinaryImage image) {
        BinaryImage output = ImageFactory.buildBinaryImage(getWidth(), getHeight());
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                output.set(x, y, get(x, y) && image.get(x, y));
            }
        }
        return output;
    }

    /**
     * Returns a new binary image that is the union of this image with the
     * specified one
     *
     * @param image
     * @return BinaryImage
     */
    public BinaryImage union(BinaryImage image) {
        BinaryImage output = ImageFactory.buildBinaryImage(getWidth(), getHeight());
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                output.set(x, y, get(x, y) || image.get(x, y));
            }
        }
        return output;
    }

    /**
     * Returns the bounds of the object
     *
     * @return Bounds
     */
    public Bounds getBounds() {
        if (bounds == null) {
            int x1 = Integer.MAX_VALUE;
            int y1 = Integer.MAX_VALUE;
            int x2 = 0;
            int y2 = 0;
            for (int x = 0; x < getWidth(); x++) {
                for (int y = 0; y < getHeight(); y++) {
                    if (!get(x, y)) {
                        continue;
                    }
                    if (x < x1) {
                        x1 = x;
                    }
                    if (x > x2) {
                        x2 = x;
                    }
                    if (y < y1) {
                        y1 = y;
                    }
                    if (y > y2) {
                        y2 = y;
                    }
                }
            }
            this.bounds = new Bounds(x1, y1, x2 - x1, y2 - y1);
        }
        return bounds;
    }

}
