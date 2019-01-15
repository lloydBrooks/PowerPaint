/*
 * TCSS 305 - Spring
 * Assignment 5 - PowerPaint
 */

package model.tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * The line tool for the Power Paint program.
 * 
 * @author Lloyd Brooks
 * @version 5/11/17
 */
public class LineTool extends AbstractTool {

    //Constructors:
    /**
     * Used when first selecting a tool in power paint, will create a shape at the 
     * NO_POINT location witch is off the drawing panel.
     */  
    public LineTool() {
        this(NO_POINT, Color.WHITE, false, 1);
    }

    /**
     * Used to create a line from user input.
     * 
     * @param theStart The starting point for the new shape.
     * @param theColor The color of the shape.
     * @param theFill True if filled, false if not.
     * @param theThickness The thickness of the line used to draw the shape.
     */
    public LineTool(final Point theStart, final Color theColor, 
                    final boolean theFill, final int theThickness) {
        super(theStart, theColor, false, theThickness);
        
        // to eliminate warning about unused parameter which does not apply to lines.
        if (theFill) {
            boolean b = theFill;
            b = !b;
        }
    }
    
    @Override
    public Shape getShape() {
        return new Line2D.Double(myStart, myEnd);
    }
    
    @Override 
    public String toString() {
        return "Line";
    }
    
    @Override
    public PowerPaintTool newShape(final Point theStart, final Color theColor, 
                                   final boolean theFill, final int theThickness) {
        return new LineTool(theStart, theColor, theFill, theThickness);
    }
}
