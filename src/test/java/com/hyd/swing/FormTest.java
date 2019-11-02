package com.hyd.swing;

import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

public class FormTest extends JFrame {

    public static void main(String[] args) {
        Swing.init();
        Swing.openMainWindow(new FormTest(), 400, 300);
    }

    private static class LoginForm extends FormPanel {

        private final TextFormField username;

        private final TextFormField password;

        LoginForm() {
            addFormField(username = new TextFormField("用户名:"));
            addFormField(password = new TextFormField("密码:"));
        }
    }

    public FormTest() throws HeadlessException {
        setTitle("登录");
        LoginForm loginForm = new LoginForm();

        Container container = getContentPane();
        container.setLayout(new MigLayout("nogrid, fill"));
        container.add(loginForm, "growx, wmax 300");
    }
}
