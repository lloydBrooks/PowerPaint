/*
 * TCSS 305 - Spring
 * Assignment 5 - PowerPaint
 */

package model.actions;

import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.KeyStroke;
import view.DrawingPanel;

/**
 * The Clear button action for the Power Paint program.
 * 
 * @author Lloyd Brooks
 * @version 5/11/17
 */
public class ClearAction extends javax.swing.AbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = -7870021466903383887L;

    /**
     * The drawing panel the clear button will clear.
     */
    private final DrawingPanel myCanvas;
    
    /**
     * Constructor.
     * 
     * @param theName The Name to appear on the button.
     * @param theCanvas The drawing panel the button clears.
     */
    public ClearAction(final String theName, final DrawingPanel theCanvas) {
        super(theName);
        myCanvas = theCanvas;
        putValue(Action.NAME, theName);
        putValue(Action.ACCELERATOR_KEY,
                 KeyStroke.getKeyStroke('C'));
        
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myCanvas.clear();
        
    }

}
