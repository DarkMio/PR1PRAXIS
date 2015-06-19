package pr2.a09;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mio on 18.06.2015.
 */
public class DemoGridLayoutPanel extends JPanel {

    public DemoGridLayoutPanel() {
        final int LINE_MAX = 2;
        final int COLUM_MAX = 5;
        setLayout(new GridLayout(LINE_MAX,  COLUM_MAX));
        for(int line = 0; line < LINE_MAX; ++line) {
            for(int column = 0; column < COLUM_MAX; ++column) {
                String label = "(" + line + ", " + column + ")";
                add(new TLPanel(label, label));
            }
        }
    }
}
