
/**
 * Java 2D Graphics Demo 1, Java 2D Graphics 
 * Program purpose:
 * In this project you will create 3 simple, images or your choice and use 
 * Java 2D graphic methods to rotate, scale and translate each of the images. 
 * See pdf file CMSC 405 - Project 1.pdf for full detailed information.
 * 
 * File: ImagePanel.java
 * File Purpose: Class needed to buffer image to the program and helps fix 
 * view port transformation.
 * Does the shape transformations.
 * Extends from JPanel.
 * 
 * @author ReynaldoSantos
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    /*
     * Fields
     */
    // A counter that increases by one in each frame.
    int frameNumber = 0;

    // The time, in milliseconds, since the animation started.
    // Helps to loop the animation
    long elapsedTimeMillis;

    // For setting up viewport in method applyWindowToViewportTransformation(...)
    float pixelSize;

    // Variables for shape transformation
    static int translateX = 0;
    static int translateY = 0;
    static double rotation1 = 0.0;
    static double rotation2 = 0.0;
    static double scaleX = 0.0;
    static double scaleY = 0.0;

    // Prepares the image for use
    BufferedImage buffImage;

    // To help select the desired shape
    String img;

    /*
     * Constructors
     */
    // Blank constructor
    ImagePanel() {
    }

    // Default constructor, helps method chooseImage() to select shape
    ImagePanel(String img) {
	this.img = img;
    }

    // Selects image
    private BufferedImage chooseImage() {
	if (img.equalsIgnoreCase("trident")) {
	    buffImage = new TridentImage().getImage(TridentImage.trident_2DArray);
	}

	else if (img.equalsIgnoreCase("circle")) {
	    buffImage = new CircleImage().getImage(CircleImage.circle_2DArray);
	}

	else if (img.equalsIgnoreCase("triangle")) {
	    buffImage = new TriangleImage().getImage(TriangleImage.triangle_2DArray);
	}

	return buffImage;
    }

    // Creates the loop animations using time to display the transformations
    public void paintComponent(Graphics g) {
	// Creates/sets up needed instance
	Graphics2D g2 = (Graphics2D) g.create();
//		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	// Sets up the JPanel
	g2.setPaint(Color.WHITE);
	g2.fillRect(0, 0, getWidth(), getHeight());

	// Sets customized viewport.
	applyWindowToViewportTransformation(g2, -55, 55, -15, 15, true);

	AffineTransform savedTransform = g2.getTransform();
	System.out.println("Frame is " + frameNumber);
	switch (frameNumber) {
	case 1: // Defaults frame
	    translateX = 0;
	    translateY = 0;
	    scaleX = 1.0;
	    scaleY = 1.0;
	    rotation1 = 0;
	    rotation2 = 0;
	    break;

	case 2: // Translates
	    translateX = -5;
	    translateY = 7;

	    break;

	case 3: // 1st Rotation
	    rotation1 = Math.toRadians(45); // counter clockwise.

	    break;

	case 4: // 2nd Rotation
	    rotation2 = Math.toRadians(-90); // clockwise.

	    break;

	case 5: // Scales
	    scaleX = 3.0;
	    scaleY = 0.6;

	    break;

	default:
	    break;
	} // End of switch

	// Begins transformation animation
	g2.translate(translateX, translateY);
	g2.rotate(rotation1);
	g2.rotate(rotation2);
	g2.scale(scaleX, scaleY);
	g2.drawImage(chooseImage(), 0, 0, this);
	g2.setTransform(savedTransform);
    }

    // Customizable viewport
    private void applyWindowToViewportTransformation(Graphics2D g2, double left, double right, double bottom,
	    double top, boolean preserveAspect) {
	// The width of this drawing area, in pixels.
	int width = getWidth();

	// The height of this drawing area, in pixels.
	int height = getHeight();

	if (preserveAspect) {
	    // Adjust the limits to match the aspect ratio of the drawing area.
	    double displayAspect = Math.abs((double) height / width);
	    double requestedAspect = Math.abs((bottom - top) / (right - left));

	    if (displayAspect > requestedAspect) {
		// Expand the viewport vertically.
		double excess = (bottom - top) * (displayAspect / requestedAspect - 1);
		bottom += excess / 2;
		top -= excess / 2;
	    } else if (displayAspect < requestedAspect) {
		// Expand the viewport vertically.
		double excess = (right - left) * (requestedAspect / displayAspect - 1);
		right += excess / 2;
		left -= excess / 2;
	    }
	}

	g2.scale(width / (right - left), height / (bottom - top));
	g2.translate(-left, -top);
	double pixelWidth = Math.abs((right - left) / width);
	double pixelHeight = Math.abs((bottom - top) / height);
	pixelSize = (float) Math.max(pixelWidth, pixelHeight);
    }
}
