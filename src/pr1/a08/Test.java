package pr1.a08;

import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;

import java.awt.*;


public class Test {
    public static void main(String[] args) {
        DirtyPainter painter = new DirtyPainter();
        Gitter gitter00 = new Gitter();
        Gitter gitter01 = new Gitter(gitter00);
        Gitter gitter02 = new Gitter(Color.BLACK, 25, 25);
        Gitter gitter03 = new Gitter(50, 50);

        painter.add(gitter01);
        painter.add(gitter02);
        painter.add(gitter03);
        painter.add(gitter00);
        painter.showDrawing();
    }
}