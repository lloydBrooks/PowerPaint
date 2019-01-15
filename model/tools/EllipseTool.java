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
 * The Ellipse tool for the Power Paint program.
 * 
 * @author Lloyd Brooks
 * @version 5/11/17
 */
public class EllipseTool extends AbstractTool {

    //Constructors:
    /**
     * Used when first selecting a tool in power paint, will create a shape at the 
     * NO_POINT location witch is off the drawing panel.
     */  
    public EllipseTool() {
        super();
    }

    /**
     * Used to create a Ellipse from user input.
     * 
     * @param theStart The starting point for the new shape.
     * @param theColor The color of the shape.
     * @param theFill True if filled, false if not.
     * @param theThickness The thickness of the line used to draw the shape.
     */
    public EllipseTool(final Point theStart, final Color theColor, 
                       final boolean theFill, final int theThickness) {
        super(theStart, theColor, theFill, theThickness);
    }

    @Override
    public Shape getShape() {
        final Shape result = new Ellipse2D.Double();
        ((RectangularShape) result).setFrameFromDiagonal(myStart, myEnd);
        
        return result;
    }

    @Override 
    public String toString() {
        return "Ellipse";
    }
    
    @Override
    public PowerPaintTool newShape(final Point theStart, final Color theColor, 
                                   final boolean theFill, final int theThickness) {
        return new EllipseTool(theStart, theColor, theFill, theThickness);
    }
    
    
    
}
