/**
 * Java 2D Graphics Demo 1, Java 2D Graphics 
 * Program purpose:
 * In this project you will create 3 simple, images or your choice and use 
 * Java 2D graphic methods to rotate, scale and translate each of the images. 
 * See pdf file CMSC 405 - Project 1.pdf for full detailed information.
 * 
 * File: CMSC405P1Main.java
 * File Purpose: GUI Components, contains main method.
 * Extends from JFrame.
 * 
 * @author ReynaldoSantos
 */

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Java2DMain1 extends JFrame {
    /*
     * Fields
     */
    // GUI components
    JRadioButton tridentRadioButton = new JRadioButton("Trident");
    JRadioButton circleRadioButton = new JRadioButton("Circle");
    JRadioButton triangleRadioButton = new JRadioButton("Triangle");
    ButtonGroup radButtonGroup = new ButtonGroup();

    JButton clearButton = new JButton("clear");

    // Timer for animation
    Timer animationTimer;
    final long startTime = System.currentTimeMillis();

    // to buffer image to program
    ImagePanel panel = new ImagePanel("");

    /*
     * Constructor
     */
    Java2DMain1() {
	// Window setup
	super("Shape Transformations"); // The parameter shows in the
	setSize(200, 300);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);

	// Create radio button group
	radButtonGroup.add(tridentRadioButton);
	radButtonGroup.add(circleRadioButton);
	radButtonGroup.add(triangleRadioButton);

	// Create radio button panel
	JPanel radioButtonPanel = new JPanel();
	radioButtonPanel.add(tridentRadioButton);
	radioButtonPanel.add(circleRadioButton);
	radioButtonPanel.add(triangleRadioButton);
	radioButtonPanel.add(clearButton);

	panel.setVisible(false);
	clearButton.setEnabled(false);

	// Content pane setup
	getContentPane().add("North", radioButtonPanel);
	getContentPane().add("Center", panel);

	/*
	 * ActionListeners
	 */
	// When user clicks tridentRadioButton
	tridentRadioButton.addActionListener(a -> {
	    panel.setVisible(true);
	    panel = new ImagePanel("trident");
	    getContentPane().add("Center", panel);

	    tridentRadioButton.setEnabled(false);
	    circleRadioButton.setEnabled(false);
	    triangleRadioButton.setEnabled(false);
	    clearButton.setEnabled(true);

	    // start transformations
	    startTransformation();
	});

	// When user clicks circleRadioButton
	circleRadioButton.addActionListener(b -> {
	    panel.setVisible(true);
	    panel = new ImagePanel("circle");
	    getContentPane().add("Center", panel);

	    tridentRadioButton.setEnabled(false);
	    circleRadioButton.setEnabled(false);
	    triangleRadioButton.setEnabled(false);
	    clearButton.setEnabled(true);

	    // start transformations
	    startTransformation();
	});

	// When user clicks triangleRadioButton
	triangleRadioButton.addActionListener(c -> {
	    panel.setVisible(true);
	    panel = new ImagePanel("triangle");
	    getContentPane().add("Center", panel);

	    tridentRadioButton.setEnabled(false);
	    circleRadioButton.setEnabled(false);
	    triangleRadioButton.setEnabled(false);
	    clearButton.setEnabled(true);

	    // start transformations
	    startTransformation();
	});

	// Clears timer and transformations
	clearButton.addActionListener(c -> {
	    if (animationTimer.isRunning()) {
		animationTimer.stop();
	    }

	    getContentPane().remove(panel);

	    panel.setVisible(false);
	    getContentPane().add("Center", panel);

	    clearButton.setEnabled(false);
	    tridentRadioButton.setEnabled(true);
	    circleRadioButton.setEnabled(true);
	    triangleRadioButton.setEnabled(true);
	    radButtonGroup.clearSelection();
	});

    }

    // Displays GUI
    void displayWindow() {
	setVisible(true);
    }

    // Does tranformations of the shapes
    void startTransformation() {
	// Timer used to do transformation
	animationTimer = new Timer(1000, new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		if (panel.frameNumber > 5) {
		    panel.frameNumber = 0;
		} else {
		    panel.frameNumber++;
		}

		panel.elapsedTimeMillis = System.currentTimeMillis() - startTime;
		panel.repaint();
	    }
	});

	// Start the animation running.
	animationTimer.start();
    }

    /*
     * Main Method
     */
    public static void main(String[] args) {
	Java2DMain1 p1 = new Java2DMain1();
	p1.displayWindow();

    }

}