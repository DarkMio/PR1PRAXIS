package pr1.a09;


import java.awt.*;

public class Strauch extends PflanzeInit{

    public Strauch(int size, int posX, int posY, int activity, int maxSize) {
        super (size, posX, posY, activity, maxSize);
    }

    public void draw(Graphics g) {
        g.fillArc(posX, posY, size, size, 135, 270);
        g.drawOval(posX, posY, activity, activity);
    }
}
