/*
 * TCSS 305 - Spring
 * Assignment 5 - PowerPaint
 */

package model.tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;

/**
 * This interface defines the requirements of a tool in power paint.
 * 
 * @author Lloyd Brooks
 * @version 5/5/17
 */
public interface PowerPaintTool {
    
    /**
     * The default tool for the Power Paint program.
     */
    PowerPaintTool DEFAULT_TOOL = new LineTool();
    
    /**
     * Used to get the shape stored in this tool.
     * 
     * @return A shape generated from the information in this tool.
     */
    Shape getShape();
    
    /**
     * Used to get the thickness of the shape.
     * 
     * @return The thickness value for this shape.
     */
    int getThickness();
    
    /**
     * Used to get the color for the shape.
     * 
     * @return The color of this shape.
     */
    Color getColor();
    
    /**
     * Used to get weather or not the shape is filled.
     * 
     * @return True if filled, false if not.
     */
    boolean isFilled();
    
    /**
     * ToString method. returns the name of the tool.
     * 
     * @return The name of the tool as a string.
     */
    String toString();
    
    /**
     * Used to set the end point of the shape, the start cannot be changed.
     * 
     * @param theEnd The new end point for the shape.
     */
    void setEndPoint(Point theEnd);
    
    /**
     * Used to get a copy of the object.
     * 
     * @param theStart The starting point for the new shape.
     * @param theColor The color of the new shape.
     * @param theFill True if filled, false if not.
     * @param theThickness The thickness of the line.
     * @return A new shape of the current type with a specified starting point. 
     */
    PowerPaintTool newShape(Point theStart, Color theColor, boolean theFill, int theThickness);
}
