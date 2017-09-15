package org.paim.commons;

import java.awt.image.BufferedImage;

/**
 * Converts image with window level and window width
 */
public class ConverterWLWW {

    /**
     * Converts the image
     *
     * @param image
     * @param WL
     * @param WW
     * @return BuufferedImage
     */
    public static BufferedImage getBufferedImage(Image image, int WL, int WW) {
        return getBufferedImage(ArrayHelper.copy(image.getData())[0], WL, WW);
    }

    /**
     * Converts the image
     *
     * @param coefficientMatrix
     * @param WL
     * @param WW
     * @return BuufferedImage
     */
    public static BufferedImage getBufferedImage(int[][] coefficientMatrix, int WL, int WW) {
        int minValue = WL - (WW / 2);
        int maxValue = WL + (WW / 2);
        int offset = -minValue;
        minValue += offset;
        maxValue += offset;
        for (int x = 0; x < coefficientMatrix.length; x++) {
            for (int y = 0; y < coefficientMatrix[0].length; y++) {
                if (coefficientMatrix[x][y] > 10000) {
                    coefficientMatrix[x][y] = -2000;
                }
                coefficientMatrix[x][y] += offset;
                if (coefficientMatrix[x][y] < minValue) {
                    coefficientMatrix[x][y] = 0;
                } else if (coefficientMatrix[x][y] >= maxValue) {
                    coefficientMatrix[x][y] = 255;
                } else {
                    coefficientMatrix[x][y] = coefficientMatrix[x][y] * 256 / maxValue;
                }
            }
        }
        BufferedImage image = new BufferedImage(coefficientMatrix.length, coefficientMatrix[0].length, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                image.setRGB(x, y, getPixelValue(coefficientMatrix[x][y]));
            }
        }
        return image;
    }

    private static int getPixelValue(int pixel) {
        return (int) pixel << 16 | (int) pixel << 8 | (int) pixel;
    }

}
