package pr1.a09;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;


public abstract class PflanzeInit implements Drawable {

    protected int size;

    protected int posX;
    protected int posY;

    protected int activity;
    protected int maxSize;


    public PflanzeInit(int size, int posX, int posY, int activity, int maxSize) {
        this.size = size;
        this.posX = posX;
        this.posY = posY;
        this.activity = activity;
        this.maxSize = maxSize;
    }

    public double getSize() {
        return size;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void ChangeActivityTo(int activity) {
        this.activity = activity;
    }

    public void setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

}
