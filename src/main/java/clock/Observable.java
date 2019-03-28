package clock;

import java.util.Vector;

/**
 * A class can implement the <code>Observer</code> interface when it wants to be informed of changes in observable objects.
 * 
 * @author Arnaud Durand
 */
public abstract class Observable {

    private Vector<Observer> observers = new Vector<Observer>();

    /**
     * Attaches a new observer to this subject.
     */
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Detaches am observer from this subject.
     */
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Notifies all observers that are attached to this subject.
     */
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this, null);
        }
    }
    
    public void notifyObservers(Object arg) {
        for (Observer o : observers) {
            o.update(this, arg);
        }
    }
}
