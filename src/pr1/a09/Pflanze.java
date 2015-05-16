package pr1.a09;

public interface Pflanze {

    double getSize();

    double setSize();

    double getX();
    double getY();

    void setPosition(double posX, double posY);

    void changeActivityTo(double activity);
}