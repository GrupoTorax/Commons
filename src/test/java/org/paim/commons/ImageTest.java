package org.paim.commons;

import org.paim.commons.Range;
import org.paim.commons.Image;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.paim.commons.test.ImageAssert.*;

/**
 * Unit tests of class Image
 */
public class ImageTest {
    
    /**
     * Test the image cloning
     */
    @Test
    public void testImageCloning() {
        int[][][] data = new int[][][] {
            {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
            },
            {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90},
            },
        };
        Image original = new Image(data, new Range<>(0, 100));
        Image clone = new Image(original);
        assertImage(original, clone);
        // Modifies the clone to check if the references are new as well
        clone.set(0, 0, 0, 99);
        assertEquals(1, original.get(0, 0, 0));
        assertEquals(99, clone.get(0, 0, 0));
    }

}
