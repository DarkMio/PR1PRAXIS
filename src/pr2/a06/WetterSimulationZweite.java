package pr2.a06;

import javafx.event.EventHandler;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.ActionWACEvent;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.WeatherSensor;

public class WetterSimulationZweite {

    public static void main(String[] args) {

        Wetterzustand wz = new Wetterzustand();
        WeatherSensor ws_cloudy = new WeatherSensor(wz.cloudy, random());
        WeatherSensor ws_covered = new WeatherSensor(wz.covered, random());
        WeatherSensor ws_rainy = new WeatherSensor(wz.rainy, random());
        WeatherSensor ws_sunny = new WeatherSensor(wz.sunny, random());
        WeatherSensor ws_thunder = new WeatherSensor(wz.thunder, random());

        WeatherSensor[] array = new WeatherSensor[]{
                ws_cloudy, ws_covered, ws_rainy, ws_sunny, ws_thunder
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
