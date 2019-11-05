package com.hyd.swing.form;

import com.hyd.swing.AbstractPanel;
import com.hyd.swing.Swing;
import javax.swing.JButton;
import net.miginfocom.layout.CC;

public abstract class FormPanel extends AbstractPanel {

    private FormButtonsPanel formButtonsPanel = new FormButtonsPanel();

    private FormFieldsPanel formFieldsPanel = new FormFieldsPanel();

    private boolean haveButton;

    public FormPanel() {
        getLayoutConstraints().noGrid().flowY().insets("0").fill();
        addComponent(formFieldsPanel, new CC().grow());
        Swing.highlight("#5555AA", formFieldsPanel);
    }

    public void addFormField(FormField<?> formField) {
        this.formFieldsPanel.addFormField(formField);
    }

    public void addButton(JButton button) {

        if (!haveButton) {
            addComponent(formButtonsPanel, new CC().growX().wrap());
            haveButton = true;
        }

        formButtonsPanel.addButton(button);
    }
}
