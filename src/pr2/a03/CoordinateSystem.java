package pr2.a03;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

import java.awt.*;

public class CoordinateSystem implements Drawable {

    private int[] a;
    private int height, width;

    public CoordinateSystem(int[] a, int height, int width) {
        this.a = a;
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw(Graphics g) {
        int first = a[0];
        int last = a[a.length-1];
        int midX = width/2;
        int midY = height/2;
        double incrementWidth = midX/25;
        double incrementHeight = midY/25;
        g.setColor(Color.cyan);
        g.setFont(new Font("Arial", 10, 10));
        g.drawLine(midX, 0, midX, height);
        g.drawLine(0, 0, width, 0);
        g.setColor(Color.red);
        g.drawString(a[a.length/2]+"", midX + 10, 20);
        g.drawString(a[0]+"", 0, 20);
        g.drawString(a[a.length-1]+"", width-30, 20);
        for(double i = incrementWidth; i <= width; i += incrementWidth + 1) {
            g.drawLine((int) i, -5, (int) i, 5);
        }

        for(double i = incrementHeight; i <= height; i += incrementHeight + 1) {
            g.drawLine(midX - 5, (int) i, midX + 5, (int) i);
        }
        g.setColor(Color.cyan);


    }
}
