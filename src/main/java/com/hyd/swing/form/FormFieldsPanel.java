package com.hyd.swing.form;

import com.hyd.swing.AbstractPanel;
import com.hyd.swing.Swing;
import net.miginfocom.layout.CC;

public class FormFieldsPanel extends AbstractPanel {

    public FormFieldsPanel() {
        getLayoutConstraints().flowY().noGrid().fillX().gridGapY("10").insets("0");
    }

    public void addFormField(FormField<?> formField) {
        CC constraints = new CC().growX();
        if (formField.isGrow()) {
            System.out.println(formField.getClass() + " grows.");
            constraints.growY();
        }
        addComponent(formField, constraints);
        Swing.highlight("#CC8888", formField);
    }

}
