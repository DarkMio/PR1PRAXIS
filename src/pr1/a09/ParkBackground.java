package pr1.a09;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

import java.awt.*;

public class ParkBackground implements Drawable {

    public void draw(Graphics g) {
        g.setColor(new Color(0, 232, 32));
        g.fillRect(0, 0, 10000, 10000);
    }
}
