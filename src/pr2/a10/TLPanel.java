package pr2.a10;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TLPanel extends JPanel {

    public TLPanel(String title, String label) {
        setBorder(new TitledBorder(title));
        setSize(5000, 0);
        add(new JLabel(label));
    }
}
