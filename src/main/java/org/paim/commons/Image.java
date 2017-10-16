package org.paim.commons;

/**
 * Image representation
 */
public class Image {

    /** Number of channels for RGB images */
    public static final int CHANNELS_RGB = 3;
    /** Number of channels for gray scale images */
    public static final int CHANNELS_GRAYSCALE = 1;
    /** Channel - Red */
    public static final int CHANNEL_RED = 0;
    /** Channel - Green */
    public static final int CHANNEL_GREEN = 1;
    /** Channel - Blue */
    public static final int CHANNEL_BLUE = 2;
    /** Channel - Gray (For gray scales) */
    public static final int CHANNEL_GRAY = 0;

    /** Image data */
    private final int[][][] data;
    /** Range of possible values in a pixel */
    private final Range<Integer> pixelRange;

    /**
     * Creates a new image based on another image
     *
     * @param image
     */
    public Image(Image image) {
        this(image.data, image.pixelRange);
    }

    /**
     * Creates a new image
     *
     * @param data
     * @param pixelRange
     */
    public Image(int[][][] data, Range<Integer> pixelRange) {
        this(data, pixelRange, false);
    }

    /**
     * Creates a new image
     *
     * @param data
     * @param pixelRange
     * @param shareData
     */
    protected Image(int[][][] data, Range<Integer> pixelRange, boolean shareData) {
        if (!shareData) {
            data = ArrayHelper.copy(data);
        }
        this.data = data;
        this.pixelRange = pixelRange;
    }

    /**
     * Returns a pixel value
     *
     * @param channel
     * @param x
     * @param y
     * @return int
     */
    public int get(int channel, int x, int y) {
        return data[channel][x][y];
    }

    /**
     * Set a pixel value
     *
     * @param channel
     * @param x
     * @param y
     * @param value
     */
    public void set(int channel, int x, int y, int value) {
        data[channel][x][y] = value;
    }

    /**
     * Returns true if the image has a pixel
     *
     * @param channel
     * @param x
     * @param y
     * @return boolean
     */
    public boolean has(int channel, int x, int y) {
        return (channel >= 0 && channel <= getChannelCount())
                && (x >= 0 && x < getWidth())
                && (y >= 0 && y < getHeight());
    }

    /**
     * Returns the image data
     *
     * @return {@code int[][][]}
     */
    public int[][][] getData() {
        return data;
    }

    /**
     * Returns the number of channels in the image
     *
     * @return int
     */
    public int getChannelCount() {
        return data.length;
    }

    /**
     * Returns true if the image is gray scale
     *
     * @return
     */
    public boolean isGrayScale() {
        return getChannelCount() == CHANNELS_GRAYSCALE;
    }

    /**
     * Returns true if the image is RGB
     *
     * @return
     */
    public boolean isRGB() {
        return getChannelCount() == CHANNELS_RGB;
    }

    /**
     * Returns the width of the image
     *
     * @return int
     */
    public int getWidth() {
        return data[0].length;
    }

    /**
     * Returns the height of the image
     *
     * @return int
     */
    public int getHeight() {
        return data[0][0].length;
    }

    /**
     * Limits the value in the image width
     * 
     * @param x
     * @return int
     */
    public int limitX(int x) {
        if (x < 0) {
            return 0;
        }
        if (x >= getWidth()) {
            return getWidth() - 1;
        }
        return x;
    }

    /**
     * Limits the value in the image height
     * 
     * @param y
     * @return 
     */
    public int limitY(int y) {
        if (y < 0) {
            return 0;
        }
        if (y >= getHeight()) {
            return getHeight() - 1;
        }
        return y;
    }

    /**
     * Returns the pixel value range
     *
     * @return {@code Range<Integer>}
     */
    public Range<Integer> getPixelValueRange() {
        return pixelRange;
    }

}
