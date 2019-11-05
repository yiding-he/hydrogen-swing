package com.hyd.swing;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.hyd.swing.layout.SpringPanel;
import java.awt.HeadlessException;
import javax.swing.*;

public class TestSpringLayout2 extends JFrame {

    public static void main(String[] args) {
        Swing.init(new FlatDarculaLaf());
        Swing.openMainWindow(new TestSpringLayout2(), 400, 300);
    }

    public TestSpringLayout2() throws HeadlessException {
        JLabel titleLabel, contentLabel;
        JTextField titleField;
        JScrollPane contentArea;
        JPanel splitter;

        SpringPanel root = new SpringPanel();
        setContentPane(root);

        SpringPanel labelsPanel = new SpringPanel();
        labelsPanel.add(titleLabel = new JLabel("文章标题："));
        labelsPanel.add(contentLabel = new JLabel("内容："));

        SpringPanel fieldsPanel = new SpringPanel();
        fieldsPanel.add(titleField = new JTextField());
        fieldsPanel.add(contentArea = new JScrollPane(new JTextArea()));
        fieldsPanel.add(splitter = new JPanel());

        root.add(labelsPanel);
        root.add(fieldsPanel);
    }
}
