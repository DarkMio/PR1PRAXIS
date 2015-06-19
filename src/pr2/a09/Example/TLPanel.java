package pr2.a09.Example;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TLPanel extends JPanel {

    public TLPanel(String title, String label) {
        setBorder(new TitledBorder(title));
        add(new JLabel(label));
    }
}
