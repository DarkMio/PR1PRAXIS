package pr2.a09;


import pr2.a09.Example.LayoutDemoPanel;

import javax.swing.*;
import java.awt.*;

public class FirstGui {

    public static void main(String[]args) {
        JFrame frame = new JFrame("Testpanel");
        Container container = frame.getContentPane();

        container.setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        MandelbrotModel mm = new MandelbrotModel(-2.0, -1.3, 800, 600, 100);
        FirstMandelbrotPanel mp = new FirstMandelbrotPanel(mm);
        mp.repaint();
        frame.add(mp);

        AAPCEventPrinter ap = new AAPCEventPrinter();
        Timer t = new Timer(1000, ap);
        t.start();
    }
}
