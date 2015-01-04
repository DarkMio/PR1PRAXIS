package pr1.a09;

import java.awt.*;
import java.util.Random;

public class Tree extends PflanzeInit {

    protected double angle;
    protected Color tree;
    protected Color foliage;
    protected int cycles;
    protected double transangle;

    public Tree(int size, int posX, int posY, int activity, int maxSize, int cycles) {
        super (size, posX, posY, activity, maxSize);
        this.cycles = cycles;
        tree = new Color(89, 35, 19);
        foliage = new Color(9, 89, 8);
        angle = -90;
    }

    public void drawCircles(Graphics g, int x1, int y1, double angle, int size, int cycles) {
        // Draws the leavlets of a tree
        double pos = size * 10 /2;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * pos);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * pos);
        if (cycles <= 2) {
            int leaves = (size + 1) * (cycles + size);
            int halfleaves = leaves / 2;
            g.fillOval(x1 - halfleaves, y1 - halfleaves, leaves, leaves);
        }
        if (cycles == 0) {
            return;
        }

        drawCircles(g, x2, y2, angle - transangle, size, cycles - 1);
        drawCircles(g, x2, y2, angle + transangle, size, cycles - 1);
    }

    public void drawTree(Graphics g, int x1, int y1, double angle, int size, int cycles) {
        // Draws branches of the tree.
        double pos = size * 10 /2;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * pos);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * pos);
        if (cycles == 0) {
            return;
        }
        g.drawLine(x1, y1, x2, y2);

        drawTree(g, x2, y2, angle - transangle, size, cycles - 1);
        drawTree(g, x2, y2, angle + transangle, size, cycles - 1);
    }

    public void draw(Graphics g) {
      //  double tangle = angle - activity;
      //  int tactivity = activity - 1;
      //  System.out.println("Angle: " +  tangle + " Activity: " + tactivity);
        transangle = (165 / cycles) * activity/100;
        g.setColor(foliage);
        drawCircles(g, posX, posY, angle, size, cycles);
        g.setColor(tree);
        drawTree(g, posX, posY, angle, size, cycles);
    }
}
