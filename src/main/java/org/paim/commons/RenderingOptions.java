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
        dicomWindowLevel = DicomWindow.LUNGS.getWindowLevel();
        dicomWindowWidth = DicomWindow.LUNGS.getWindowWidth();
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
