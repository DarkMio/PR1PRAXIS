package pr2.a09;

import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MandelbrotModel {

    protected PropertyChangeSupport pcs;
    int height, width, iterations, rMultiplier, gMultiplier, bMultiplier;
    double unit, zoom, x, y;

    public void setrMultiplier(int rMultiplier) {
        this.rMultiplier = rMultiplier;
    }

    public void setgMultiplier(int gMultiplier) {
        this.gMultiplier = gMultiplier;
    }

    public void setbMultiplier(int bMultiplier) {
        this.bMultiplier = bMultiplier;
    }

    public int getrMultiplier() {

        return rMultiplier;
    }

    public int getgMultiplier() {
        return gMultiplier;
    }

    public int getbMultiplier() {
        return bMultiplier;
    }

    public MandelbrotModel(double x, double y, int height, int width, int iterations) {
        this.height = height;
        this.width = width;
        this.iterations = iterations;
        this.x = x;
        this.y = y;
        this.unit = 0.007;
        pcs = new PropertyChangeSupport(this);
        this.rMultiplier = 15;
        this.gMultiplier = 20;
        this.bMultiplier = 125;

    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getIterations() {
        return iterations;
    }

    public double getUnit() {
        return unit;
    }

    public double getZoom() {
        return zoom;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public void zoomEvent(double x, double y){
        zoom(x, y);
        if (this.x != x) {
            pcs.firePropertyChange("MODEL_UPDATE", this.x, x);
        }
        if (this.y != y) {
            pcs.firePropertyChange("MODEL_UPDATE", this.y, y);
        }
    }

    public void zoom(double xPos, double yPos) {
        if (yPos < width) {
            double unit_old = unit;

            if (iterations == 3880760) return; // Maximum
            unit *= 0.5;
            iterations = (int)(iterations*1.3);
            zoom *= 2;


            x = x-(width/2-xPos)*unit + (unit_old - unit) * xPos;
            y = y-(height/2-yPos)*unit + (unit_old - unit) * yPos;
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

}
