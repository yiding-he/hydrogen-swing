package com.hyd.swing;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.hyd.swing.form.FormPanel;
import com.hyd.swing.form.PasswordFormField;
import com.hyd.swing.form.TextFormField;
import com.hyd.swing.layout.SpringLayout2.Edge;
import com.hyd.swing.layout.SpringPanel;

import javax.swing.*;
import java.awt.*;

public class FormTest extends JFrame {

    public static void main(String[] args) {
        Swing.init(new FlatDarculaLaf());
        Swing.openMainWindow(new FormTest(), 400, 300);
    }

    private static class LoginForm extends FormPanel {

        private final JButton loginButton;

        private final TextFormField username;

        private final PasswordFormField password;

        LoginForm() {
            addFormField(username = new TextFormField("用户名:"));
            addFormField(password = new PasswordFormField("密码:"));
            addButton(loginButton = new JButton("登录"));
        }
    }

    public FormTest() throws HeadlessException {
        setTitle("登录");
        LoginForm loginForm = new LoginForm();
        setContentPane(new SpringPanel() {{
            add(loginForm);
            getLayout().padding(this, 30, loginForm, Edge.TOP, Edge.RIGHT, Edge.BOTTOM, Edge.LEFT);
        }});
    }
}
