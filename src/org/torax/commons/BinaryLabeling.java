package org.torax.commons;

/**
 * Binary labeling information
 */
public class BinaryLabeling {

    /** Image */
    private final Image image;
    /** Label size */
    private final int size;

    public BinaryLabeling(Image image, int size) {
        this.image = image;
        this.size = size;
    }

    /**
     * Returns the image
     *
     * @return Image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Returns the label size
     *
     * @return int
     */
    public int getSize() {
        return size;
    }

}
