package pr2.a09;

import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FirstMandelbrotPanel extends JPanel implements PropertyChangeListener{

    MandelbrotModel mm;
    int height, width, iterations;
    double unit, zoom, x, y;


    public FirstMandelbrotPanel(MandelbrotModel mm) {
        modelSetup(mm);
        // init von model in main, dann pointer nur übergeben
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
                    g.setColor(new Color((15*complex)%255, (10*complex)%255, 125+complex%125));
                }
                g.drawRect((int) (col+this.x), (int) (row+this.y), 1, 1);
                rec += unit;
            }
            imc += unit;
        }
        System.out.println("Done! Iterations: " + iterations);
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("MODEL_UPDATE")){
            height = mm.getHeight();
            width = mm.getWidth();
            iterations = mm.getIterations();
            unit = mm.getUnit();
            zoom = mm.getZoom();
            x = mm.getX();
            y = mm.getY();
            repaint();
            System.out.println("Should've drawn, m8.");
        }
    }


}
