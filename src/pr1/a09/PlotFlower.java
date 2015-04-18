package pr1.a09;

import java.awt.*;

public class PlotFlower extends PflanzeInit {

    protected int k;

    public PlotFlower(int size, int posX, int posY, int activity, int maxSize, int k) {
        super (size, posX, posY, activity, maxSize);
        this.k = k;
    }

    public void draw(Graphics g) {
        double x2 = 0;
        double y2 = 0;

        for(double t = -360; t < 360; t += 0.1) {
            double x = ((Math.cos(k*t) * Math.cos(t) * size*2) + posX) + size;
            double y = ((Math.cos(k*t) * Math.sin(t) * size*2) + posY) + size;
            if((x2 == 0)){x2 = x; y2 = y;}
            g.setColor(new Color(32, 108, 35));
            g.drawLine((int)x, (int)y, (int)x2, (int)y2);
            g.setColor(new Color(108, 35, 32));
            int locSize = size / 5;
            g.fillOval(posX + size/2, posY + size/2, size, size);
            x2 = x;
            y2 = y;
        }
    }

    public void changeKTo(int k) {
        this.k = k;
    }
}
