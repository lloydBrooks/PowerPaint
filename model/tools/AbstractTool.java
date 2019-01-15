/*
 * TCSS 305 - Spring
 * Assignment 5 - PowerPaint
 */

package model.tools;

import java.awt.Color;
import java.awt.Point;

/**
 * An abstract parent class for all tools used in Power Paint.
 * 
 * @author Lloyd Brooks
 * @version 5/11/17
 */
public abstract class AbstractTool implements PowerPaintTool {

    //Class constants:
    /**
     * Used when selecting a tool in the Power Paint program. 
     * Will create an instance of that shape with this as the start and end point.
     */
    public static final Point NO_POINT = new Point(-1, -1);
    
    
    //instance variables:
    /**
     * The end point of the shape. Can be changed with the setEnd() method.
     */
    protected Point myEnd;
    
    //Final instance variables:
    /**
     * The starting point for this shape. Set at instantiation, and cannot be changed.
     */
    protected final Point myStart;
    
    /**
     * The color of this shape. Set at instantiation, and cannot be changed.
     */
    protected Color myColor;
    
    /**
     * True if the shape is filled, false if it is just an outline.
     * Set at instantiation, and cannot be changed.
     */
    private final boolean myFill;
    
    /**
     * The thickness of the line for this shape, only relevant if the shape is not filled. 
     * Set at instantiation, and cannot be changed.
     */
    private final int myThickness;
    
    
    //Constructors:
    /**
     * Used when first selecting a tool in power paint, will create a shape at the 
     * NO_POINT location witch is off the drawing panel, and which is white. This object
     * should be overwritten with the newShape() method.
     */
    public AbstractTool() {
        this(NO_POINT, Color.WHITE, false, 0);
    }
    
    /**
     * Used to create a shape from user input, the shape will appear on the drawing panel. 
     * 
     * @param theStart The starting point of the shape. Cannot be changed after instantiation.
     * @param theColor The color of the shape. Cannot be changed after instantiation.
     * @param theFill True if filled, false if not. Cannot be changed after instantiation.
     * @param theThickness The thickness of the line the shape is drawn with. Cannot be 
     *  changed after instantiation.
     */
    public AbstractTool(final Point theStart, final Color theColor, 
                        final boolean theFill, final int theThickness) {
        myStart = theStart;
        myEnd = theStart;
        myColor = theColor;
        myFill = theFill;
        myThickness = theThickness;
    }
    
    // Setters:
    /**
     * Used to change the end point of the shape. 
     * 
     * @param theEnd The new end point for the shape. 
     */
    public void setEndPoint(final Point theEnd) {
        myEnd = theEnd;
    }
    
    // Getters:
    @Override
    public Color getColor() {
        return myColor;
    }
    
    @Override
    public boolean isFilled() {
        return myFill;
    }
    
    @Override
    public int getThickness() {
        return myThickness;
    }
    
    /**
     *  Helper class to get a new point to create a square or circle.
     * 
     * @return A new end point for a line to create a square or circle.
     */
    protected Point makeSquare() {
        int width = (int) (myEnd.getX() - myStart.getX());
        int height = (int) (myEnd.getY() - myStart.getY());
        
        int xSign = 1;
        int ySign = 1;
        
        if (width == 0 || height == 0) {
            xSign = 0;
            ySign = 0;
        } else {
            xSign = width / Math.abs(width);
            ySign = height / Math.abs(height);
        }
        
        final int temp = width;
        width = Math.max(Math.abs(width), Math.abs(height));
        height = Math.max(Math.abs(temp), Math.abs(height));
        
        return new Point((int) myStart.getX() + xSign * width,
                         (int) myStart.getY() + ySign * height);                
    }
    
    
    
}
