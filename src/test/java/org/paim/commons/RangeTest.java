package org.paim.commons;

import org.paim.commons.Range;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of class Range
 */
public class RangeTest {
    
    /**
     * Test of getLength method, of class Range
     */
    @Test
    public void testGetLength() {
        assertEquals(1, (int) new Range<>(0, 0).getLength(), 0);
        assertEquals(101, (int) new Range<>(0, 100).getLength(), 0);
        assertEquals(101, (int) new Range<>(-100, 0).getLength(), 0);
        assertEquals(201, (int) new Range<>(-100, 100).getLength(), 0);
    }
    
}
