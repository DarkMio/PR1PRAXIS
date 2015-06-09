package pr2.a07;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

import java.awt.*;

public class Mandelbrot implements Drawable{

    int height, width, max, x, y;

    public Mandelbrot(int x, int y, int height, int width, int max){
        this.height = height;
        this.width = width;
        this.max = max;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        for(int row = 0; row < height; row++) {
            for(int col = 0; col < width; col++) {
                double c_re = (col - width/2.0)*4.0/width;
                double c_im = (row - height/2.0)*4.0/width;
                double x = 0, y = 0;
                int iteration = 0;
                while(x*x+y*y <= 4 && iteration < max) {
                    double x_new = x*x - y*y + c_re;
                    y = 2*x*y + c_im;
                    x = x_new;
                    iteration++;
                }
                if (iteration < max) {
                    g.setColor(new Color((15*iteration)%255, (10*iteration)%255, 125+(iteration)%255));
                    g.drawRect(col+this.x, row+this.y, 1, 1);
                } else {
                    g.setColor(new Color(0, 0, 0));
                    g.drawRect(col+this.x, row+this.y, 1, 1);
                }
            }
        }
        System.out.println("Done!");
    }


}
