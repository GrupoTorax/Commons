package org.paim.commons;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Class for exporting images
 */
public class ImageExporter {
    
    /**
     * Exports an image as a buffered image and all of it's supported formats
     * 
     * @param fileName
     * @param image 
     * @throws java.io.IOException 
     */
    public static void exportBufferedImage(Image image, String fileName) throws IOException {
        exportBufferedImage(image, new File(fileName));
    }
    
    /**
     * Exports an image as a buffered image and all of it's supported formats
     * 
     * @param file
     * @param image 
     * @throws java.io.IOException 
     */
    public static void exportBufferedImage(Image image, File file) throws IOException {
        BufferedImage buffered = ImageConverter.toBufferedImage(image);
        ImageIO.write(buffered, file.getName().substring(file.getName().lastIndexOf(".") + 1), file);
    }
    
}
