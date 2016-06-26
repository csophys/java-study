package books.headfirst.patternDesign.oberver;

import java.util.Observable;

/**
 * Created by csophys on 16/6/26.
 */

/**
 * 天气数据是一个主题
 */
public class WeatherData extends Observable {
    public void dataChange() {
        setChanged();
        notifyObservers("data changed");
    }
}
