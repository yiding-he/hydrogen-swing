package com.hyd.swing.layout;

import javax.swing.JPanel;

public class SpringPanel extends JPanel {

    public SpringPanel() {
        super(new SpringLayout2());
    }

    public SpringLayout2 getLayout() {
        return (SpringLayout2) super.getLayout();
    }
}
