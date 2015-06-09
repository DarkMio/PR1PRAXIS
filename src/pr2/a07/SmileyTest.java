package pr2.a07;

import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.Drawable;

public class SmileyTest {

    public static void main(String[] args) {
        DirtyPainter dp = new DirtyPainter();
        // Smiley smiley = new Smiley(10, 20, 250, 100, 0, true);
        // dp.add(smiley);
        Mandelbrot mb = new Mandelbrot(20, 20, 1000, 1000, 100);
        dp.add(mb);
        dp.showDrawing();
    }
}
