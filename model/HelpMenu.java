/*
 * TCSS 305 - Spring
 * Assignment 5a - PowerPaint
 */

package model;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


/**
 * The help menu for Power paint.
 * 
 * @author Lloyd Brooks
 * @version 5/5/17
 */
public class HelpMenu extends JMenu {

    /**
     * Auto generated.
     */
    private static final long serialVersionUID = 8843424354324841472L;
    
    /**
     * Constructor for HelpMenu Objects.
     */
    public HelpMenu() {
        super("Help");
        setMnemonic(KeyEvent.VK_H);
        final String title = "About...";
        final String message = "Lloyd Brooks\nSpring 2017\nTCSS 305 PowerPaint";
        final JMenuItem about = new JMenuItem(title);
        about.setMnemonic(KeyEvent.VK_A);
        about.addActionListener((theEvent) -> {
            JOptionPane.showMessageDialog(about, message, title, 
                                          1, new ImageIcon("./images/paintbrushIcon.png"));
        });
        add(about);
    }
        
}
