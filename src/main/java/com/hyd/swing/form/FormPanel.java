package com.hyd.swing.form;

import com.hyd.swing.Swing;
import com.hyd.swing.layout.SpringLayout2.Edge;
import com.hyd.swing.layout.SpringPanel;

import javax.swing.*;

public abstract class FormPanel extends SpringPanel {

    private FormButtonsPanel formButtonsPanel = new FormButtonsPanel();

    private FormFieldsPanel formFieldsPanel = new FormFieldsPanel();

    public FormPanel() {
        add(formFieldsPanel);
        // add(formButtonsPanel);

        getLayout().align(Edge.TOP, this, formFieldsPanel);
        getLayout().align(Edge.LEFT, this, formFieldsPanel);
        getLayout().align(Edge.RIGHT, this, formFieldsPanel);

        Swing.highlight("#882222", formFieldsPanel);
        Swing.highlight("#AA8888", this);
    }

    public void addFormField(FormField<?> formField) {
        this.formFieldsPanel.addFormField(formField);
    }

    public void addButton(JButton button) {
        // formButtonsPanel.addButton(button);
    }
}
