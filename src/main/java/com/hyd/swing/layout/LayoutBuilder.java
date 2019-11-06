package com.hyd.swing.layout;

import java.awt.*;
import javax.swing.*;

public abstract class LayoutBuilder {

    @SuppressWarnings("unchecked")
    public static abstract class LayoutBase<T extends LayoutBase> {

        protected Container container;

        protected abstract void addComponent(Component c);

        public T setContainer(Container container) {
            this.container = container;
            this.container.setLayout(getLayout(this.container));
            return (T) this;
        }

        protected abstract LayoutManager getLayout(Container container);

        public T children(Object... components) {
            for (Object component : components) {
                if (component == null) {
                    throw new IllegalArgumentException("Argument should be null");
                }

                if (component instanceof Component) {
                    addComponent((Component) component);
                } else if (component instanceof LayoutBase) {
                    addComponent(((LayoutBase) component).container);
                } else {
                    throw new IllegalArgumentException("Invalid type: " + component.getClass().getCanonicalName());
                }
            }

            return (T) this;
        }
    }

    //////////////////////////////////////////////////////////////

    public static <T extends JComponent> T _fill(T t) {
        t.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        return t;
    }

    public static <T extends JComponent> T _alignLeft(T t) {
        t.setAlignmentX(Component.LEFT_ALIGNMENT);
        return t;
    }

    //////////////////////////////////////////////////////////////

    public static class SpaceHolder extends Component {
        private boolean fill;
        private int size;
    }

    public static Component _space(int size) {
        SpaceHolder spaceHolder = new SpaceHolder();
        spaceHolder.size = size;
        spaceHolder.fill = false;
        return spaceHolder;
    }

    public static Component _fillSpace() {
        SpaceHolder spaceHolder = new SpaceHolder();
        spaceHolder.size = 0;
        spaceHolder.fill = true;
        return spaceHolder;
    }

    //////////////////////////////////////////////////////////////

    public static VBoxLayout _vbox(Container container) {
        return new VBoxLayout().setContainer(container);
    }

    public static class VBoxLayout extends LayoutBase<VBoxLayout> {

        @Override
        protected LayoutManager getLayout(Container container) {
            return new BoxLayout(container, BoxLayout.Y_AXIS);
        }

        @Override
        protected void addComponent(Component c) {
            if (c instanceof SpaceHolder) {
                if (((SpaceHolder) c).fill) {
                    container.add(Box.createVerticalGlue());
                } else {
                    container.add(Box.createRigidArea(new Dimension(0, ((SpaceHolder) c).size)));
                }
            } else {
                container.add(c);
            }
        }
    }

    //////////////////////////////////////////////////////////////

    public static HBoxLayout _hbox(Container container) {
        return new HBoxLayout().setContainer(container);
    }

    public static class HBoxLayout extends LayoutBase<HBoxLayout> {

        @Override
        protected LayoutManager getLayout(Container container) {
            return new BoxLayout(container, BoxLayout.X_AXIS);
        }

        @Override
        protected void addComponent(Component c) {
            if (c instanceof SpaceHolder) {
                if (((SpaceHolder) c).fill) {
                    container.add(Box.createHorizontalGlue());
                } else {
                    container.add(Box.createRigidArea(new Dimension(((SpaceHolder) c).size, 0)));
                }
            } else {
                container.add(c);
            }
        }
    }
}
