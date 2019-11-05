package com.hyd.swing;

import com.hyd.swing.form.*;
import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

public class FormTest extends JFrame {

    public static void main(String[] args) {
        Swing.init();
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

        Container container = getContentPane();
        container.setLayout(new MigLayout("nogrid, fill"));
        container.add(loginForm, "growx, wmax 260, center");
    }
}
