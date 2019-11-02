package com.hyd.swing;

import javax.swing.JButton;

public class ButtonsPanel extends AbstractPanel {

    public ButtonsPanel() {
        getLayout().setLayoutConstraints("gapx 10, right");
    }

    public void addButton(JButton button) {
        this.add(button);
    }
}
