package com.hyd.swing;

import java.awt.*;
import java.awt.Window.Type;
import java.io.File;
import java.util.function.Consumer;
import java.util.stream.Stream;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class Swing {

    public static final int PADDING = 10;

    public static final int SMALL_PADDING = 5;

    public static final String TOP = SpringLayout.NORTH;

    public static final String LEFT = SpringLayout.WEST;

    public static final String BOTTOM = SpringLayout.SOUTH;

    public static final String RIGHT = SpringLayout.EAST;

    private static Rectangle desktopBounds;

    private static void forEachDirection(Consumer<String> consumer) {
        Stream.of(TOP, RIGHT, BOTTOM, LEFT).forEach(consumer);

    }

    public static void init(LookAndFeel lookAndFeel) {

        if (lookAndFeel != null) {
            try {
                UIManager.setLookAndFeel(lookAndFeel);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }

    }

    private static void initDesktopBounds() {
        if (desktopBounds == null) {
            desktopBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        }
    }

    public static void openMainWindow(JFrame frame, int width, int height) {
        openWindow(frame, width, height, true);
    }

    public static void openDialogWindow(JFrame frame, int width, int height) {
        openWindow(frame, width, height, false);
    }

    public static void openWindow(JFrame frame, int width, int height, boolean exitOnClose) {
        initDesktopBounds();

        int x = desktopBounds.x + (desktopBounds.width - width) / 2;
        int y = desktopBounds.y + (desktopBounds.height - height) / 2;
        frame.setSize(width, height);
        frame.setLocation(x, y);

        if (exitOnClose) {
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } else {
            frame.setType(Type.UTILITY);
        }

        frame.setVisible(true);
    }

    public static void alertInfo(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void alertInternalInfo(Component parent, String title, String message) {
        JOptionPane.showInternalMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void alertWarning(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void alertError(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static boolean confirmInfo(String title, String message) {
        int result = JOptionPane.showConfirmDialog(
            null, message, title,
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE
        );
        return result == JOptionPane.YES_OPTION;
    }

    public static boolean confirmWarning(String title, String message) {
        int result = JOptionPane.showConfirmDialog(
            null, message, title,
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
        );
        return result == JOptionPane.YES_OPTION;
    }

    public static String chooseDirectory(File startDir) {
        String result = null;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(startDir);
        chooser.setDialogTitle("选择目录");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            result = chooser.getSelectedFile().getAbsolutePath();
        }
        return result;
    }

    public static String chooseFile(File startDir) {
        String result = null;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(startDir);
        chooser.setDialogTitle("选择文件");
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            result = chooser.getSelectedFile().getAbsolutePath();
        }
        return result;
    }

    public static void highlight(String color, Component... components) {
        for (Component component : components) {
            component.setBackground(Color.decode("0x" + color.substring(1)));
        }
    }

    public static JPanel flowPanel(Component... components) {
        JPanel jPanel = new JPanel(new FlowLayout());
        for (Component component : components) {
            jPanel.add(component);
        }
        return jPanel;
    }

    public static void disableComponents(Component... components) {
        for (Component component : components) {
            component.setEnabled(false);
        }
    }

    public static void enableComponents(Component... components) {
        for (Component component : components) {
            component.setEnabled(true);
        }
    }

    public static void addTab(JTabbedPane tabbedPane, String tabTitle, int padding, Component content) {
        JPanel tabContainer = new JPanel();
        tabContainer.setLayout(new BorderLayout());
        tabContainer.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        tabContainer.add(content, BorderLayout.CENTER);

        tabbedPane.addTab(tabTitle, tabContainer);
    }

    public static JPanel vBox(int gap, Component... components) {
        SpringLayout layout = new SpringLayout();

        JPanel panel = new JPanel();
        panel.setLayout(layout);

        for (int i = 0; i < components.length; i++) {
            Component component = components[i];
            panel.add(component);

            layout.putConstraint(SpringLayout.EAST, component, 0, SpringLayout.EAST, panel);
            layout.putConstraint(SpringLayout.WEST, component, 0, SpringLayout.WEST, panel);

            if (i == 0) {
                layout.putConstraint(SpringLayout.NORTH, component, 0, SpringLayout.NORTH, panel);
            } else {
                layout.putConstraint(SpringLayout.NORTH, component, gap, SpringLayout.SOUTH, components[i - 1]);
            }
        }

        return panel;
    }

    public static void fillWith(Container container, Component content) {
        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);
        container.add(content);

        forEachDirection(d -> layout.putConstraint(d, content, 0, d, container));
    }

    public static void fillWith(Container container, Component content, String... directions) {
        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);
        container.add(content);

        Stream.of(directions).forEach(d -> layout.putConstraint(d, content, 0, d, container));
    }

    public static void addChangeListener(JTextField textField, Consumer<String> listener) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed(e);
            }

            private void changed(DocumentEvent e) {
                if (listener != null) {
                    try {
                        Document document = e.getDocument();
                        String fullText = document.getText(0, document.getLength());
                        listener.accept(fullText);
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}
