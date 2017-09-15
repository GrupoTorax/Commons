package org.paim.commons;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;

/**
 * An exam slice representation
 */
public class ExamSlice {
    
    private BufferedImage bufferedImage;
    private File sourceFile;
    private int columns;
    private int rows;
    private boolean padded;
    private int padValue;
    private double rescaleSlope;
    private double rescaleIntercept;
    private float sliceThickness;

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
    
    // REVISAR MÉTODO(TALVEZ POSSA SER UM ATRIBUTO, TALVEZ NÃO)
    public int[][] getCoefficientMatrix() {
        return converteHU(getBufferedImage().getRaster(), 
                          getRescaleIntercept(),
                          getRescaleSlope(),
                          isPadded(),
                          getPadValue());
    }            
                
    // REVISAR MÉTODO
    private int[][] converteHU(WritableRaster raster, double rescaleIntercept, double rescaleSlope, boolean isPadded, int padValue) {
        int[][] matrizHU = new int[raster.getWidth()][raster.getHeight()];
        for (int x = 0; x < matrizHU.length; x++) {
            for (int y = 0; y < matrizHU[x].length; y++) {
                if (isPadded && raster.getPixel(x, y, new int[1])[0] == padValue) {
                    matrizHU[x][y] = padValue;
                } else {
                    matrizHU[x][y] = (int)(raster.getPixel(x, y, new double[1])[0] * rescaleSlope + rescaleIntercept);
                }
            }
        }
        return matrizHU;
    }
    
    //REVISAR MÉTODO
    public BufferedImage getBufferedImageWithWLWW(int WL, int WW) {
        int[][] coefficientMatrix = getCoefficientMatrix();
        return ConverterWLWW.getBufferedImage(coefficientMatrix, WL, WW);
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public boolean isPadded() {
        return padded;
    }

    public void setPadded(boolean padded) {
        this.padded = padded;
    }

    public int getPadValue() {
        return padValue;
    }

    public void setPadValue(int padValue) {
        this.padValue = padValue;
    }

    public double getRescaleSlope() {
        return rescaleSlope;
    }

    public void setRescaleSlope(double rescaleSlope) {
        this.rescaleSlope = rescaleSlope;
    }

    public double getRescaleIntercept() {
        return rescaleIntercept;
    }

    public void setRescaleIntercept(double rescaleIntercept) {
        this.rescaleIntercept = rescaleIntercept;
    }

    public float getSliceThickness() {
        return sliceThickness;
    }

    public void setSliceThickness(float sliceThickness) {
        this.sliceThickness = sliceThickness;
    }

    /**
     * Returns the size of the slice
     * 
     * @return Dimension
     */
    public Dimension getSize() {
        return new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight());
    }
    
}
