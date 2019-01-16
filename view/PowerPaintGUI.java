/*
 * TCSS 305 - Spring
 * Assignment 5 - PowerPaint
 */

package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.FileMenu;
import model.HelpMenu;
import model.OptionsMenu;
import model.PowerPaintToolBar;
import model.ToolsMenu;
import model.actions.ClearAction;
import model.actions.ExitAction;
import model.actions.ToolAction;
import model.tools.CircleTool;
import model.tools.EllipseTool;
import model.tools.EraserTool;
import model.tools.LineTool;
import model.tools.PencilTool;
import model.tools.PowerPaintTool;
import model.tools.RectangleTool;
import model.tools.SquareTool;

/**
 * This program is responsible for creating the GUI for the power paint program.
 * 
 * @author Lloyd Brooks
 * @version 5/5/17
 */
public class PowerPaintGUI extends JPanel {

    //Class constants.
    /**
     * Auto Generated.
     */
    private static final long serialVersionUID = 2729328503069312574L;

    //Instance fields.
    /**
     * The window the program runs in.
     */
    private final JFrame myWindow;
    
    /**
     * The drawing panel for power paint.
     */
    private final DrawingPanel myCanvas;
   
    /**
     * The menu bar for power paint.
     */
    private final JMenuBar myMenuBar;

    /**
     * A list of Actions for the tool buttons.
     */
    private final List<Action> myActions;

     /**
     * main method to launch the program.
     * 
     * @param theArgs The command line arguments.
     */
    public static void main(final String[] theArgs) {
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //start the program
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaintGUI().start();
            }
        });
    }
    
    //Constructor
    /**
     * A basic constructor for PowerPaintGUI.
     */
    public PowerPaintGUI() {
        super();
        setLayout(new BorderLayout());
        
        //create window for program:
        myWindow = new JFrame("PowerPaint");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //create drawingPanel.
        myCanvas = new DrawingPanel();
               
        //add drawing panel to center.
        add(myCanvas, BorderLayout.CENTER);
        
        myActions = makeToolActions();
        
        //create menu bar.
        myMenuBar = createMenuBar();
        
        //create tool bar
        makeToolBar();
    }
    
    /**
     * Private helper method to set up tool bar.
     */
    private void makeToolBar() {
        final JToolBar tb = new PowerPaintToolBar(myActions);
        myCanvas.addPropertyChangeListener((PropertyChangeListener) tb);
        //add tool bar to south.
        add(tb, BorderLayout.SOUTH);        
    }

    /**
     * private helper method to create the list of toolAction objects.
     * 
     * @return A list of ToolAction objects to be used in creating the tool bar and tools menu.
     */
    private List<Action> makeToolActions() {
        final List<Action> result = new ArrayList<Action>();
        final Action pencil = new ToolAction("Pencil", (PowerPaintTool) new PencilTool(),
                                            new ImageIcon("./images/pencil_bw.gif"), myCanvas);
        result.add(pencil);
        
        final Action line = new ToolAction("Line", (PowerPaintTool) new LineTool(), 
                                           new ImageIcon("./images/line_bw.gif"), myCanvas);
        result.add(line);   
        
        final Action rectangle = new ToolAction("Rectangle", 
                                                (PowerPaintTool) new RectangleTool(),
                                                new ImageIcon("./images/rectangle_bw.gif"),
                                                myCanvas);
        result.add(rectangle);
        
        final Action square = new ToolAction("Square", (PowerPaintTool) new SquareTool(), 
                                            new ImageIcon("./images/square_bw.gif"), myCanvas);
        result.add(square);
        
        final Action ellipse = new ToolAction("Ellipse", (PowerPaintTool) new EllipseTool(),
                                           new ImageIcon("./images/ellipse_bw.gif"), myCanvas);
        result.add(ellipse);
        
        final Action circle = new ToolAction("Circle", (PowerPaintTool) new CircleTool(),
                                            new ImageIcon("./images/circle_bw.gif"), myCanvas);
        result.add(circle);
        
        final Action eraser = new ToolAction("Eraser", (PowerPaintTool) new EraserTool(), 
                                            new ImageIcon("./images/eraser_bw.gif"),
                                            'A', myCanvas);
        result.add(eraser);
        
        return result;
    }

    /**
     * Helper method to create the menu bar.
     * 
     * @return The power paint menu bar.
     */
    private JMenuBar createMenuBar() {
        final JMenuBar result = new JMenuBar();
        
        //File Menu:
        final Action exit = new ExitAction("Quit", myWindow);
        final ClearAction clear = new ClearAction("Clear", myCanvas);
        
        final FileMenu file = new FileMenu(clear, exit);
        result.add(file);
        myCanvas.addPropertyChangeListener(file);
        //Options Menu:
        final OptionsMenu options = new OptionsMenu(myCanvas);
        result.add(options);
        
        //Tools Menu:
        final ToolsMenu tools = new ToolsMenu(myActions);
        result.add(tools);
        //buttons = tools.getButtons();
        
        //Help Menu:
        final HelpMenu help = new HelpMenu();
        result.add(help);
        
        return result;
    }

    /**
     * Sets up the GUI window for power paint. 
     */
    public void start() {
        //myWindow = new JFrame("PowerPaint");
//        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myWindow.add(this);
        final ImageIcon icon = new ImageIcon("./images/paintbrush.png");
        myWindow.setIconImage(icon.getImage());
        myWindow.setJMenuBar(myMenuBar);
        myWindow.pack();
        myWindow.setVisible(true);
        
    }
    
   

}
