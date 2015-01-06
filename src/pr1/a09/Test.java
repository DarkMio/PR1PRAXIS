package pr1.a09;


import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;

public class Test {

    public static void main(String[] args) {
        DirtyPainter painter = new DirtyPainter();
//        Baum baum = new Baum(25, 250, 250, 100, 1000);
//        Strauch strauch = new Strauch(100, 100, 100, 100, 1000);
        Flower flower = new Flower(30, 100, 100, 10, 100, 6);
        Flower flower2 = new Flower(10, 400, 400, 10, 100, 8);
        Tree tree = new Tree(7, 600, 1000, 100, 15, 10);
        painter.add(tree);
      //  painter.add(flower2);
//        painter.add(baum);
//        painter.add(strauch);
//        painter.add(flower);
//        painter.showDrawing();

        painter.showDrawing();
        for(int i = 0; i <= 102; i++) {
            if(i == 101){i = 0;}
//            flower.changeActivityTo(i);
//            flower2.changeActivityTo(i);
            tree.grow();
            tree.changeActivityTo(i);
            painter.showDrawing();
            try {
                Thread.sleep(12);
            } catch (InterruptedException e) {
                System.out.println( "awakened prematurely" );
            }
        }
    }
}
