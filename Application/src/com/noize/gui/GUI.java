package com.noize.gui;

import javax.swing.*;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;

public class GUI {
    private static final String LOOKANDFEEL = "Metal";
    private static final String THEME = "DefaultMetal";
    public  SidePanel sidePanel;
    public Cards cardsPanel;

    public GUI() {
        JFrame frame = new JFrame();
        sidePanel = new SidePanel();
        cardsPanel = new Cards();

        sidePanel.setupListeners(cardsPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(sidePanel.getSidePanel(), BorderLayout.WEST);
        frame.add(cardsPanel.getMainPanel(), BorderLayout.EAST);
        frame.setTitle("First test");
        frame.pack();
        frame.setSize(800, 400);
        frame.setVisible(true);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        if (LOOKANDFEEL.equals("Metal")) {
            if (THEME.equals("DefaultMetal"))
                MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
            else if (THEME.equals("Ocean"))
                MetalLookAndFeel.setCurrentTheme(new OceanTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        new GUI();
    }
}
