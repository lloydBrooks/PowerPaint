/*
 * TCSS 305 - Spring
 * Assignment 5 - PowerPaint
 */

package model.actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.tools.PowerPaintTool;
import view.DrawingPanel;

/**
 * An Action for the tool buttons in the tool bar and tools menu of Power Paint.
 * 
 * @author Lloyd Brooks
 * @version 5/11/17
 */
public class ToolAction extends AbstractAction {

    /**
     * Auto generated value.
     */
    private static final long serialVersionUID = 149865994899638704L;

    /**
     * The tool associated with this button.
     */
    private final PowerPaintTool myTool;
    
    /**
     * The drawing panel this actions associates with. 
     */
    private final DrawingPanel myCanvas;
    
    /**
     * Constructor which automatically sets the mnemonic to the first character of the name.
     * 
     * @param theName The name which appears on the button.
     * @param theTool The tool associated with the button.
     * @param theIcon the Icon which will appear on the button.
     * @param theCanvas The Drawing panel this button is associated with.
     */
    public ToolAction(final String theName, final PowerPaintTool theTool,
                      final ImageIcon theIcon, final DrawingPanel theCanvas) {
        this(theName, theTool, theIcon, theName.charAt(0), theCanvas);
    }
    
    /**
     * Constructor for an action with a specific mnemonic.
     * 
     * @param theName The Name of the button.
     * @param theTool The tool associated with the button.
     * @param theIcon The Icon to appear on the button.
     * @param theMnemonic The mnemonic for the button.
     * @param theCanvas The drawing panel associated with this action.
     */
    public ToolAction(final String theName, final PowerPaintTool theTool,
                      final ImageIcon theIcon, final char theMnemonic, 
                      final DrawingPanel theCanvas) {
        
        super(theName);
        final ImageIcon icon = (ImageIcon) theIcon;
        final Image largeImage =
                        icon.getImage().getScaledInstance(15, -1, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon largeIcon = new ImageIcon(largeImage);
        putValue(Action.LARGE_ICON_KEY, largeIcon);
        putValue(Action.MNEMONIC_KEY,
                 KeyEvent.getExtendedKeyCodeForChar(theMnemonic));
        putValue(Action.NAME, theName);
        myCanvas = theCanvas;
        
        myTool = theTool;
    }
    
    /**
     * Used to get the tool associated with this action.
     * 
     * @return The PowerPaintTool stored in this action.
     */
    public PowerPaintTool getTool() {
        return myTool;
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        firePropertyChange("Current" , null, true);
        myCanvas.setTool(myTool);
        putValue(Action.SELECTED_KEY, true);
    }

}
