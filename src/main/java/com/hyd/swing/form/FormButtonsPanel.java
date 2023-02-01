package com.hyd.swing.form;

import com.hyd.swing.Swing;
import com.hyd.swing.layout.SpringLayout2.Edge;
import com.hyd.swing.layout.SpringPanel;

import javax.swing.*;

public class FormButtonsPanel extends SpringPanel {

    private JButton lastButton;

    public FormButtonsPanel() {

    }

    public void addButton(JButton button) {
        add(button);

        if (lastButton != null) {
            getLayout().setRightOf(button).withOffset(-Swing.PADDING).toLeftOf(lastButton);
        } else {
            getLayout().align(Edge.RIGHT, this, button);
        }

        lastButton = button;
        getLayout().setBottomOf(this).withOffset(0).toBottomOf(lastButton);
    }
}
