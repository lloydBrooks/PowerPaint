/*
 * TCSS 305 - Spring
 * Assignment 5 - PowerPaint
 */

package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import model.actions.ToolAction;
import model.tools.LineTool;


/**
 * This program is responsible for creating the tool bar for the power paint program.
 * 
 * @author Lloyd Brooks
 * @version 5/5/17
 */
public class PowerPaintToolBar extends JToolBar implements PropertyChangeListener {

    /**
     * Auto generated value.
     */
    private static final long serialVersionUID = 298421964888893656L;

    
    /**
     * The list of buttons made and put on the tool bar.
     */
    private final List<JToggleButton> myButtons;
    
    /**
     * The list of actions used to populate the tool bar.
     */
    private final List<Action> myActions;
    
    /**
     * Constructor for a Power Paint tool bar.
     * 
     * @param theActions The list of actions, used to populate the tool bar.
     */
    public PowerPaintToolBar(final List<Action> theActions) {
        super();
        myActions = theActions;
        myButtons = new ArrayList<JToggleButton>();
        final ButtonGroup group = new ButtonGroup();
        for (final Action a: myActions) {
            final JToggleButton temp = new JToggleButton(a);
            group.add(temp);
            myButtons.add(temp);
            add(temp);

            if (((ToolAction) a).getTool() instanceof LineTool) {
                temp.doClick();
            }
        }
        
    }

    /**
     * Used to synchronize the tool bar with the tools menu.
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        
        if ("Tool".equals(theEvent.getPropertyName())) {
            for (int i = 0; i < myButtons.size(); i++) {
                if ((((ToolAction) myActions.get(i)).getTool()).toString().equals
                                (theEvent.getNewValue().toString())) {
                    myButtons.get(i).setSelected(true);
                }
            }
        }
        
    }
    
    
}
