package pr2.a06;

import javafx.event.EventHandler;
import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.ActionWACEvent;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.WeatherComponentDrawable;

public class WetterstationEinfache implements EventHandler<ActionWACEvent> {

    private Controller controller;
    private WeatherStateModel wsm;
    private WeatherComponentDrawable wcd;
    private DirtyPainter dp;

    public WetterstationEinfache() {
        dp = new DirtyPainter();
        wcd = new WeatherComponentDrawable();
        wsm = new WeatherStateModel(wcd);
        controller = new Controller(wsm, dp);

        dp.add(wcd);
    }

    public void handle(ActionWACEvent ae) {
       controller.handle(ae);
    }
}
