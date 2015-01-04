package pr1.a09;


import java.awt.*;

public class Flower extends PflanzeInit {

    //Our flower needs petals!
    protected int petals;

    public Flower(int size, int posX, int posY, int activity, int maxSize, int petals) {
        super (size, posX, posY, activity, maxSize);
        this.petals = petals;
    }


    public void draw(Graphics g) {
        // Let's make a lot of orientation-points:
        int localsize = this.size * 5;

        int outerDiameter = localsize;
        int innerDiameter = localsize - (localsize/6);

        // per Petal
        double rotationPerElementDegree = 360.0 / petals;
        double rotationPerElementRadians = rotationPerElementDegree * Math.PI / 180;
        // two groups of petals make it pretty
        double rotationPerGroupDegree= rotationPerElementDegree/2.0;
        double rotationPerGroupRadians = rotationPerGroupDegree * Math.PI / 180;

        int circleRelCenterX = localsize / 2 + posX;
        int circleRelCenterY = localsize / 2 + posY;

        int ovalHeight = localsize / 3;
        int ovalWidth = localsize;

        int ovalPosX = circleRelCenterX + (innerDiameter/2) - (ovalWidth / 2);
        int ovalPosY = circleRelCenterY - (ovalHeight / 2);

        Graphics2D g2d = new Graphics(g);

        g2d.rotate(activity/2, circleRelCenterX, circleRelCenterY);

        for(int i = 0; i < petals; i++) {
            g2d.setColor(new Color(255, 182, 193));
            g2d.fillOval(ovalPosX, ovalPosY, ovalWidth, ovalHeight);
            g2d.rotate(rotationPerGroupRadians, circleRelCenterX, circleRelCenterY);
            g2d.setColor(new Color(255, 52, 179));
            g2d.fillOval(ovalPosX, ovalPosY, ovalWidth, ovalHeight);
            g2d.rotate(rotationPerGroupRadians, circleRelCenterX, circleRelCenterY);
        }
        g2d.setColor(new Color(176, 23, 31));
        g2d.fillOval(posX, posY, localsize, localsize);
        g2d.setColor(new Color(186, 33, 41));
        g2d.fillOval(posX+localsize/12, posY+localsize/12, innerDiameter, innerDiameter);




    }
}