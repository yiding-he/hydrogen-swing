package com.hyd.swing;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.hyd.swing.layout.SpringLayout2;
import com.hyd.swing.layout.SpringPanel;

import javax.swing.*;
import java.awt.*;

public class TestSpringLayout2 extends JFrame {

    public static void main(String[] args) {
        Swing.init(new FlatDarculaLaf());
        Swing.openMainWindow(new TestSpringLayout2());
    }

    private final int padding = 20;
    private final int fieldHeight = 35;

    public TestSpringLayout2() throws HeadlessException {
        super(TestSpringLayout2.class.getSimpleName());
        var contentPane = new SpringPanel();
        setContentPane(contentPane);

        this.setMinimumSize(new Dimension(400, 180));
        contentPane.applyLayout(layout -> {
            var userNameLabel = contentPane.addComponent(new JLabel("用户名"));
            var userNameText = contentPane.addComponent(new JTextField());
            var passwordLabel = contentPane.addComponent(new JLabel("密码"));
            var passwordText = contentPane.addComponent(new JPasswordField());
            var loginButton = contentPane.addComponent(new JButton("登录"));

            layoutField(layout, contentPane, userNameLabel, userNameText, padding);
            layoutField(layout, contentPane, passwordLabel, passwordText, padding + fieldHeight);

            layout.setBottomOf(loginButton).withOffset(-padding).toBottomOf(contentPane);
            layout.setRightOf(loginButton).withOffset(-padding).toRightOf(contentPane);
        });
    }

    public void layoutField(SpringLayout2 layout, Container container, JLabel label, JTextField valueComponent, int topOffset) {
        layout.setLeftOf(label).withOffset(padding).toLeftOf(container);
        layout.setTopOf(label).withOffset(topOffset + 3).toTopOf(container);

        layout.setLeftOf(valueComponent).withOffset(60).toLeftOf(container);
        layout.setRightOf(valueComponent).withOffset(-padding).toRightOf(container);
        layout.setTopOf(valueComponent).withOffset(topOffset).toTopOf(container);
    }
}
