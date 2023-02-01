package com.hyd.swing;

import javax.swing.*;
import java.awt.*;

public class BoxAlignmentTest extends JFrame {

    public static void main(String[] args) {
        BoxAlignmentTest test = new BoxAlignmentTest();
        test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        test.setSize(500, 200);
        test.setVisible(true);
    }

    public BoxAlignmentTest() throws HeadlessException {
        Box box = Box.createVerticalBox();
        setContentPane(box);

        JLabel label = new JLabel("This label isn't fully left-aligned.");
        label.setOpaque(true);
        label.setBackground(Color.orange);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        box.add(label);

        JScrollPane scrollPane = new JScrollPane(new JTextArea("This is a text area."));
        // scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        box.add(scrollPane);
    }
}
