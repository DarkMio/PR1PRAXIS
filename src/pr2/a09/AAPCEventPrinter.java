package pr2.a09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

/**
 * Created by Mio on 19.06.2015.
 */


public class AAPCEventPrinter implements ActionListener {

    protected long time;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (time==0) {
            time = System.currentTimeMillis();
        }

        System.out.printf("Wetternachricht um %7d [ms]: %15s%n", System.currentTimeMillis()-time, e.getActionCommand());
    }
}
