package com.hyd.swing;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.hyd.swing.layout.SpringLayout2.Edge;
import com.hyd.swing.layout.SpringPanel;

import javax.swing.*;
import java.awt.*;

public class TestSpringLayout2 extends JFrame {

    public static void main(String[] args) {
        Swing.init(new FlatDarculaLaf());
        Swing.openMainWindow(new TestSpringLayout2(), 400, 300);
    }

    public TestSpringLayout2() throws HeadlessException {

        SpringPanel root = new SpringPanel() {{
            JLabel label = new JLabel("AAAAAAAAAAA");
            add(label);
            getLayout().align(Edge.TOP, this, label);
            getLayout().align(Edge.LEFT, this, label);

            SpringPanel panel2 = new SpringPanel(){{
                JLabel label2 = new JLabel("label2");
                add(label2);
                getLayout().align(Edge.LEFT, this, label2);
                getLayout().setBottomOf(this).padding(0).toBottomOf(label2);
                Swing.highlight("#000066", this);
            }};

            add(panel2);
            getLayout().setTopOf(panel2).padding(10).toBottomOf(label);
            getLayout().align(Edge.LEFT, this, panel2);
            getLayout().align(Edge.RIGHT, this, panel2);
            getLayout().align(Edge.BOTTOM, this, panel2);
        }};

        setContentPane(root);
    }
}
