/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.paim.commons;

import java.util.Arrays;

/**
 * Color
 */
public class Color {
    
    /** Color values */
    private final short[] value;

    /**
     * Creates a new color
     * 
     * @param value 
     */
    public Color(int... value) {
        short[] shortValue = new short[value.length];
        for (int i = 0; i < shortValue.length; i++) {
            shortValue[i] = (short) value[i];
        }
        this.value = shortValue;
    }

    /**
     * Creates a new color
     * 
     * @param value 
     */
    public Color(short[] value) {
        this.value = value;
    }
    
    /**
     * Returns the value of a channel
     * 
     * @param channel
     * @return short
     */
    public short get(int channel) {
        return this.value[channel];
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Arrays.hashCode(this.value);
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
        final Color other = (Color) obj;
        if (!Arrays.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }
    
}
