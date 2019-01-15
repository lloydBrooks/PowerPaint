/*
 * TCSS 305 - Spring
 * Assignment 5a - PowerPaint
 */

package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import model.tools.PowerPaintTool;


/**
 * A Drawing panel for the PowerPaint program.
 * 
 * @author Lloyd Brooks
 * @version 5/5/17
 */
public class DrawingPanel extends JPanel {

    //Class constants
    /**
     * Auto-generated serialVersionUID.
     */
    private static final long serialVersionUID = 4693107400480860483L;
    
    /**
     * the default size of the drawing panel.
     */
    private static final Dimension DEFAULT_SIZE = new Dimension(400, 400);
    
    /**
     * The default primary color for the drawing panel, UW Purple.
     */
    private static final Color DEFAULT_PRIMARY = new Color(51, 0, 111); 
    
    /**
     * The default secondary color for the drawing panel, UW Gold.
     */
    private static final Color DEFAULT_SECONDARY = new Color(232, 211, 162);
    
    //Instance fields.

    /**
     * The mouse listener adapter for mouse pressed, mouse released, and mouse dragged. 
     */
    private final MouseInputAdapter myAdapter;
    
    /**
     * The list of shapes which have been drawn on the panel.
     */
    private final List<PowerPaintTool> myShapes;
    
    /**
     * The current tool in use on the drawing panel.
     */
    private PowerPaintTool myTool;
    
    /**
     * The primary color for the drawing panel. Used when the user draws with a left click.
     */
    private Color myPrimaryColor;
    
    /**
     * The secondary color for the drawing panel. Used when the user draws with a right click.
     */
    private Color mySecondaryColor;
    
    /**
     * True if drawing filled shapes, false if drawing outlines.
     */
    private boolean myFilled;
    
    /**
     * The thickness of line used to draw on the drawing panel. 
     */
    private int myThickness;
    //Constructor.
   /**
    * A constructor for a DrawingPanel.
    */
    public DrawingPanel() {
        super();
        myShapes = new ArrayList<PowerPaintTool>();
        myAdapter = new DrawAdapter();
        myPrimaryColor = DEFAULT_PRIMARY;
        mySecondaryColor = DEFAULT_SECONDARY;
        myFilled = false;
        myThickness = 1;
        myTool = PowerPaintTool.DEFAULT_TOOL;
        setUpCanvas();
        
    }
    
    /**
     * Private helper method to set up the behavior of the panel.
     */
    private void setUpCanvas() {
        addMouseListener(myAdapter);
        addMouseMotionListener(myAdapter);
        setPreferredSize(DEFAULT_SIZE);
        setBackground(Color.WHITE);
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

    }
    

    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < myShapes.size(); i++) {
           
            final PowerPaintTool current = myShapes.get(i);
            
            g2d.setPaint(current.getColor());
            g2d.setStroke(new BasicStroke(current.getThickness()));
            if (current.isFilled()) {
                g2d.fill(current.getShape());
            } else {
                g2d.draw(current.getShape());
            }
        }
        
    }
    
    
    //setters:
    /**
     * Used to clear the drawing panel.
     */
    public void clear() {
        myShapes.clear();
        propertyChange();
        myTool = myTool.newShape(new Point(-1, -1), Color.WHITE, false, 1);
        repaint();
    }
    
    /**
     * Used to change the drawing tool in use.
     * 
     * @param theTool The new tool.
     */
    public void setTool(final PowerPaintTool theTool) {
        myTool = theTool;
        this.firePropertyChange("Tool", null, myTool);
    }
    
    /**
     *  Used to set the primary color of the drawing panel.
     * 
     * @param theColor The new color to be drawn with.
     */
    public void setPrimaryColor(final Color theColor) {
        myPrimaryColor = theColor;
    }
    
    /**
     * Used to set the secondary color of the drawing panel.
     * 
     * @param theColor The new color to be drawn with.
     */
    public void setSecondaryColor(final Color theColor) {
        mySecondaryColor = theColor;
    }
    
    /**
     * Used to set the thickness of lines used to draw with.
     * 
     * @param theThickness The thickness of line.
     */
    public void setThickness(final int theThickness) {
        myThickness = theThickness;
    }
    
    /**
     * Used to set the filled status of the shapes drawn on the panel.
     * 
     */
    public void setFill() {
        myFilled = !myFilled;
    }
    
    //Getters
    /**
     * Used to get the primary color in use on the panel.
     * 
     * @return The primary color.
     */
    public Color getPrimaryColor() {
        return myPrimaryColor;
    }
    
    /**
     * Used to get the secondary color in use on the panel.
     * 
     * @return The secondary color.
     */
    public Color getSecondaryColor() {
        return mySecondaryColor;
    }
    
    /**
     * Used to get the thickness of line being drawn.
     * 
     * @return The thickness of line.
     */
    public int getThickness() {
        return myThickness;
    }
    
    /**
     * Used to get the filled status of the panel.
     * 
     * @return True if filled, false if not.
     */
    public boolean isFilled() {
        return myFilled;
    }
    
    /**
     * Used to fire property change for the clear button.
     */
    public void propertyChange() {
        this.firePropertyChange("Has Shape", null, !myShapes.isEmpty());

    }
    
    //inner class
    /**
     * A MouseInputAdapter for the Power Paint drawing panel.
     * 
     * @author Lloyd Brooks
     * @version 5/5/17
     */
    public class DrawAdapter extends MouseInputAdapter {
        
        @Override
        public void mousePressed(final MouseEvent theEvent) {

            if (theEvent.getButton() == MouseEvent.BUTTON1) {
                myTool = myTool.newShape(theEvent.getPoint(), myPrimaryColor, 
                                         myFilled, myThickness);
            } else if (theEvent.getButton() == MouseEvent.BUTTON3) {
                myTool = myTool.newShape(theEvent.getPoint(), mySecondaryColor, 
                                         myFilled, myThickness);
            }

        }
        
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            myTool.setEndPoint(theEvent.getPoint());
            if (!myShapes.isEmpty()) {
                myShapes.remove(myShapes.size() - 1); 
            }
            myShapes.add(myTool);
            repaint();
            propertyChange();
        }
        
        @Override 
        public void mouseReleased(final MouseEvent theEvent) {
            myShapes.add(myTool);
            myTool = myTool.newShape(new Point(), Color.WHITE, false, 0);
            
        }
        

    }
        
}
