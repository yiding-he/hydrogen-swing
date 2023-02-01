package com.hyd.swing.dialog;

import javax.swing.*;
import java.awt.*;

public class Alert {

    private final Component parentComponent;

    public static void alertInternalInfo(Component parent, String title, String message) {
        JOptionPane.showInternalMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static Alert of(Component parentComponent) {
        return new Alert(parentComponent);
    }

    private Alert(Component parentComponent) {
        this.parentComponent = parentComponent;
    }

    public void internalInfo(String title, String message) {
        if (this.parentComponent instanceof RootPaneContainer) {
            var rootPane = ((RootPaneContainer) this.parentComponent).getContentPane();
            JOptionPane.showInternalMessageDialog(rootPane, message, title, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void info(String title, String message) {
        JOptionPane.showMessageDialog(this.parentComponent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void warning(String title, String message) {
        JOptionPane.showMessageDialog(this.parentComponent, message, title, JOptionPane.WARNING_MESSAGE);
    }

    public void error(String title, String message) {
        JOptionPane.showMessageDialog(this.parentComponent, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public boolean confirmInfo(String title, String message) {
        int result = JOptionPane.showConfirmDialog(
            this.parentComponent, message, title,
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE
        );
        return result == JOptionPane.YES_OPTION;
    }

    public boolean confirmWarning(String title, String message) {
        int result = JOptionPane.showConfirmDialog(
            this.parentComponent, message, title,
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
        );
        return result == JOptionPane.YES_OPTION;
    }

}
