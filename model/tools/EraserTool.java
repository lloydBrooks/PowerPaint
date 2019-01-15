/*
 * TCSS 305 - Spring
 * Assignment 5a - PowerPaint
 */

package model.tools;

import java.awt.Color;
import java.awt.Point;

/**
 * A version of the Pencil tool which is always white.
 * 
 * @author Lloyd Brooks
 * @version 5/17/17
 */
public class EraserTool extends PencilTool {
    
    /**
     * Default constructor.
     */
    public EraserTool() {
        this(NO_POINT, Color.WHITE, false, 0);
        
    }
    
    /**
     * Four argument constructor.
     * 
     * @param theStart The starting point.
     * @param theColor Will be set to white regardless of this value. 
     * @param theFill the fill status of the shape.
     * @param theThickness The thickness of line used to make this sape.
     */
    public EraserTool(final Point theStart, final Color theColor,
                      final boolean theFill, final int theThickness) {
        super(theStart, Color.WHITE, false, theThickness);
        //to eliminate warnings about unused parameters that are irrelevant to eraser. 
        if (theFill) {
            theColor.getBlue();
        }
    }
    
    @Override 
    public String toString() {
        return "Eraser";
    }
    
    @Override
    public PowerPaintTool newShape(final Point theStart, final Color theColor, 
                                   final boolean theFill, final int theThickness) {
        return new EraserTool(theStart, theColor, theFill, theThickness);
    }

}
