package com.hyd.swing;

import javax.swing.JLabel;

public abstract class FormField<V> extends AbstractPanel {

    protected JLabel label;

    public FormField(String labelText) {
        getLayout().setLayoutConstraints("flowy, nogrid, gapy 5, ins 2");
        getLayout().setColumnConstraints("[grow]");
        add(this.label = new JLabel(labelText));
    }

    @Override
    public abstract void setEnabled(boolean enabled);

    public abstract V getValue();

    public abstract void setValue(V value);
}
