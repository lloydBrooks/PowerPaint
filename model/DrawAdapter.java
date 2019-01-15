/*
 * TCSS 305 - Spring
 * Assignment 5a - PowerPaint
 */

package model;

import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 * A MouseInputAdapter for the Power paint program.
 * 
 * @author Lloyd Brooks
 * @version 5/5/17
 */
public class DrawAdapter extends MouseInputAdapter {
   
    /**
     * Private helper method to get the point from the event listeners.
     * 
     * @param thePoint The point to be returned.
     * @return thePoint.
     */
    private static Point helper(final Point thePoint) {
        return thePoint;
    }
    @Override
    public void mousePressed(final MouseEvent theEvent) {
        helper(theEvent.getPoint());   
    }
    
    @Override
    public void mouseReleased(final MouseEvent theEvent) {
        helper(theEvent.getPoint());
    }
    
    @Override
    public void mouseDragged(final MouseEvent theEvent) {
        helper(theEvent.getPoint());
    }

}
