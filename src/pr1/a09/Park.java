package pr1.a09;

import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Park {

    public static void main(String[] args) {
        boolean forward = true;
        DirtyPainter painter = new DirtyPainter();
        Collection<PflanzeInit> park = factoryPark(3, 1);
        painter.add(new ParkBackground());
        for(PflanzeInit p:park) {
            painter.add(p);
        }
        painter.showDrawing();

        for(int i = 0; i <= 102; i++) {
            if(i >= 100) {
                forward = false;
            }
            if(i <= 0) {
                forward = true;
            }
            if(!forward) {
                i -= 2;
            }

            System.out.println(i);
            for(PflanzeInit p: park) {
                    p.grow();
                    p.changeActivityTo(i);
                }
            painter.showDrawingAfterWaiting(1);
        }
    }

    public static Collection<PflanzeInit> factoryPark(int flowerCnt, int treeCnt) {
        Collection<PflanzeInit> park = new ArrayList<PflanzeInit>();

        for(int i = 0; i <= treeCnt; i++) {
            int size = 3 + (int)(Math.random() * ((10 - 3) + 1));
            int posX = 100 + (int)(Math.random() * ((1200 - 100) + 1));
            int posY = 300 + (int)(Math.random() * ((700 - 300) + 1));
            int activity = (int)(Math.random() * (100 + 1));
            int cycles = 4 + (int)(Math.random() * ((12 - 4) + 1));
            park.add(new Tree(size, posX, posY, activity, size+5, cycles));
        }

        for(int i = 0; i <= flowerCnt; i++) {
            int size = 5 + (int)(Math.random() * ((20 - 5) + 1));
            int posX = 100 + (int)(Math.random() * ((1200 - 100) + 1));
            int posY = 300 + (int)(Math.random() * ((700 - 300) + 1));
            int activity = (int)(Math.random() * (100 + 1));
            int petals = 3 + (int)(Math.random() * ((15 - 3) + 1));
            park.add(new Flower(size, posX, posY, activity, size+5, petals));
        }
    return park;
    }
}
