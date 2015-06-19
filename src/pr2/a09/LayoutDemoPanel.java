package pr2.a09;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mio on 18.06.2015.
 */
public class LayoutDemoPanel extends JPanel {

    public LayoutDemoPanel() {
        setLayout(new GridLayout(2, 0));
        add(new DemoBorderLayoutPanel());
        add(new DemoGridLayoutPanel());
    }
}
