package com.hyd.swing.form;

import javax.swing.*;

public class TextAreaFormField extends FormField<String> {

    private JTextArea textArea;

    public TextAreaFormField(String labelText) {
        super(labelText);
    }

    @Override
    protected boolean isGrow() {
        return true;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.textArea.setEnabled(enabled);
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public void setValue(String value) {

    }
}
