package org.paim.commons;

/**
 * DICOM window level
 */
public enum DicomWindow {

    LUNGS(-400, 1500),
    BONES(300, 1500);

    private final int windowLevel;
    private final int windowWidth;

    private DicomWindow(int windowLevel, int windowWidth) {
        this.windowLevel = windowLevel;
        this.windowWidth = windowWidth;
    }

    public int getWindowLevel() {
        return windowLevel;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

}
