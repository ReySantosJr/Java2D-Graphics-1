/**
 * Java 2D Graphics Demo 1, Java 2D Graphics 
 * Program purpose:
 * In this project you will create 3 simple, images or your choice and use 
 * Java 2D graphic methods to rotate, scale and translate each of the images. 
 * See pdf file CMSC 405 - Project 1.pdf for full detailed information.
 * 
 * File: TridentImage.java
 * File Purpose: Creates trident shape
 * Extends from JComponent
 * 
 * @author ReynaldoSantos
 */

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class TridentImage extends JComponent {
    /*
     * Fields
     */
    // Array boundaries
    private final static int IMG_SIZE_X = 16;
    private final static int IMG_SIZE_Y = 11;

    // Shapes:
    // Creates Trident
    public static int[][] trident_2DArray = { 
	    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	    { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	    { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0 }, 
	    { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0 },
	    { 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 }, 
	    { 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
	    { 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0 }, 
	    { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
	    { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
	    { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
	    { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
	    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

    };

    // Apply pixel colors
    public BufferedImage getImage(int[][] data) {
	BufferedImage image = new BufferedImage(IMG_SIZE_X, IMG_SIZE_Y, BufferedImage.TYPE_INT_RGB);

	for (int x = 0; x < IMG_SIZE_X; x++) {
	    for (int y = 0; y < IMG_SIZE_Y; y++) {
		int pixelColor = data[x][y];

		// Set Colors based on Binary Image value
		if (pixelColor == 0) {
		    pixelColor = Color.CYAN.getRGB();
		} else if (pixelColor == 1) {
		    pixelColor = Color.YELLOW.brighter().getRGB();
		}

		image.setRGB(x, y, pixelColor);
	    }
	}

	return image;
    }

}
