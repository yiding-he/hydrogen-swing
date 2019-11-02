package com.hyd.swing;

import javax.swing.JButton;

public abstract class FormPanel extends AbstractPanel {

    private ButtonsPanel buttonsPanel = new ButtonsPanel();

    public FormPanel() {
        getLayout().setLayoutConstraints("flowy, nogrid, fillx, gapy 10, ins 10");
    }

    public void addFormField(FormField<?> formField) {
        add(formField, "growx");
    }

    public void addButton(JButton button) {

    }
}
