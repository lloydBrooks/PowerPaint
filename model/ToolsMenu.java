/*
 * TCSS 305 - Spring
 * Assignment 5a - PowerPaint
 */

package model;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;


/**
 * The Tools menu for Power paint.
 * 
 * @author Lloyd Brooks
 * @version 5/5/17
 */
public class ToolsMenu extends JMenu {

    /**
     * Auto Generated.
     */
    private static final long serialVersionUID = 8582730659193310229L;
    
    
    /**
     * Constructor for ToolsMenu.
     * 
     * @param theTools The list of actions used to populate the menu.
     */
    public ToolsMenu(final List<Action> theTools) {
        super("Tools");
        setMnemonic(KeyEvent.VK_T);
        
        final ButtonGroup buttons = new ButtonGroup();
        for (final Action a: theTools) {
            final JRadioButtonMenuItem b = new JRadioButtonMenuItem(a);
            add(b);
            buttons.add(b);
        }
    
    }

    
}
