package clock.util;

import java.awt.Point;

/**
 * A singelton for managing the positions of application windows.
 * 
 * @author Andreas Ruppen
 */
public class PositionManager {
    private static PositionManager INSTANCE = new PositionManager();
    
    private Point mainWindowPosition;
    private Point observerWindowPosition;

    /**
     * Creates a new instance of <code>PositionManager</code>.
     */
    protected PositionManager() {
        mainWindowPosition = new Point (100, 100);
        observerWindowPosition = new Point (280, 80);
    }
    
    /**
     * Returns the single instance of the <code>PositionManager</code> class.
     */
    public static PositionManager getUniqueInstance() {
        return INSTANCE;
    }
    
    /**
     * Returns the position for the main window.
     */
    public Point getMainWindowPosition() {
        return mainWindowPosition;
    }
    
    /**
     * Returns the position for a new clock window.
     */
    public Point getClockWindowPosition() {
        observerWindowPosition.translate(20, 20);
        return observerWindowPosition;
    }
}
