/*
 * TCSS 305 - Spring
 * Assignment 5a - PowerPaint
 */

package model;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import view.DrawingPanel;

/**
 * The Options menu for Power paint.
 * 
 * @author Lloyd Brooks
 * @version 5/5/17
 */
public class OptionsMenu extends JMenu {

    /**
     * Auto Generated.
     */
    private static final long serialVersionUID = -5349417771428309798L;

    /**
     * The DrawingPanel associated with this menu.
     */
    private final DrawingPanel myCanvas;
    
    /**
     * Constructor for OptionsMenu Objects.
     * 
     * @param theCanvas The drawing panel the menu pertains to.
     */
    public OptionsMenu(final DrawingPanel theCanvas) {
        super("Options");
        myCanvas = theCanvas;
        setMnemonic(KeyEvent.VK_O);
        
        //create slider menu:
        add(makeSlider());
        
        addSeparator();
        
        //Create Primary Color menu:
        add(makePrimary());
        
        //Create Secondary Color menu:
        add(makeSecondary());
        
        addSeparator();
        
        //Create Fill Check box:

        add(makeFillBox());
        
        
    }

    /**
     * Helper method to create a check box to set the fill status of the drawing canvas.
     * 
     * @return A JCheckBoxMenuItem.
     */
    private JMenuItem makeFillBox() {
        final JMenuItem fill = new JCheckBoxMenuItem("Fill");
        fill.setMnemonic(KeyEvent.VK_F);
        fill.addActionListener((theEvent) -> {
            myCanvas.setFill();
        });
        return fill;
    }
    
    /**
     * private helper to set up the secondary color chooser.
     * 
     * @return a sub menu with a JColorChooser.
     */
    private JMenuItem makeSecondary() {
        final JMenuItem secondary = new JMenuItem("Secondary Color...");
        secondary.setMnemonic(KeyEvent.VK_S);
        secondary.setIcon(new ColorIcon(myCanvas.getSecondaryColor()));
        
        secondary.addActionListener((theEvent) -> {
            final Color color = JColorChooser.showDialog(secondary, "Choose secondary color",
                                                            myCanvas.getSecondaryColor());
            secondary.setIcon(new ColorIcon(color));
            myCanvas.setSecondaryColor(color);
        });
        return secondary;
    }

    /**
     * Private helper method to set up the primary color chooser.
     * 
     * @return a sub menu with a JColorChooser.
     */
    private JMenuItem makePrimary() {
        final JMenuItem primary = new JMenuItem("Primary Color...");
        primary.setMnemonic(KeyEvent.VK_P);
        primary.setIcon(new ColorIcon(myCanvas.getPrimaryColor()));
        primary.addActionListener((theEvent) -> {
            final Color newColor = JColorChooser.showDialog(primary, "Choose primary color:",
                                                            myCanvas.getPrimaryColor());
            primary.setIcon(new ColorIcon(newColor));
            myCanvas.setPrimaryColor(newColor);
        });
        
        return primary;
    }

    /**
     * Creates the JSlider sub-Menu for the thickness slider.
     * 
     * @return A JSlider sub-Menu for thickness.
     */
    private JMenu makeSlider() {
        final int scale = 5;
        final JMenu result = new JMenu("Thickness");
        result.setMnemonic(KeyEvent.VK_T);
        
        final JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 20, 1);
        slider.setMajorTickSpacing(scale);
        slider.setMinorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            /** Called in response to slider events in this window. */
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                myCanvas.setThickness(slider.getValue());
            }
        });
        
        result.add(slider);
        return result;
    }
}
