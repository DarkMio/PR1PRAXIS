//																	Zier, 824320
package pr1.a08;

import java.awt.Color;
import java.awt.Graphics;

import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

public class Gitter implements Drawable {

    protected Color c;
    protected int dx;
    protected int dy;
    protected final int maxX = 1000;
    protected final int maxY = 1000;

    public Gitter(Color c, int dx, int dy) {
        this.c = c;
        this.dx = dx;
        this.dy = dy;
    }

    public Gitter(Gitter other) {
        this(other.c, other.dx, other.dy);
    }

    public Gitter(int dx, int dy) {
        c = Color.YELLOW;
        this.dx = dx;
        this.dy = dy;
    }

    public Gitter() {
        c = Color.BLUE;
        dx = 100;
        dy = 100;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public Color getC() {
        return c;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        for(int x = 0; x <= maxX; x += getDx()) {
            for(int y = 0; y <= maxY; y += getDy()) {
                g.drawLine(0, y, 1000, y);
            }
            g.drawLine(x, 0, x, 1000);
        }
    }
}
