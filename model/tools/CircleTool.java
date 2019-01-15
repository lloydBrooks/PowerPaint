/*
 * TCSS 305 - Spring
 * Assignment 5 - PowerPaint
 */

package model.tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

/**
 * The Square tool for the Power Paint program.
 * 
 * @author Lloyd Brooks
 * @version 5/11/17
 */
public class CircleTool extends EllipseTool {
    //Constructors:
    /**
     * Used when first selecting a tool in power paint, will create a shape at the 
     * NO_POINT location witch is off the drawing panel.
     */
    public CircleTool() {
        super();
    }

     /**
     * Used to create a line from user input.
     * 
     * @param theStart The starting point for the new shape.
     * @param theColor The color of the shape.
     * @param theFill True if filled, false if not.
     * @param theThickness The thickness of the line used to draw the shape.
     */
    public CircleTool(final Point theStart, final Color theColor, 
                      final boolean theFill, final int theThickness) {
        super(theStart, theColor, theFill, theThickness);
    }

    @Override
    public Shape getShape() {
        
        final Point temp = makeSquare();
        
        final Shape result = new Ellipse2D.Double();
        ((RectangularShape) result).setFrameFromDiagonal(myStart, temp);
        return result;
    }
    
    @Override
    public String toString() {
        return "Circle";
    }
    
    @Override
    public PowerPaintTool newShape(final Point theStart, final Color theColor, 
                                   final boolean theFill, final int theThickness) {
        return new CircleTool(theStart, theColor, theFill, theThickness);
    }
}
