package pr2.a09.Example;

import pr2.a09.Example.LayoutDemoPanel;

import javax.swing.*;
import java.awt.*;

public class FirstPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Testpanel");
        Container container = frame.getContentPane();

        container.setLayout(new BorderLayout());
        container.add(new LayoutDemoPanel(), BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
