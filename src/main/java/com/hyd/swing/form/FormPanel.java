package com.hyd.swing.form;

import com.hyd.swing.Swing;
import com.hyd.swing.layout.SpringLayout2.Edge;
import com.hyd.swing.layout.SpringPanel;

import javax.swing.*;

public abstract class FormPanel extends SpringPanel {

    private FormFieldsPanel formFieldsPanel = new FormFieldsPanel();

    private FormButtonsPanel formButtonsPanel = new FormButtonsPanel();

    public FormPanel() {
        add(formFieldsPanel);
        add(formButtonsPanel);

        getLayout().align(Edge.TOP, this, formFieldsPanel);
        getLayout().align(Edge.LEFT, this, formFieldsPanel);
        getLayout().align(Edge.RIGHT, this, formFieldsPanel);

        getLayout().setTopOf(formButtonsPanel).withOffset(Swing.PADDING * 2).toBottomOf(formFieldsPanel);
        getLayout().align(Edge.LEFT, this, formButtonsPanel);
        getLayout().align(Edge.RIGHT, this, formButtonsPanel);
        getLayout().align(Edge.BOTTOM, this, formButtonsPanel);
    }

    public void addFormField(FormField<?> formField) {
        this.formFieldsPanel.addFormField(formField);
    }

    public void addButton(JButton button) {
        formButtonsPanel.addButton(button);
    }
}
