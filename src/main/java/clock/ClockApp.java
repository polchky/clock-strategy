package clock;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import clock.analog.AnalogClock;
import clock.bargraph.BarGraphClock;
import clock.binary.BinaryClock;
import clock.binaryShapes.BinaryShapesClock;
import clock.digital.DigitalClock;
import clock.digitalNG.DigitalClockNG;
import clock.digitalLCD.DigitalClockLCD;
import clock.delayed.DelayedClock;
import clock.roman.RomanClock;
import clock.hourglass.HourGlassClock;
import clock.pacman.PacmanClock;
import clock.particle.app.ParticleClock;
import clock.tron.TronClock;
import clock.timer.ClockTimer;
import clock.util.PositionManager;



/**
 * The <code>ClockApp</code> class represents the application's main window.
 * 
 * @author Andreas Ruppen
 */
public class ClockApp extends JFrame {
    private static final long serialVersionUID = 3257286920185786678L;
    private ClockTimer timer;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JPanel panel;
    private JButton startButton;
    private JButton stopButton;
    private JButton analogClockButton;
    private JButton digitalClockButton;
    private JButton digitalClockNGButton;
    private JButton digitalClockLCDButton;
    private JButton binaryClockButton;
    private JButton binaryShapesClockButton;
    private JButton bargraphClockButton;
    private JButton delayedClockButton;
    private JButton romanClockButton;
    private JButton hourGlassClockButton;
    private JButton pacmanClockButton;
    private JButton particleClockButton;
    private JButton tronClockButton;


    /**
     * Creates a new instance of <code>ClockApp</code>.
     */
    public ClockApp() {
        // Create the timer;
        timer = new ClockTimer();

        // Set up the window.
        setTitle("Clock Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create and set up the menu bar.
        menuBar = new JMenuBar();
        addMenus();
        
        // Add the menu bar to the window.
        setJMenuBar(menuBar);
        
        // Create and set up the panel.
        panel = new JPanel(new GridLayout(0, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        addWidgets();

        // Add the panel to the window.
        getContentPane().add(panel, BorderLayout.CENTER);
        
        // Set screen position.
        setLocation(PositionManager.getUniqueInstance().getMainWindowPosition());
        
        // Display the window.
        pack();
        setVisible(true);
    }

    /**
     * Create and add the menus.
     */
    private void addMenus() {
        // Create and set up the file menu.
        fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);

        // Add the menu to the menu bar.
        menuBar.add(fileMenu);
    }
    
    /**
     * Create and add the widgets.
     */
    private void addWidgets() {
        // Create and set up the start button.
        startButton = new JButton("Start timer");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        // Create and set up the stop button.
        stopButton = new JButton("Stop timer");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        // Create and set up the analog clock button.
        analogClockButton = new JButton("analog clock");
        analogClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AnalogClock(timer);
            }
        });

        // Create and set up the digital clock button.
        digitalClockButton = new JButton("digital clock");
        digitalClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DigitalClock(timer);
            }
        });
		
	// Create and set up the digital clock button for the Next Generation.
        digitalClockNGButton = new JButton("digital clock NG");
        digitalClockNGButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DigitalClockNG(timer);
            }
        });
        
        // Create and set up the digital lcd clock button.
        digitalClockLCDButton = new JButton("lcd digital clock");
        digitalClockLCDButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DigitalClockLCD(timer);
            }
        });
        
        // Create and set up the binary clock button.
        binaryClockButton = new JButton("binary clock");
        binaryClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BinaryClock(timer);
            }
        });
        
        // Create and set up the binary clock button.
        binaryShapesClockButton = new JButton("binary shapes clock");
        binaryShapesClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BinaryShapesClock(timer);
            }
        });
        
        // Create and set up the bargraph clock button.
        bargraphClockButton = new JButton("bar graph clock");
        bargraphClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BarGraphClock(timer);
            }
        });
        
        // Create and set up the bargraph clock button.
        delayedClockButton = new JButton("delayed clock");
        delayedClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DelayedClock(timer);
            }
        });

	// Create and set up the Roman clock button.
        romanClockButton = new JButton("roman numbers clock");
        romanClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RomanClock(timer);
            }
        });

	// Create and set up the Hourglass clock button.
        hourGlassClockButton = new JButton("hourglass clock");
        hourGlassClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HourGlassClock(timer);
            }
        });

	// Create and set up the Pacman clock button.
        pacmanClockButton = new JButton("pacman clock");
        pacmanClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PacmanClock(timer);
            }
        });
        
                // Create and set up the Pacman clock button.
        particleClockButton = new JButton("particle clock");
        particleClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ParticleClock particleClock = new ParticleClock(timer);
                (new Thread(particleClock)).start();
            }
        });
        
        // Create and set up the Pacman clock button.
        tronClockButton = new JButton("tron clock");
        tronClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TronClock(timer);
            }
        });


        // Add the widgets to the content panel.
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(analogClockButton);
        panel.add(digitalClockButton);
	panel.add(digitalClockNGButton);
	panel.add(digitalClockLCDButton);
        panel.add(binaryClockButton);
        panel.add(binaryShapesClockButton);
        panel.add(bargraphClockButton);
        panel.add(delayedClockButton);
        panel.add(romanClockButton);
        panel.add(hourGlassClockButton);
        panel.add(pacmanClockButton);
        panel.add(particleClockButton);
        panel.add(tronClockButton);
    }

    /**
     * The application's main method.
     */
    public static void main(String[] args) {
        new ClockApp();
    }

}
