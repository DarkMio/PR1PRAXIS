package pr1.a09;


import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;

public class Test {

    public static void main(String[] args) {
        DirtyPainter painter = new DirtyPainter();
        Baum baum = new Baum(25, 250, 250, 100, 1000);
        Strauch strauch = new Strauch(100, 100, 100, 100, 1000);
        Flower flower = new Flower(30, 100, 100, 10, 100, 8);
        Tree tree = new Tree(7, 600, 600, 90, 150, -90);
        painter.add(tree);
        painter.add(baum);
//        painter.add(strauch);
        painter.add(flower);
//        painter.showDrawing();

        painter.showDrawing();
//        for(int i = 0; i <= 100; i++) {
//            if(i == 99){i = 0;}
//            tree.ChangeActivityTo(i);
//            painter.showDrawing();
//            try {
//                Thread.sleep(25/3);
//            } catch (InterruptedException e) {
//                System.out.println( "awakened prematurely" );
//            }
//        }
    }
}
