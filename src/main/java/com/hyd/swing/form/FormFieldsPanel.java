package com.hyd.swing.form;

import com.hyd.swing.Swing;
import com.hyd.swing.layout.SpringLayout2.Edge;
import com.hyd.swing.layout.SpringPanel;

public class FormFieldsPanel extends SpringPanel {

    private FormField<?> lastField;

    public FormFieldsPanel() {

    }

    public void addFormField(FormField<?> formField) {

        add(formField);
        getLayout().align(Edge.LEFT, this, formField);
        getLayout().align(Edge.RIGHT, this, formField);

        if (lastField == null) {
            getLayout().align(Edge.TOP, this, formField);
        } else {
            getLayout().setTopOf(formField).padding(Swing.PADDING).toBottomOf(lastField);
        }

        lastField = formField;
        getLayout().setBottomOf(this).padding(0).toBottomOf(lastField);
    }

}
