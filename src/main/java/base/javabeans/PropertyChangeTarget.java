package base.javabeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by csophys on 16/2/3.
 */
public class PropertyChangeTarget {

    PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public static void main(String[] args) {
        PropertyChangeTarget propertyChangeFirer = new PropertyChangeTarget();
        propertyChangeFirer.addListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("first Listener receive the evt" + evt);
            }
        });
        propertyChangeFirer.addListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("last Listener receive the evt" + evt);
            }
        });

        propertyChangeFirer.propertyChangeSupport.firePropertyChange(new PropertyChangeEvent("source", "name", "cs", "csophys"));

    }

}
