package pr2.a10.BorderLayoutPanel;

import pr2.a10.BorderLayoutPanel.CENTER.MandelbrotPanel;
import pr2.a10.BorderLayoutPanel.CENTER.MandelbrotModel;
import pr2.a10.BorderLayoutPanel.ButtonPanel.ButtonPanel;
import pr2.a10.Controller;
import pr2.a10.TLPanel;

import javax.swing.*;
import java.awt.*;


public class BorderLayoutPanel  extends JPanel {

    public BorderLayoutPanel() {
        setLayout(new BorderLayout());
        MandelbrotModel mm = new MandelbrotModel(-2.0, -1.3, 1700, 300, 100);
        MandelbrotPanel mp = new MandelbrotPanel(mm);
        Controller cont = new Controller();
        addComponentListener(cont);
        addMouseListener(cont);
        ButtonPanel bp = new ButtonPanel(cont);
        cont.setBp(bp);
        cont.setMm(mm);
        add(mp, BorderLayout.CENTER);
        add(bp, BorderLayout.SOUTH);
        mp.repaint();
    }
}
