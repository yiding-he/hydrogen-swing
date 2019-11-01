package com.hyd.swing;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractPanel extends JPanel {

    private final SpringLayout layout = new SpringLayout();

    protected class LayoutContext {

        private Component c1;

        private String e1;

        private int spacing;

        public SpacingContext set1(Component c1, String e1) {
            this.c1 = c1;
            this.e1 = e1;
            return new SpacingContext();
        }

        public void apply(Component c2, String e2) {
            layout.putConstraint(e1, c1, spacing, e2, c2);
        }

        protected class SpacingContext {

            public TargetContext spacing(int spacing) {
                LayoutContext.this.spacing = spacing;
                return new TargetContext();
            }
        }

        protected class TargetContext {

            public void toTopOf(Component c2) {
                apply(c2, SpringLayout.NORTH);
            }

            public void toRightOf(Component c2) {
                apply(c2, SpringLayout.EAST);
            }

            public void toBottomOf(Component c2) {
                apply(c2, SpringLayout.SOUTH);
            }

            public void toLeftOf(Component c2) {
                apply(c2, SpringLayout.WEST);
            }
        }
    }

    protected LayoutContext.SpacingContext setTopOf(Component c1) {
        return new LayoutContext().set1(c1, SpringLayout.NORTH);
    }

    protected LayoutContext.SpacingContext setRightOf(Component c1) {
        return new LayoutContext().set1(c1, SpringLayout.EAST);
    }

    protected LayoutContext.SpacingContext setBottomOf(Component c1) {
        return new LayoutContext().set1(c1, SpringLayout.SOUTH);
    }

    protected LayoutContext.SpacingContext setLeftOf(Component c1) {
        return new LayoutContext().set1(c1, SpringLayout.WEST);
    }

    public AbstractPanel() {
        this.setLayout(layout);
    }
}
