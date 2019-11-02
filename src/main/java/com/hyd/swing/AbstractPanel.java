package com.hyd.swing;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public abstract class AbstractPanel extends JPanel {

    public AbstractPanel() {
        this.setLayout(new MigLayout());
    }

    @Override
    public MigLayout getLayout() {
        return (MigLayout) super.getLayout();
    }
}
