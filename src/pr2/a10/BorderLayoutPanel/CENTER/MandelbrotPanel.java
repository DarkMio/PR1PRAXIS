package pr2.a10.BorderLayoutPanel.CENTER;

import pr2.a10.Commands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MandelbrotPanel extends JPanel implements PropertyChangeListener {

    protected MandelbrotModel mm;
    protected int height, width, iterations, rMultiplier, gMultiplier, bMultiplier;
    protected double unit, zoom, x, y;


    public MandelbrotPanel(MandelbrotModel mm) {
        modelSetup(mm);
        setSize(300, 500);
        // init von model in main, dann pointer nur �bergeben
    }

    private void modelSetup(MandelbrotModel mm) {
        this.mm = mm;
        height = mm.getHeight();
        width = mm.getWidth();
        iterations = mm.getIterations();
        unit = mm.getUnit();
        zoom = mm.getZoom();
        x = mm.getX();
        y = mm.getY();
        mm.addPropertyChangeListener(this);
        rMultiplier = mm.getrMultiplier();
        gMultiplier = mm.getgMultiplier();
        bMultiplier = mm.getbMultiplier();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        double imc, rec;
        imc = y;
        g.setColor(new Color(0, 0, 0));
        for(int row = 0; row < height; row++) {
            rec = x;
            for(int col = 0; col < width; col++) {
                int complex = checkC(rec, imc);
                if (complex == iterations) {
                    g.setColor(new Color(0, 0, 0));
                } else {
                    g.setColor(new Color((rMultiplier*complex)%255, (gMultiplier*complex)%255,(bMultiplier*complex)%255));
                }
                g.drawRect((int) (col+this.x), (int) (row+this.y), 1, 1);
                rec += unit;
            }
            imc += unit;
        }
        System.out.println("MBP done! Iterations: " + iterations);
    }

    public int checkC(double reC,double imC) {
        double reZ=0, imZ=0, reZ_minus1=0, imZ_minus1=0;
        int i;

        for (i=0; i<iterations; i++) {
            imZ = 2*reZ_minus1*imZ_minus1+imC;
            reZ = reZ_minus1*reZ_minus1-imZ_minus1*imZ_minus1+reC;
            if (reZ*reZ+imZ*imZ > 4) return i;
            reZ_minus1 = reZ;
            imZ_minus1 = imZ;
        }
        return i;
    }

    public void onZoom() {
        height = mm.getHeight();
        width = mm.getWidth();
        iterations = mm.getIterations();
        unit = mm.getUnit();
        zoom = mm.getZoom();
        x = mm.getX();
        y = mm.getY();
        repaint();
    }

    public void onRecoloring() {
        rMultiplier = mm.getrMultiplier();
        gMultiplier = mm.getgMultiplier();
        bMultiplier = mm.getbMultiplier();
        repaint();
    }

    public void onResize() {
        height = mm.getHeight();
        width = mm.getWidth();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()) {
            case Commands.ZOOM:
                onZoom();
            case Commands.COLOR_MULTIPLIER:
                onRecoloring();
            case Commands.RESIZE:
                onResize();
            case Commands.RESET:
                modelSetup(mm);
        }
    }
}
