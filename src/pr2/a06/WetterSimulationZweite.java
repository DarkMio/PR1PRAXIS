package pr2.a06;

import javafx.event.EventHandler;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.ActionWACEvent;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.WeatherSensor;

public class WetterSimulationZweite {

    public static void main(String[] args) {

        Wetterzustand wz = new Wetterzustand();

        WeatherSensor[] array = new WeatherSensor[]{
                new WeatherSensor(wz.cloudy, random()),
                new WeatherSensor(wz.covered, random()),
                new WeatherSensor(wz.rainy, random()),
                new WeatherSensor(wz.sunny, random()),
                new WeatherSensor(wz.thunder, random())
        };

        EventHandler<ActionWACEvent> ae = new WetterPrinter();
        EventHandler<ActionWACEvent> ws = new WetterstationEinfache();

        for(WeatherSensor sensor: array) {
            sensor.addEventHandler(ae);
            sensor.addEventHandler(ws);
            sensor.start();
        }

    }

    private static int random() {
        return (int) (Math.random()*10000);
    }

}
