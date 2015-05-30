package pr2.a06;


import javafx.event.EventHandler;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.ActionWACEvent;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.WeatherSensor;


public class WetterSimulationErste {

    public static void main(String[] args) {
        Wetterzustand wz            = new Wetterzustand();
        WeatherSensor ws_cloudy     = new WeatherSensor(wz.cloudy, random());
        WeatherSensor ws_covered    = new WeatherSensor(wz.covered, random());
        WeatherSensor ws_rainy      = new WeatherSensor(wz.rainy, random());
        WeatherSensor ws_sunny      = new WeatherSensor(wz.sunny, random());
        WeatherSensor ws_thunder    = new WeatherSensor(wz.thunder, random());

        EventHandler<ActionWACEvent> ae = new WetterPrinter();

        ws_cloudy.addEventHandler(ae);
        ws_covered.addEventHandler(ae);
        ws_rainy.addEventHandler(ae);
        ws_sunny.addEventHandler(ae);
        ws_thunder.addEventHandler(ae);

        ws_cloudy.start();
        ws_covered.start();
        ws_rainy.start();
        ws_sunny.start();
        ws_thunder.start();
    }

    private static int random() {
        return (int) (Math.random()*10000);
    }
}
