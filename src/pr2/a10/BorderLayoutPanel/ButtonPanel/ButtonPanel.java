package pr2.a10.BorderLayoutPanel.ButtonPanel;

import pr2.a10.Commands;
import pr2.a10.Controller;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    protected JLabel label;
    protected JTextField rMultiplier;
    protected JTextField gMultiplier;
    protected JTextField bMultiplier;
    protected JButton zoom;

    public ButtonPanel(Controller cont) {
        label = new JLabel("Some size");
        rMultiplier = spawnTextField(cont, 4, Commands.COLOR_MULTIPLIER, "1773");
        gMultiplier = spawnTextField(cont, 4, Commands.COLOR_MULTIPLIER, "1784");
        bMultiplier = spawnTextField(cont, 4, Commands.COLOR_MULTIPLIER, "1784");
        zoom = new JButton("Set RGB Multiplier");

        zoom.setActionCommand(Commands.COLOR_MULTIPLIER);

        Timer xPointing = new Timer(0, cont);
        xPointing.setActionCommand(Commands.COLOR_MULTIPLIER);
        xPointing.setDelay(1000);

        Timer yPointing = new Timer(0, cont);
        yPointing.setActionCommand(Commands.COLOR_MULTIPLIER);
        yPointing.setDelay(1000);


        zoom.addActionListener(cont);

        setLayout(new FlowLayout());
        add(rMultiplier);
        add(gMultiplier);
        add(bMultiplier);
        add(zoom);
    }

    private static JTextField spawnTextField(Controller cont, int digits, String actionCommand, String defaultText) {
        JTextField tf = new JTextField(defaultText ,digits);
        tf.setActionCommand(actionCommand);
        tf.addActionListener(cont);
        return tf;
    }

    public int getRMultiplier() {
        return Integer.parseInt(rMultiplier.getText());
    }

    public int getGMultiplier() {
        return Integer.parseInt(gMultiplier.getText());
    }

    public int getBMultiplier() {
        return Integer.parseInt(bMultiplier.getText());
    }

}
