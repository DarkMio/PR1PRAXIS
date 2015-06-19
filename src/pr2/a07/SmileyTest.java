package pr2.a07;

import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.Drawable;

public class SmileyTest {

    public static void main(String[] args) {
        System.out.println("Tee.");
        DirtyPainter dp = new DirtyPainter();
        // Smiley smiley = new Smiley(10, 20, 250, 100, 0, true);
        // dp.add(smiley);
        Mandelbrot mb = new Mandelbrot(-2.0, -1.3, 800, 600, 100);
        // Mandelbrot2 mb = new Mandelbrot2(-2.0, -1.3, 200, 200, 50);
        dp.add(mb);
        dp.showDrawing();
        for(int i = 0; i < 100; i++) {
            mb.zoom(200.396307, 299.1376010225);
            dp.showDrawingAfterWaiting(1000);
            System.out.println("Tried to zoom");
       }
    }
}
