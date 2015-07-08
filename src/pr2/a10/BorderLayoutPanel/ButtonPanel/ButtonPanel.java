package pr2.a10.BorderLayoutPanel.ButtonPanel;

import pr2.a10.Commands;
import pr2.a10.Controller;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    protected JLabel label;
    protected JSpinner rMultiplier;
    protected JSpinner gMultiplier;
    protected JSpinner bMultiplier;
    protected JButton reset;
    protected JButton zoom;

    public ButtonPanel(Controller cont) {
        label = new JLabel("Some size");
        reset = new JButton("Reset zoom");
        rMultiplier = spawnSpinner(0, 254, 253);
        gMultiplier = spawnSpinner(0, 254, 254);
        bMultiplier = spawnSpinner(0, 254, 254);
        zoom = new JButton("Set RGB Multiplier");
        reset.setActionCommand(Commands.RESET);
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

    private static JSpinner spawnSpinner(int min, int max, int def) {
        SpinnerNumberModel mdl = new SpinnerNumberModel(def, min, max, 1);
        return new JSpinner(mdl);
    }

    public int getRMultiplier() {
        return (int) rMultiplier.getValue();
    }

    public int getGMultiplier() {
        return (int) gMultiplier.getValue();
    }

    public int getBMultiplier() {
        return (int) bMultiplier.getValue();
    }

}
