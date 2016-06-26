package base.javabeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by csophys on 16/2/3.
 */

/**
 * 被观察者
 */
public class PropertyChangeTarget {

    public static PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(new PropertyChangeTarget());

    public static void main(String[] args) {
        PropertyChangeTarget.propertyChangeSupport.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt+"I am first observer");
            }
        });

        PropertyChangeTarget.propertyChangeSupport.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt + " I am second observer");
            }
        });

        PropertyChangeTarget.propertyChangeSupport.firePropertyChange("name","csophys", "chen sheng");
    }

}
