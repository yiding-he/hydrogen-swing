package com.hyd.swing;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame {

    public static void main(String[] args) {
        Swing.init(new FlatDarculaLaf());
        Swing.openMainWindow(new SwingTest(), 400, 300);
    }

    public SwingTest() throws HeadlessException {
        super("SwingTest");
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(button("alert info", () -> Swing.alertInfo("Alert", "Something happened.")));
        contentPane.add(button("alert warning", () -> Swing.alertWarning("Alert", "Something dangerous happened.")));
        contentPane.add(button("alert error", () -> Swing.alertError("Alert", "Something had happened!")));

        contentPane.add(button("confirm info", () ->
            System.out.println(Swing.confirmInfo("Confirm", "Please confirm this."))));
        contentPane.add(button("confirm warning", () ->
            System.out.println(Swing.confirmWarning("Confirm", "You really want this?!"))));

        contentPane.add(button("alert internal info", () ->
            Swing.alertInternalInfo(this.getContentPane(), "Alert Internal", "Something happened.")));
    }

    private JButton button(String text, Runnable action) {
        JButton jButton = new JButton(text);
        jButton.addActionListener(event -> action.run());
        return jButton;
    }
}