package pr2.a03;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

import java.awt.*;

public class Text implements Drawable {

    private String s;
    private int x, y, size;

    public Text(String s, int x, int y) {
        this(s, x, y, 10);
    }

    public Text(String s, int x, int y, int size) {
        this.s = s;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.cyan);
        g.setFont(new Font("Arial", Font.PLAIN, size));
        g.drawString(s, x, y);
        g.setColor(c);
    }
}
