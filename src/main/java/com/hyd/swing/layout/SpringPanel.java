package com.hyd.swing.layout;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class SpringPanel extends JPanel {

    public SpringPanel() {
        super(new SpringLayout2());
    }

    public SpringLayout2 getLayout() {
        return (SpringLayout2) super.getLayout();
    }

    public <T extends Component> T addComponent(T t) {
        add(t);
        return t;
    }

    public void applyLayout(Consumer<SpringLayout2> layoutConsumer) {
        layoutConsumer.accept(getLayout());
    }
}
