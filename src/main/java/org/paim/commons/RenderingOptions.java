/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.paim.commons;

/**
 * Rendering options
 */
public class RenderingOptions {
    
    /** DICOM window level */
    private int dicomWindowLevel;
    /** DICOM window width */
    private int dicomWindowWidth;

    /**
     * Creates a new set of rendering options
     */
    public RenderingOptions() {
        dicomWindowLevel = -400;
        dicomWindowWidth = 1500;
    }    
    
    /**
     * Returns the DICOM window level
     * 
     * @return int
     */
    public int getDicomWindowLevel() {
        return dicomWindowLevel;
    }

    /**
     * Sets the DICOM window level
     * 
     * @param dicomWindowLevel 
     */
    public void setDicomWindowLevel(int dicomWindowLevel) {
        this.dicomWindowLevel = dicomWindowLevel;
    }

    /**
     * Returns the DICOM window width
     * 
     * @return int
     */
    public int getDicomWindowWidth() {
        return dicomWindowWidth;
    }

    /**
     * Sets the DICOM window width
     * 
     * @param dicomWindowWidth 
     */
    public void setDicomWindowWidth(int dicomWindowWidth) {
        this.dicomWindowWidth = dicomWindowWidth;
    }
    
}
