package pr2.a10;

import pr2.a09.FirstMandelbrotPanel;
import pr2.a09.MandelbrotModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mio on 25.06.2015.
 */
public class BorderLayoutPanel  extends JPanel {

    public BorderLayoutPanel() {
        setLayout(new BorderLayout());
        MandelbrotModel mm = new MandelbrotModel(-2.0, -1.3, 800, 600, 100);
        FirstMandelbrotPanel mp = new FirstMandelbrotPanel(mm);

        add(mp, BorderLayout.CENTER);
        add(new TLPanel("SOUTH", "S O U T H"), BorderLayout.SOUTH);
        add(new TLPanel("NORTH", "N O R T H"), BorderLayout.NORTH);
        add(new TLPanel("WEST", "W E S T"), BorderLayout.WEST);
        add(new TLPanel("EAST", "E A S T"), BorderLayout.EAST);
        mp.repaint();

    }
}
