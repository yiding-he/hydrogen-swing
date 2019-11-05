package com.hyd.swing;

import java.awt.Component;
import javax.swing.JPanel;
import net.miginfocom.layout.*;
import net.miginfocom.swing.MigLayout;

public abstract class AbstractPanel extends JPanel {

    public AbstractPanel() {
        this.setLayout(new MigLayout(new LC(), new AC(), new AC()));
    }

    protected LC getLayoutConstraints() {
        return (LC) ((MigLayout) getLayout()).getLayoutConstraints();
    }

    protected AC getColumnConstraints() {
        return (AC) ((MigLayout) getLayout()).getColumnConstraints();
    }

    protected AC getRowConstraints() {
        return (AC) ((MigLayout) getLayout()).getRowConstraints();
    }

    public void addComponent(Component component, CC constraints) {
        add(component, constraints);
    }
}
