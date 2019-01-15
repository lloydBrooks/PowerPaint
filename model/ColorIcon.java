package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;

/**
 * Custom Icon for the primary and secondary color selectors.
 * 
 * @author Lloyd Brooks
 * @version 5/17/17
 */
public class ColorIcon implements Icon {

    /**
     * The size of the Icon.
     */
    private static final int SIZE = 16;
    
    /**
     * The color for the icon to be.
     */
    private final Color myColor;
    
    /**
     * Constructor.
     * 
     * @param theColor The color to make the Icon.
     */
    public ColorIcon(final Color theColor) {
        myColor = theColor;
    }
    
    @Override
    public int getIconHeight() {
        
        return SIZE;
    }

    @Override
    public int getIconWidth() {
        
        return SIZE;
    }

    @Override
    public void paintIcon(final Component theComponent, final Graphics theGraphic,
                          final int theX, final int theY) {
        
        final Graphics2D g2d = (Graphics2D) theGraphic;
        
        g2d.setColor(myColor);
        
        g2d.fillRect(theX, theY, SIZE, SIZE);
        
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        
        g2d.drawRect(theX, theY, SIZE, SIZE);
        
    }

}
