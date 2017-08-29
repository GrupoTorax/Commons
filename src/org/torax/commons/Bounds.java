package org.torax.commons;

/**
 * Bounds of something in a image
 */
public class Bounds {

    /** X poition */
    public final int x;
    /** Y position */
    public final int y;
    /** Width */
    public final int width;
    /** Height */
    public final int height;

    /**
     * Creates a new Bounds
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    public Bounds(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    /**
     * Computes and return the center of the bounds
     * 
     * @return Point
     */
    public Point center() {
        return new Point(x + (width / 2), y + (height / 2));
    }
    
}
