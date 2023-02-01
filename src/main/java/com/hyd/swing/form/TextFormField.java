package com.hyd.swing.form;

import com.hyd.swing.Swing;
import com.hyd.swing.layout.SpringLayout2.Edge;

import javax.swing.*;

public class TextFormField extends FormField<String> {

    private JTextField textField;

    public TextFormField(String labelText) {
        super(labelText);
        applyLayout(layout -> {
            add(this.textField = new JTextField());
            layout.setTopOf(textField).withOffset(Swing.SMALL_PADDING).toBottomOf(label);
            layout.align(Edge.LEFT, this, textField);
            layout.align(Edge.RIGHT, textField, this);
            layout.align(Edge.BOTTOM, textField, this);
        });
    }

    public JTextField getTextField() {
        return textField;
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
