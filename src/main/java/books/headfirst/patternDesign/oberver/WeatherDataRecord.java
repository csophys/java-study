package books.headfirst.patternDesign.oberver;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by csophys on 16/6/26.
 */
public class WeatherDataRecord implements Observer {

    WeatherDataRecord() {
    }

    public void addObservable(Observable observable){
        observable.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        System.out.println("weatherDataRecord:" + arg);
    }
}
