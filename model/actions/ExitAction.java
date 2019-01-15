/*
 * TCSS 305 - Spring
 * Assignment 5 - PowerPaint
 */

package model.actions;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * The Exit button action for the Power Paint program.
 * 
 * @author Lloyd Brooks
 * @version 5/11/17
 */
public class ExitAction extends AbstractAction {
    
    /**
     * Auto generated value.
     */
    private static final long serialVersionUID = -7718722509034229302L;
    
    /**
     * The window the exit action pertains to.
     */
    private final JFrame myFrame;
    
    /**
     * Constructor.
     * 
     * @param theShortDescription The name of the button.
     * @param theFrame The window the button is a part of.
     */
    public ExitAction(final String theShortDescription, 
                      final JFrame theFrame) {
        super(theShortDescription);
        myFrame = theFrame;
        putValue(Action.NAME, theShortDescription);
        putValue(Action.ACCELERATOR_KEY, 
                 KeyStroke.getKeyStroke('Q'));
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
    }

}
