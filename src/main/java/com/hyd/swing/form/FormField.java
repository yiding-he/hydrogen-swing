package com.hyd.swing.form;

import com.hyd.swing.AbstractPanel;
import javax.swing.JLabel;
import net.miginfocom.layout.CC;

public abstract class FormField<V> extends AbstractPanel {

    protected JLabel label;

    public FormField(String labelText) {
        getLayoutConstraints().flowY().fillX().noGrid().gridGapY("5").insets("2");
        addComponent(this.label = new JLabel(labelText), new CC());
    }

    protected boolean isGrow() {
        return false;
    }

    @Override
    public abstract void setEnabled(boolean enabled);

    public abstract V getValue();

    public abstract void setValue(V value);
}
