package pr2.a07;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

import java.awt.*;

public class Smiley implements Drawable {

    private int x, y, size, eyeSize, eyeAngle;
    private boolean smiles;
    private double middleX, middleY;
    private Eyes eyes;
    private Mouth mouth;

    public Smiley(int x, int y, int size, int eyeSize, int eyeAngle, boolean smiles) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.eyeSize = eyeSize;
        this.eyeAngle = eyeAngle%360;
        this.smiles = smiles;
        this.middleX = x + size/2;
        this.middleY = y + size/2;
        this.eyes = new Eyes(middleX, middleY, size, eyeSize, eyeAngle);
        this.mouth = new Mouth(middleX, middleY, size, smiles);
    }

    public Smiley(int x, int y, int size) {
        this(x, y, size, 100, 0, true);
    }

    public void draw(Graphics g) {
        g.setColor(new Color(255, 207, 13));
        g.fillOval(x, y, size, size);
        g.setColor(new Color(0, 0, 0));
        g.drawOval(x, y, size, size);
        eyes.draw(g);
        mouth.draw(g);
    }

    class Eyes {

        int size, eyeSize, eyeAngle;
        double middleX, middleY;

        Eyes(double middleX, double middleY, int size, int eyeSize, int eyeAngle) {
            this.middleX = middleX;
            this.middleY = middleY;
            this.size = size;
            this.eyeSize = eyeSize;
            this.eyeAngle = eyeAngle;
        }

        Eyes(int middleX, int middleY, int size) {
            this(middleX, middleY, size, 100, 0);
        }

        void draw(Graphics g) {
            g.drawOval((int) (middleX - eyeSize - size/25), (int) (middleY-eyeSize/1.3), eyeSize, eyeSize);
            g.drawOval((int) (middleX + size/25), (int) (middleY-eyeSize/1.3), eyeSize, eyeSize);
        }
    }

    class Mouth {
        double x, y;
        int size;
        boolean smiling;

        Mouth (double xMiddle, double yMiddle, int size, boolean smiling) {
            this.x = xMiddle;
            this.y = yMiddle;
            this.size = size;
            this.smiling = smiling;
        }

        void draw(Graphics g) {
            g.setColor(Color.blue);
            g.drawArc((int) (x-size*0.75), (int) (y+size/6), size, size/5, 315, 45);
        }
    }
}
