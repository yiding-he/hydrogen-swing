package com.hyd.swing.form;

import javax.swing.JPasswordField;

public class PasswordFormField extends FormField<String> {

    private JPasswordField passwordField;

    public PasswordFormField(String labelText) {
        super(labelText);
        add(this.passwordField = new JPasswordField(), "growx");
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
