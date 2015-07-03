package pr2.a10;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.beans.PropertyChangeSupport;


public class ZoomButton extends JPanel {

    public ZoomButton() {
        JButton jb = new JButton("zoom");
        jb.setActionCommand("zoom");
        add(jb);
    }
}
