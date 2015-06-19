package pr2.a09.Example;

import pr2.a09.Example.TLPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mio on 18.06.2015.
 */
public class DemoBorderLayoutPanel extends JPanel {

    public DemoBorderLayoutPanel() {
        setLayout(new BorderLayout());
        add(new TLPanel("CENTER", "C E N T E R"), BorderLayout.CENTER);
        add(new TLPanel("SOUTH", "S O U T H"), BorderLayout.SOUTH);
        add(new TLPanel("NORTH", "N O R T H"), BorderLayout.NORTH);
        add(new TLPanel("WEST", "W E S T"), BorderLayout.WEST);
        add(new TLPanel("EAST", "E A S T"), BorderLayout.EAST);
    }
}
