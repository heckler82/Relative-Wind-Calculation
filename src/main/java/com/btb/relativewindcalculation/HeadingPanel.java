/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btb.relativewindcalculation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * Displays heading information
 * 
 * @author Evan Foley
 * @version 08 August 2021
 */
public class HeadingPanel extends JPanel {
    Image img1;
    Image img2;
    int winDiff;
    
    /**
     * Creates a new heading panel
     */
    public HeadingPanel() {}
    
    /**
     * Sets the images to be used in the panel
     * 
     * @param img1 the first image
     * @param img2 the second image
     */
    public void setImages(Image img1, Image img2) {
        this.img1 = img1;
        this.img2 = img2;
    }
    
    /**
     * Updates the rotation angle of the wind header
     * 
     * @param winDiff the rotation angle
     */
    public void setWinDiff(int winDiff) {
        this.winDiff = winDiff;
    }
    
    /**
     * Paints the component to the gui
     * 
     * @param gfx the graphics context
     */
    public void paintComponent(Graphics gfx) {
        Graphics2D g = (Graphics2D)gfx;
        super.paintComponent(g);
        // Paint the compass
        g.drawImage(img1, (getWidth() / 2) - (img1.getWidth(null) / 2), (getHeight() / 2) - (img1.getHeight(null) / 2), this);
        
        // Paint the arrow
        g.translate(getWidth() / 2, getHeight() / 2);
        g.rotate(Math.toRadians(winDiff));
        g.translate(0, -img1.getHeight(null) / 2);
        g.translate(-img2.getWidth(null) / 2, -img2.getHeight(null) / 2);
        g.drawImage(img2, 0, 0, this);
    }    
}
