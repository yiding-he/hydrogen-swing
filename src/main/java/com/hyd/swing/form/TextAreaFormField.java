package com.hyd.swing.form;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.miginfocom.layout.CC;

public class TextAreaFormField extends FormField<String> {

    private JTextArea textArea;

    public TextAreaFormField(String labelText) {
        super(labelText);
        this.addComponent(
            new JScrollPane(this.textArea = new JTextArea()),
            new CC().grow().minHeight("100")
        );
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
