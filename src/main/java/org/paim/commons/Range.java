package org.paim.commons;

import java.util.Objects;

/**
 * Range of values
 *
 * @param <T>
 */
public class Range<T extends Number> {

    /** Length - Binary image */
    private static final int LENGTH_BINARY = 2;
    /** Length - RGB image */
    private static final int LENGTH_RGB = 256;
    /** Length - DICOM image */
    private static final int LENGTH_DICOM = 8001;
    
    /** Lower boundary */
    private final T lower;
    /** Higher boundary */
    private final T higher;

    /**
     * Creates a new range based on another Range
     *
     * @param range
     */
    public Range(Range<T> range) {
        this(range.lower, range.higher);
    }

    /**
     * Creates a new range
     *
     * @param lower
     * @param higher
     */
    public Range(T lower, T higher) {
        this.lower = lower;
        this.higher = higher;
    }

    /**
     * Returns the lower boundary of the range
     *
     * @return T
     */
    public T getLower() {
        return lower;
    }

    /**
     * Returns the higher boundary of the range
     *
     * @return T
     */
    public T getHigher() {
        return higher;
    }

    /**
     * Limits the value in this range
     *
     * @param value
     * @return T
     */
    public T limit(T value) {
        if (value.doubleValue() > higher.doubleValue()) {
            return higher;
        }
        if (value.doubleValue() < lower.doubleValue()) {
            return lower;
        }
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.lower);
        hash = 53 * hash + Objects.hashCode(this.higher);
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
        final Range<?> other = (Range<?>) obj;
        if (!Objects.equals(this.lower, other.lower)) {
            return false;
        }
        return Objects.equals(this.higher, other.higher);
    }

    @Override
    public String toString() {
        return "Range{" + "lower=" + lower + ", higher=" + higher + '}';
    }

    /**
     * Returns the length of the range
     *
     * @return double
     */
    public double getLength() {
        return higher.doubleValue() - lower.doubleValue() + 1;
    }

    /**
     * Returns true if the length is binary
     * 
     * @return boolean
     */
    public boolean isBinary() {
        return getLength() == LENGTH_BINARY;
    }

    /**
     * Returns true if the length is RGB
     * 
     * @return boolean
     */
    public boolean isRGB() {
        return getLength() == LENGTH_RGB;
    }

    /**
     * Returns true if the length is DICOM
     * 
     * @return boolean
     */
    public boolean isDICOM() {
        return getLength() == LENGTH_DICOM;
    }
    
}
