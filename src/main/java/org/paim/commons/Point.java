package org.paim.commons;

/**
 * A point in the image
 */
public class Point {
    
    /** X poition */
    public final int x;
    /** Y position */
    public final int y;

    /**
     * Creates a new point
     * @param x
     * @param y 
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Distance between points
     * 
     * @param another
     * @return int
     */
    public double distance(Point another) {
        int dx = another.x - x;
        int dy = another.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "Point{" + x + ", " + y + '}';
    }
    
}
