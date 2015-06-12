package pr2.a07;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;
import java.awt.*;

public class Mandelbrot2 implements Drawable {

    int height, width, max, iterations;
    double x, y;
    int zoom = 2;
    double unit = 0.007;

    public Mandelbrot2(double x, double y, int height, int width, int max){
        this.height = height;
        this.width = width;
        this.max = max;
        iterations=this.max;
        this.x = x;
        this.y = y;
    }

    public void zoom(int xPos, int yPos) {
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

    // C-Werte checken nach Zn+1 = Zn^2 + C.
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

    // Apfelmännchen zeichnen
    public void draw(Graphics g) {
        double reC, imC;
        int x,y;

        imC = this.y; // oberer Rand
        for (y=0;y<370;y++) {
            reC = this.x; // linker Rand
            for (x=0;x<400;x++) {
                int C = checkC(reC, imC);
                if (C != 0) {
                    System.out.println(C);
                }
                if(x==0 || x==399 || y==0 || y == 369)
                    g.setColor(new Color(100,100,100));
                else if(checkC(reC,imC)==iterations)
                    g.setColor(new Color(0,0,180));
                else g.setColor(new Color(0,200,250));

                g.drawLine(x,y,x,y);

                reC = reC+unit;
            }

            imC = imC+unit;
        }
    }
}
