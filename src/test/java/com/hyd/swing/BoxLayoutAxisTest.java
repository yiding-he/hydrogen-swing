package com.hyd.swing;

import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.*;

public class BoxLayoutAxisTest extends JFrame {

    public static void main(String[] args) {
        Swing.openMainWindow(new BoxLayoutAxisTest(), 400, 300);
    }

    public BoxLayoutAxisTest() throws HeadlessException {
        JSplitPane sp0 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JSplitPane sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        sp0.add(sp1);
        sp0.add(sp2);

        setContentPane(sp0);

        sp1.add(createBoxLayout("X_AXIS", BoxLayout.X_AXIS));
        sp1.add(createBoxLayout("Y_AXIS", BoxLayout.Y_AXIS));
        sp2.add(createBoxLayout("LINE_AXIS", BoxLayout.LINE_AXIS));
        sp2.add(createBoxLayout("PAGE_AXIS", BoxLayout.PAGE_AXIS));
    }

    private Container createBoxLayout(String label, int axis) {
        Box box = new Box(axis);
        box.add(new JLabel(label));
        addButtons(box);
        return box;
    }

    private void addButtons(Container root) {
        for (int i = 0; i <4; i++) {
            root.add(new JButton("Button " + i));
        }
    }
}
