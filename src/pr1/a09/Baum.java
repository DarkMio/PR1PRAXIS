package pr1.a09;


import java.awt.*;

public class Baum extends PflanzeInit{

    public Baum(int size, int posX, int posY, int activity, int maxSize) {
        super (size, posX, posY, activity, maxSize);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(posX, posY, size, size * 3);
        g.setColor(Color.GREEN);
        g.fillOval(posX - size, posY - size * 2, size * 3, size * 3);
        g.setColor(Color.RED);
        g.fillOval(size / 4 + posX, posY - size, activity / 10, activity / 10);
        g.fillOval(size/4 + posX+size/2, posY+size/2 - size, activity/10, activity/10);
        g.fillOval(size/4 + posX-size/2, posY+size/2 - size, activity/10, activity/10);

    }
}
