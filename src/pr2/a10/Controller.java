package pr2.a10;

import pr2.a10.BorderLayoutPanel.CENTER.MandelbrotModel;
import pr2.a10.BorderLayoutPanel.ButtonPanel.ButtonPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Controller implements ActionListener, MouseListener, ComponentListener {

    MandelbrotModel mm;
    ButtonPanel bp;

    public Controller() {
    }

    public void setMm(MandelbrotModel mm) {
        this.mm = mm;
    }

    public void setBp(ButtonPanel bp) {
        this.bp = bp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Commands.COLOR_MULTIPLIER)) {
            int r = bp.getRMultiplier();
            int g = bp.getGMultiplier();
            int b = bp.getBMultiplier();
            mm.colorMultiplierEvent(r, g, b);
        }
        if (e.getActionCommand().equals(Commands.RESET)) {
            mm = new MandelbrotModel();

        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        mm.zoomEvent(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void componentResized(ComponentEvent e) {
        mm.resizeEvent(e.getComponent().getWidth(), e.getComponent().getWidth());
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
