package org.paim.commons;

/**
 * A point in the image
 */
public class Point {
    
    /** Center of the image */
    public static final Point CENTER = new Point(-99999, -99999);
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
     * Compute relative points to absolute point
     * 
     * @param image
     * @return Point
     */
    public Point compute(Image image) {
        if (this.equals(CENTER)) {
            int x = image.getWidth() / 2;
            int y = image.getHeight() / 2;
            return new Point(x, y);
        }
        return this; 
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
    
    /**
     * Returns the point to the north
     * 
     * @return Point
     */
    public Point north() {
        return new Point(x, y - 1);
    }
    
    /**
     * Returns the point to the south
     * 
     * @return Point
     */
    public Point south() {
        return new Point(x, y + 1);
    }
    
    /**
     * Returns the point to the east
     * 
     * @return Point
     */
    public Point east() {
        return new Point(x + 1, y);
    }

    /**
     * Returns the point to the west
     * 
     * @return Point
     */
    public Point west() {
        return new Point(x - 1, y);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.x;
        hash = 29 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Point{" + x + ", " + y + '}';
    }
    
}
