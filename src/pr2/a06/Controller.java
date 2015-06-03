package pr2.a06;


import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.ActionWACEvent;
import schimkat.berlin.lernhilfe2015ss.DIRTY.weathersimulationFX.WeatherComponentDrawable;

public class Controller {

    private String[] wz = new Wetterzustand().returnWeatherStates();
    private WeatherStateModel wsm;
    private DirtyPainter dp;

    public Controller (WeatherStateModel wsm, DirtyPainter dp) {
        this.wsm = wsm;
        this.dp = dp;
    }

    public void handle (ActionWACEvent ae) {
        for(String s: wz) {
            if (s.equals(ae.getActionCommand())) {
                wsm.changeWeather(ae.getActionCommand());
                dp.showDrawing();
                return;
            }
        }
    }
}
