/*
 * TCSS 305 - Spring
 * Assignment 5a - PowerPaint
 */

package model.tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Path2D;

/**
 * The pencil tool for the Power Paint program. Uses the Path2D shape.
 * 
 * @author Lloyd Brooks
 * @version 5/11/17
 */
public class PencilTool extends AbstractTool {

    //Instance fields:
    /**
     * The pencil drawing.
     */
    private final Path2D.Double myShape;
    
    //Constructors:
    
    /**
     * Default Constructor, never to be used, only exists to create a tool to be 
     * overwrote later with the newShape() method.
     */
    public PencilTool() {
        this(NO_POINT, Color.WHITE, false, 1);
    }
    
    /**
     * Used to create a drawing from user input.
     * 
     * @param theStart The starting point for the new shape.
     * @param theColor The color of the shape.
     * @param theFill True if filled, false if not.
     * @param theThickness The thickness of the line used to draw the shape.
     */
    public PencilTool(final Point theStart, final Color theColor, 
                      final boolean theFill, final int theThickness) {

        super(theStart, theColor, false, theThickness);
        myShape = new Path2D.Double();
        myShape.moveTo(theStart.getX(), theStart.getY());
        //to stop warning about unused parameters that do not apply to pencils. 
        if (theFill) {
            boolean b = theFill;
            b = !b;
        }
    }

    /**
     * Used to update the end point of the pencil, and to add a point to the path2D.
     */
    @Override
    public void setEndPoint(final Point theEnd) {
        myEnd = theEnd;
        myShape.lineTo(theEnd.getX(), theEnd.getY());
    }
    
    @Override
    public Shape getShape() {
        return (Shape) myShape.clone();
    }

    @Override
    public String toString() {
        return "Pencil";
    }
    
    @Override
    public PowerPaintTool newShape(final Point theStart, final Color theColor, 
                                   final boolean theFill, final int theThickness) {
        return new PencilTool(theStart, theColor, theFill, theThickness);
    }

    
}
