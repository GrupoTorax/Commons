
package org.torax.commons;

/**
 * Histogram
 */
public class Histogram {

    /** Original range */
    private final Range originalRange;
    /** Histogram data */
    private final int[] histogram;

    /**
     * Creates a new histogram
     * 
     * @param histogram 
     * @param originalRange 
     */
    public Histogram(int[] histogram, Range originalRange) {
        this.histogram = histogram;
        this.originalRange = originalRange;
    }

    /**
     * Returns the number of occurences of the specified value
     * 
     * @param value
     * @return int
     */
    public int get(int value) {
        return histogram[value + getOffset()];
    }

    /**
     * Returns the value that has the least occurences. If multiple values have the same number of occurences,
     * returns the lowest
     * 
     * @return int
     */
    public int getValueWithLeastOccurences() {
        return getValueWithLeastOccurences(originalRange);
    }

    /**
     * Returns the value that has the least occurences inside of range. If multiple values have the same number of occurences,
     * returns the lowest
     * 
     * @param range
     * @return int
     */
    public int getValueWithLeastOccurences(Range<Integer> range) {
        int leastOccurences = range.getLower() + getOffset();
        for (int i = range.getLower() + getOffset() + 1; i <= range.getHigher() + getOffset(); i++) {
            if (histogram[i] < histogram[leastOccurences]) {
                leastOccurences = i;
            }
        }
        return leastOccurences - getOffset();
    }
    
    /**
     * Returns the offset
     * 
     * @return int
     */
    private int getOffset() {
        return (int) originalRange.getLower() * -1;
    }

}
