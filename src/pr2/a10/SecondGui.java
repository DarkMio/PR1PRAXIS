package pr2.a10;

import pr2.a10.BorderLayoutPanel.BorderLayoutPanel;

import javax.swing.*;
import java.awt.*;

public class SecondGui {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mandelbrot Super Panel");
        Container container = frame.getContentPane();

        container.setLayout(new BorderLayout());
        container.add(new BorderLayoutPanel(), BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
