package com.hyd.swing;

import javax.swing.*;
import java.awt.*;

import static com.hyd.swing.Swing.PADDING;

public class AbstractLayoutTest extends JFrame {

    private static class LoginFormPanel extends AbstractPanel {

        private TextFormField userName;

        private TextFormField password;

        public LoginFormPanel() {
            add(userName = new TextFormField("用户名:"));
            add(password = new TextFormField("密码"));

            setTopOf(userName).spacing(PADDING).toTopOf(this);
            setLeftOf(userName).spacing(PADDING).toLeftOf(this);
            setRightOf(userName).spacing(-PADDING).toRightOf(this);

            setTopOf(password).spacing(PADDING).toBottomOf(userName);
            setLeftOf(password).spacing(PADDING).toLeftOf(this);
            setRightOf(password).spacing(-PADDING).toRightOf(this);
        }
    }

    public static void main(String[] args) {
        Swing.init();
        Swing.openMainWindow(new AbstractLayoutTest(), 400, 300);
    }

    public AbstractLayoutTest() throws HeadlessException {
        LoginFormPanel loginForm = new LoginFormPanel();
        this.setContentPane(loginForm);
    }
}
