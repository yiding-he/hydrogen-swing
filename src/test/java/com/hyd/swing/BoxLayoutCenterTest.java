package com.hyd.swing;

import static com.hyd.swing.layout.LayoutBuilder._hbox;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutCenterTest extends JFrame {

    public static void main(String[] args) {
        Swing.init(new FlatDarculaLaf());
        Swing.openMainWindow(new BoxLayoutCenterTest(), 500, 400);
    }

    public BoxLayoutCenterTest() throws HeadlessException {

        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(200, 100));
        centerPanel.setMinimumSize(new Dimension(200, 100));
        centerPanel.setMaximumSize(new Dimension(200, 100));
        Swing.highlight("#FF7777", centerPanel);

        _hbox(getContentPane()).children(
            Box.createHorizontalGlue(), centerPanel, Box.createHorizontalGlue()
        );

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                setIgnoreRepaint(true);
            }
        });
    }
}
