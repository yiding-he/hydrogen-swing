package com.hyd.swing;

import javax.swing.JTextField;

public class TextFormField extends FormField<String> {

    private JTextField textField;

    public TextFormField(String labelText) {
        super(labelText);
        add(this.textField = new JTextField(), "growx");
    }

    @Override
    public void setEnabled(boolean enabled) {
        textField.setEnabled(enabled);
    }

    @Override
    public String getValue() {
        return textField.getText();
    }

    @Override
    public void setValue(String value) {
        textField.setText(value);
    }
}
