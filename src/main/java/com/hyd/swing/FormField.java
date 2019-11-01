package com.hyd.swing;

import javax.swing.*;

public abstract class FormField<V> extends AbstractPanel {

    protected JLabel label;

    public FormField(String labelText) {
        add(this.label = new JLabel(labelText));

        setLeftOf(label).spacing(0).toLeftOf(this);
        setTopOf(label).spacing(0).toTopOf(this);

        init();
    }

    protected abstract void init();

    @Override
    public abstract void setEnabled(boolean enabled);

    public abstract V getValue();

    public abstract void setValue(V value);
}
