package com.hyd.swing;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.hyd.swing.dialog.Alert;

import javax.swing.*;
import java.awt.*;

public class AlertTest extends JFrame {

    public static void main(String[] args) {
        Swing.init(new FlatDarculaLaf());
        Swing.openMainWindow(new AlertTest(), 400, 300);
    }

    public AlertTest() throws HeadlessException {
        super("SwingTest");

        Alert alert = Alert.of(this);
        Container pane = getContentPane();

        pane.setLayout(new FlowLayout());
        pane.add(button("alert info", () -> alert.info("Alert", "Something happened.")));
        pane.add(button("alert warning", () -> alert.warning("Alert", "Something dangerous happened.")));
        pane.add(button("alert error", () -> alert.error("Alert", "Something had happened!")));

        pane.add(button("confirm info", () ->
            System.out.println(alert.confirmInfo("Confirm", "Please confirm this."))));
        pane.add(button("confirm warning", () ->
            System.out.println(alert.confirmWarning("Confirm", "You really want this?!"))));

        pane.add(button("alert internal info", () ->
            alert.internalInfo("Alert Internal", "Something happened.")));
    }

    private JButton button(String text, Runnable action) {
        JButton jButton = new JButton(text);
        jButton.addActionListener(event -> action.run());
        return jButton;
    }
}