package org.torax.commons;

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
                          (int) getRescaleIntercept(),
                          (int) getRescaleSlope(),
                          isPadded(),
                          getPadValue());
    }            
                
    // REVISAR MÉTODO
    private int[][] converteHU(WritableRaster raster, int rescaleIntercept, int rescaleSlope, boolean isPadded, int padValue) {
        int[][] matrizHU = new int[raster.getWidth()][raster.getHeight()];
        for (int x = 0; x < matrizHU.length; x++) {
            for (int y = 0; y < matrizHU[x].length; y++) {
                if (isPadded && raster.getPixel(x, y, new int[1])[0] == padValue) {
                    matrizHU[x][y] = padValue;
                } else {
                    matrizHU[x][y] = raster.getPixel(x, y, new int[1])[0] * rescaleSlope + rescaleIntercept;
                }
            }
        }
        return matrizHU;
    }
    
    //REVISAR MÉTODO
    public BufferedImage getBufferedImageWithWLWW(int WL, int WW) {
        int[][] coefficientMatrix = getCoefficientMatrix();
        int minValue = WL - (WW / 2);
        int maxValue = WL + WW / 2;
        int offset = - minValue;
        
        minValue += offset;
        maxValue += offset;
        
        for (int x = 0; x < coefficientMatrix.length; x++) {
            for (int y = 0; y < coefficientMatrix[0].length; y++) {
                if (coefficientMatrix[x][y] > 10000)  {
                    coefficientMatrix[x][y] = -2000;
                }
                    
                
                coefficientMatrix[x][y] += offset;
                if (coefficientMatrix[x][y] < minValue) {
                    coefficientMatrix[x][y] = 0;
                } else if (coefficientMatrix[x][y] > maxValue) {
                    coefficientMatrix[x][y] = 255;
                } else {
                    coefficientMatrix[x][y] = coefficientMatrix[x][y] * 256 / maxValue;
                }
            }
        }

        BufferedImage image = new BufferedImage(coefficientMatrix.length, coefficientMatrix[0].length, BufferedImage.TYPE_BYTE_GRAY);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                image.setRGB(x, y, getPixelValue(coefficientMatrix[x][y]));
            }
        }
        return image;
    }

    private int getPixelValue(int pixel) {
        return (int) pixel << 16 | (int) pixel << 8 | (int) pixel;
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
    
}
