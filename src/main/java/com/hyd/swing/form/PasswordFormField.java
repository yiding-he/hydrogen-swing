package com.hyd.swing.form;

import com.hyd.swing.Swing;
import com.hyd.swing.layout.SpringLayout2.Edge;

import javax.swing.*;

public class PasswordFormField extends FormField<String> {

    private JPasswordField passwordField;

    public PasswordFormField(String labelText) {
        super(labelText);

        applyLayout(layout -> {
            add(this.passwordField = new JPasswordField());
            layout.setTopOf(passwordField).withOffset(Swing.SMALL_PADDING).toBottomOf(label);
            layout.align(Edge.LEFT, this, passwordField);
            layout.align(Edge.RIGHT, passwordField, this);
            layout.align(Edge.BOTTOM, passwordField, this);
        });
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    @Override
    public void setEnabled(boolean enabled) {
        passwordField.setEnabled(enabled);
    }

    @Override
    public String getValue() {
        return new String(passwordField.getPassword());
    }

    @Override
    public void setValue(String value) {
        passwordField.setText(value);
    }
}
