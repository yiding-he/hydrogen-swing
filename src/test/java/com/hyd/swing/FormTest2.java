package com.hyd.swing;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.hyd.swing.form.*;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class FormTest2 extends JFrame {

    public static void main(String[] args) {
        Swing.init(new FlatDarculaLaf());
        Swing.openMainWindow(new FormTest2(), 500, 500);
    }

    private static class MyFormPanel extends FormPanel {

        public MyFormPanel() {
            getLayoutConstraints().insets("10");
            addFormField(new TextFormField("标题"));
            addFormField(new TextAreaFormField("内容"));
        }
    }

    public FormTest2() throws HeadlessException {
        setContentPane(new MyFormPanel());
    }
}
