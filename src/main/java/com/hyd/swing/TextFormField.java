package com.hyd.swing;

import javax.swing.*;

public class TextFormField extends FormField<String> {

    private JTextField textField;

    public TextFormField(String labelText) {
        super(labelText);
    }

    @Override
    protected void init() {
        add(this.textField = new JTextField());
        setTopOf(textField).spacing(Swing.SMALL_PADDING).toBottomOf(label);
        setLeftOf(textField).spacing(0).toLeftOf(this);
        setRightOf(textField).spacing(0).toRightOf(this);
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
