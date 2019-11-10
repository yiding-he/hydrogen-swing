package com.hyd.swing.form;

import com.hyd.swing.Swing;
import com.hyd.swing.layout.SpringPanel;

import javax.swing.*;

public class FormButtonsPanel extends SpringPanel {

    private JButton lastButton;

    public FormButtonsPanel() {

    }

    public void addButton(JButton button) {
        add(button);

        getLayout().setTopOf(button).padding(0).toTopOf(this);
        getLayout().setRightOf(button).padding(0).toRightOf(this);

        if (lastButton != null) {
            getLayout().setRightOf(lastButton).padding(Swing.PADDING).toLeftOf(button);
        }

        lastButton = button;
        getLayout().setBottomOf(this).padding(0).toBottomOf(lastButton);
    }
}
