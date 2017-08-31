package org.paim.commons;

import org.paim.commons.ArrayHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of class ArrayHelperTest
 */
public class ArrayHelperTest {

    /**
     * Test the copy method with unidimensional arrays
     */
    @Test
    public void testUnidimensionalCopy() {
        int[] array = new int[] {1, 2, 3};
        int[] copy = ArrayHelper.copy(array);
        //
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
        assertEquals(1, copy[0]);
        assertEquals(2, copy[1]);
        assertEquals(3, copy[2]);
        //
        copy[0] = 4;
        copy[1] = 5;
        copy[2] = 6;
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
        assertEquals(4, copy[0]);
        assertEquals(5, copy[1]);
        assertEquals(6, copy[2]);
    }
    
    /**
     * Test the copy method with bidimensional arrays
     */
    @Test
    public void testBidimensionalCopy() {
        int[][] array = new int[][] {{1, 2}, {3, 4}};
        int[][] copy = ArrayHelper.copy(array);
        //
        assertEquals(1, array[0][0]);
        assertEquals(2, array[0][1]);
        assertEquals(3, array[1][0]);
        assertEquals(4, array[1][1]);
        assertEquals(1, copy[0][0]);
        assertEquals(2, copy[0][1]);
        assertEquals(3, copy[1][0]);
        assertEquals(4, copy[1][1]);
        //
        copy[0][0] = 4;
        copy[0][1] = 5;
        copy[1][0] = 6;
        copy[1][1] = 7;
        //
        assertEquals(1, array[0][0]);
        assertEquals(2, array[0][1]);
        assertEquals(3, array[1][0]);
        assertEquals(4, array[1][1]);
        assertEquals(4, copy[0][0]);
        assertEquals(5, copy[0][1]);
        assertEquals(6, copy[1][0]);
        assertEquals(7, copy[1][1]);
    }
    
    /**
     * Test the copy method with tridimensional arrays
     */
    @Test
    public void testTridimensionalCopy() {
        int[][][] array = new int[][][] {{{1, 2}, {3, 4}}, {{5}}};
        int[][][] copy = ArrayHelper.copy(array);
        //
        assertEquals(1, array[0][0][0]);
        assertEquals(2, array[0][0][1]);
        assertEquals(3, array[0][1][0]);
        assertEquals(4, array[0][1][1]);
        assertEquals(5, array[1][0][0]);
        assertEquals(1, copy[0][0][0]);
        assertEquals(2, copy[0][0][1]);
        assertEquals(3, copy[0][1][0]);
        assertEquals(4, copy[0][1][1]);
        assertEquals(5, copy[1][0][0]);
        //
        copy[0][0][0] = 4;
        copy[0][0][1] = 5;
        copy[0][1][0] = 6;
        copy[0][1][1] = 7;
        copy[1][0][0] = 8;
        //
        assertEquals(1, array[0][0][0]);
        assertEquals(2, array[0][0][1]);
        assertEquals(3, array[0][1][0]);
        assertEquals(4, array[0][1][1]);
        assertEquals(5, array[1][0][0]);
        assertEquals(4, copy[0][0][0]);
        assertEquals(5, copy[0][0][1]);
        assertEquals(6, copy[0][1][0]);
        assertEquals(7, copy[0][1][1]);
        assertEquals(8, copy[1][0][0]);
    }
    
}
