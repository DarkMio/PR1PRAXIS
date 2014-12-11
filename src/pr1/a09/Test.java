package pr1.a09;


import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;

public class Test {

    public static void main(String[] args) {
        DirtyPainter painter = new DirtyPainter();
        Baum baum = new Baum(25, 250, 250, 100, 1000);
        Strauch strauch = new Strauch(100, 100, 100, 100, 1000);

        painter.add(baum);
        painter.add(strauch);

        for(int i = 0; i <= 10000; i++) {
            baum.ChangeActivityTo(i);
            painter.showDrawingAfterWaiting(100);
        }
    }
}
