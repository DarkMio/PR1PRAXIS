package pr2.a06;

import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.WeatherComponentDrawable;

public class WeatherStateModel {

    protected WeatherComponentDrawable drawable;

    public WeatherStateModel(WeatherComponentDrawable drawable) {
        this.drawable = drawable;
    }

    public void changeWeather(String s) {
        drawable.setState(s);
    }
}
