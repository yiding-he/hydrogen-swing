package com.hyd.swing.layout;

import com.hyd.swing.layout.SpringLayout2.ConstraintContext.PaddingContext;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SpringLayout2 extends SpringLayout {

    public static final String TOP = NORTH;

    public static final String RIGHT = EAST;

    public static final String BOTTOM = SOUTH;

    public static final String LEFT = WEST;

    public enum Edge {
        TOP(SpringLayout2.TOP), RIGHT(SpringLayout2.RIGHT), BOTTOM(SpringLayout2.BOTTOM), LEFT(SpringLayout2.LEFT),
        ;

        private String value;

        Edge(String value) {
            this.value = value;
        }
    }

    public class ConstraintContext {

        private List<Component> c1List;

        private Component c2;

        private Edge e1, e2;

        private int padding;

        public PaddingContext paddingContext(Component[] c1List, Edge e1) {
            return new PaddingContext(Arrays.asList(c1List), e1);
        }

        private void apply() {
            for (Component c1 : c1List) {
                SpringLayout2.this.putConstraint(e1.value, c1, padding, e2.value, c2);
            }
        }

        public class PaddingContext {

            public PaddingContext(List<Component> c1List, Edge e1) {
                ConstraintContext.this.c1List = c1List;
                ConstraintContext.this.e1 = e1;
            }

            public ToContext withOffset(int padding) {
                return new ToContext(padding);
            }
        }

        public class ToContext {

            public ToContext(int padding) {
                ConstraintContext.this.padding = padding;
            }

            public void toTopOf(Component c2) {
                ConstraintContext.this.c2 = c2;
                ConstraintContext.this.e2 = Edge.TOP;
                apply();
            }

            public void toRightOf(Component c2) {
                ConstraintContext.this.c2 = c2;
                ConstraintContext.this.e2 = Edge.RIGHT;
                apply();
            }

            public void toBottomOf(Component c2) {
                ConstraintContext.this.c2 = c2;
                ConstraintContext.this.e2 = Edge.BOTTOM;
                apply();
            }

            public void toLeftOf(Component c2) {
                ConstraintContext.this.c2 = c2;
                ConstraintContext.this.e2 = Edge.LEFT;
                apply();
            }
        }
    }

    public PaddingContext setTopOf(Component... c1) {
        return new ConstraintContext().paddingContext(c1, Edge.TOP);
    }

    public PaddingContext setRightOf(Component... c1) {
        return new ConstraintContext().paddingContext(c1, Edge.RIGHT);
    }

    public PaddingContext setBottomOf(Component... c1) {
        return new ConstraintContext().paddingContext(c1, Edge.BOTTOM);
    }

    public PaddingContext setLeftOf(Component... c1) {
        return new ConstraintContext().paddingContext(c1, Edge.LEFT);
    }

    public void layoutVertically(Component container, int padding, Component... components) {
        Component last = null;
        for (Component component : components) {
            if (last == null) {
                setTopOf(component).withOffset(padding).toTopOf(container);
            } else {
                setTopOf(component).withOffset(padding).toBottomOf(last);
            }
            last = component;
        }
    }

    public void align(Edge edge, Component... components) {
        Component first = components[0];
        for (int i = 1; i < components.length; i++) {
            Component component = components[i];
            putConstraint(edge.value, component, 0, edge.value, first);
        }
    }

    public void padding(Component container, int padding, Component component, Edge... edges) {
        for (Edge edge : edges) {
            int _padding = edge == Edge.BOTTOM || edge == Edge.RIGHT ? -padding : padding;
            putConstraint(edge.value, component, _padding, edge.value, container);
        }
    }
}
