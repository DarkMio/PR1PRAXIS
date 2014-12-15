package pr1.a09;

import java.awt.*;
import java.util.Random;

public class Tree extends PflanzeInit {

    protected double angle;
    protected Color tree;
    protected Color foliage;

    public Tree(int size, int posX, int posY, int activity, int maxSize, double angle) {
        super (size, posX, posY, activity, maxSize);
        this.angle = angle;
        tree = new Color(89, 35, 19);
        foliage = new Color(9, 89, 8);
    }

    public void drawTree(Graphics g, int x1, int y1, double angle, int activity, int size) {
        if (activity <= 3) {
            g.setColor(foliage);
            g.fillOval(x1, y1, (size+activity)*3, (size+activity)*3);
            g.setColor(tree);
        }
        if (activity == 0) {
            return;
        }
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * activity * size) /2;
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * activity * size) /2;
        g.drawLine(x1, y1, x2, y2);
        double randNum = Math.random();
        drawTree(g, x2, y2, angle - 20, activity - 1, size);

        drawTree(g, x2, y2, angle + 20, activity - 1, size);

    }

    public void draw(Graphics g) {
        g.setColor(tree);
        drawTree(g, posX, posY, angle, activity/8, size);
    }
}
