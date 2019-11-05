package com.hyd.swing.form;

import com.hyd.swing.AbstractPanel;
import javax.swing.JButton;

public class FormButtonsPanel extends AbstractPanel {

    public FormButtonsPanel() {
        getLayoutConstraints().gridGapY("10").alignX("right").insets("10 2");
    }

    public void addButton(JButton button) {
        this.add(button);
    }
}
