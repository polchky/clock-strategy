package clock.analog;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

import clock.ClockPanel;

/**
 * A panel in which the analog clock is drawn.
 * 
 * @author Andreas Ruppen
 */
public class AnalogClockPanel extends ClockPanel {
    private static final long serialVersionUID = 3544948857483180340L;
    
    private Color ccolor = Color.lightGray;
    private Color ncolor = Color.black;
    private Color shcolor = Color.red;
    private Color mhcolor = Color.blue;
    private Color hhcolor = Color.green;
    private Color bgcolor = Color.white;
    private Font font = new Font("TimesRoman", Font.PLAIN, 10);
    
    private double sa = Math.PI / 2;
    private double sda = Math.PI / 30;
    private double mda = sda / 60;
    private double hda = mda / 12;
    private double nda = Math.PI / 6;
    
    private int hour;
    private int minute;
    private int second;
    
    /**
     * Creates a new instance of <code>AnalogClockPanel</code>.
     */
    public AnalogClockPanel() {
        setFont(font);
    }
    
    /**
     * Sets the clocks current time.
     */
    public void displayTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        repaint();
    }
    
    /**
     * Overrides the superclass method by drawing an analog clock in the panel.
     */
    protected void paintComponent(Graphics g) {       
        // Some geometric calculations.
        int width = getWidth();
        int height = getHeight();
        int border = 10;

        Point c = new Point(width / 2, height / 2);
        int r = (Math.min(width, height) / 2) - border;

        // Clear background.
        g.setColor(bgcolor);
        g.fillRect(0, 0, width, height);
        
        // Draw the clock components.
        drawClockNumbers(g, c, r);
        drawSecondHand(g, c, r, second);
        drawMinuteHand(g, c, r, minute, second);
        drawHourHand(g, c, r, hour, minute, second);
    }
    
    /**
     * Draws the clock numbers.
     */
    private void drawClockNumbers(Graphics g, Point c, int r) {
        // Draw the clock circle.
        g.setColor(ccolor);
        g.fillOval(c.x - r, c.y - r, 2 * r,  2 * r);
        g.setColor(ncolor);
        g.drawOval(c.x - r, c.y - r, 2 * r,  2 * r);
        
        // Draw the clock numbers.
        FontMetrics fm = getFontMetrics(font);
        int fa = fm.getMaxAscent();
        int fh = (fm.getMaxAscent() + fm.getMaxDescent()) / 2;
        int nr = (80 * r) / 100;
        for (int i = 0; i < 12; i++) {
            String ns = Integer.toString((i == 0) ? 12 : i);
            int nx = (int) ((Math.cos((i * nda) - sa) * nr) + c.x);
            int ny = (int) ((Math.sin((i * nda) - sa) * nr) + c.y);
            int w = fm.stringWidth(ns) / 2;
            
            g.drawString(ns, nx - w, ny + fa - fh);
        }
    }
    
    /**
     * Draws the clock's second hand.
     */
    private void drawSecondHand(Graphics g, Point c, int r, int s) {
        int sr = r;
        int sx = (int) ((Math.cos((s * sda) - sa) * sr) + c.x);
        int sy = (int) ((Math.sin((s * sda) - sa) * sr) + c.y);
        
        g.setColor(shcolor);
        g.drawLine(c.x, c.y, sx, sy);
    }
    
    /**
     * Draws the clock's minute hand.
     */
    private void drawMinuteHand(Graphics g, Point c, int r, int m, int s) {
        int ms = m * 60;
        int mr = (int) (.9 * r);
        int mx = (int) ((Math.cos(((ms + s) * mda) - sa) * mr) + c.x);
        int my = (int) ((Math.sin(((ms + s) * mda) - sa) * mr) + c.y);
        
        g.setColor(mhcolor);
        g.drawLine(c.x, c.y - 1, mx, my);
        g.drawLine(c.x - 1, c.y, mx, my);
    }
    
    /**
     * Draws the clock's hour hand.
     */
    private void drawHourHand(Graphics g, Point c, int r, int h, int m, int s) {
        int ms = m * 60;
        int hs = h * 60 * 60;
        int hr = (int) (.7 * r);
        int hx = (int) ((Math.cos(((hs + ms + s) * hda) - sa) * hr) + c.x);
        int hy = (int) ((Math.sin(((hs + ms + s) * hda) - sa) * hr) + c.y);

        g.setColor(hhcolor);
        g.drawLine(c.x, c.y - 1, hx, hy);
        g.drawLine(c.x - 1, c.y, hx, hy);
    }
}