package com.hyd.swing.form;

import com.hyd.swing.layout.SpringLayout2.Edge;
import com.hyd.swing.layout.SpringPanel;

import javax.swing.*;

public abstract class FormField<V> extends SpringPanel {

    protected JLabel label;

    public FormField(String labelText) {
        add(this.label = new JLabel(labelText));
        getLayout().align(Edge.LEFT, this, label);
        getLayout().align(Edge.TOP, this, label);
    }

    protected boolean isGrow() {
        return false;
    }

    @Override
    public abstract void setEnabled(boolean enabled);

    public abstract V getValue();

    public abstract void setValue(V value);
}
