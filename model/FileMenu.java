/*
 * TCSS 305 - Spring
 * Assignment 5a - PowerPaint
 */

package model;

import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import model.actions.ClearAction;


/**
 * The file menu for Power paint.
 * 
 * @author Lloyd Brooks
 * @version 5/5/17
 */
public class FileMenu extends JMenu implements PropertyChangeListener {

    /**
     * Auto Generated.
     */
    private static final long serialVersionUID = 8263921573296712521L;
    
    /**
     * The clear button.
     */
    private final JMenuItem myClear;
    /**
     * Constructor for a FileMenu object.
     * 
     * @param theExit The ExitAction for the Power Paint program.
     * @param theClear The clear Action for the Power Paint program.
     */
    public FileMenu(final ClearAction theClear, final Action theExit) {
        super("File");
        
        setMnemonic(KeyEvent.VK_F);
        
        myClear = new JMenuItem("Clear");
        myClear.addActionListener(theClear);
        myClear.setEnabled(false);
        add(myClear);
        
        addSeparator();
        
        final JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(theExit);
        add(quit);

    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {

        if ("Has Shape".equals(theEvent.getPropertyName())) {
            myClear.setEnabled((boolean) theEvent.getNewValue());
        }
    }
    
}
