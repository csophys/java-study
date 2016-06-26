package books.headfirst.patternDesign.oberver;

import org.junit.Test;

/**
 * Created by csophys on 16/6/26.
 */
public class WeatherDataTest {


    @Test
    public void fireDataChange() {
        WeatherData weatherData = new WeatherData();

        //后观察的先被通知到

        new WeatherDataRecord().addObservable(weatherData);
        new WeatherDataDisplay().addObservable(weatherData);
        new WeatherDataDisplay().addObservable(weatherData);
        new WeatherDataDisplay().addObservable(weatherData);
        new WeatherDataRecord().addObservable(weatherData);
        new WeatherDataDisplay().addObservable(weatherData);

        weatherData.dataChange();
    }

}