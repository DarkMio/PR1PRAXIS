package pr2.a08;

import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MandelbrotView extends JPanel implements Drawable, PropertyChangeListener{

    DirtyPainter dp;
    MandelbrotModel mm;
    int height, width, iterations;
    double unit, zoom, x, y;


    public MandelbrotView(MandelbrotModel mm) {
        dp = new DirtyPainter();
        dp.add(this);
        this.mm = mm;
        height = mm.getHeight();
        width = mm.getWidth();
        iterations = mm.getIterations();
        unit = mm.getUnit();
        zoom = mm.getZoom();
        x = mm.getX();
        y = mm.getY();
        mm.addPropertyChangeListener(this);
        dp.showDrawing();
        // init von model in main, dann pointer nur übergeben
    }

    public void zoom(double xPos, double yPos) {
        if (yPos < mm.getWidth()) {
            double unit_old = mm.getUnit();

            if (mm.getIterations() == 3880760) return; // Maximum
            mm.setUnit(unit_old * 0.5);
            mm.setIterations((int) (mm.getIterations()*1.3));
            mm.setZoom(mm.getZoom()*2);


            mm.setX(mm.getX()-(200-xPos)*mm.getUnit() + (unit_old - mm.getUnit()) * xPos);
            mm.setY(mm.getY()-(185-yPos)*mm.getUnit() + (unit_old - mm.getUnit()) * yPos);
        }
    }

    @Override
    public void draw(Graphics g) {
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
            dp.showDrawingAfterWaiting(750);
            System.out.println("Should've drawn, m8.");
        }
    }
}
