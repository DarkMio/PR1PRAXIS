package pr2.a07;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Mandelbrot implements Drawable{

    int height, width, max, iterations;
    double unit, zoom, x, y;

    public Mandelbrot(double x, double y, int height, int width, int max) {
        this.height = height;
        this.width = width;
        this.max = max;
        this.iterations = max;
        this.x = x;
        this.y = y;
        this.unit = 0.007;
    }

    public void zoom(double xPos, double yPos) {
        if (yPos < width) {
            double unit_old = unit;

            if (iterations == 3880760) return; // Maximum
            unit *= 0.5;
            iterations = (int)(iterations*1.3);
            zoom *= 2;


            x = x-(200-xPos)*unit + (unit_old - unit) * xPos;
            y = y-(185-yPos)*unit + (unit_old - unit) * yPos;
        }
    }

    public void draw(Graphics g) {
        g = (Graphics2D) g;
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


}
