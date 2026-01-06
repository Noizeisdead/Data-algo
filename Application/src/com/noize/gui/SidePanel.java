package com.noize.gui;

import javax.swing.*;
import java.awt.*;


public class SidePanel extends JPanel{
    private JPanel sidePanel;
    private JButton buttonDataset, convertBt, searchBt, sortBt;

    public SidePanel() {
        sidePanel = new JPanel();
        buttonDataset = new JButton("Input Dataset");
        convertBt = new JButton("Convert dataset");
        searchBt = new JButton("Search");
        sortBt = new JButton("Sort");


        //Side panel setting
        sidePanel.setLayout(new GridLayout(4, 1));
        sidePanel.add(buttonDataset);
        sidePanel.add(convertBt);
        sidePanel.add(searchBt);
        sidePanel.add(sortBt);
        sidePanel.setSize(50, 500);

    }

    public void setupListeners(Cards cards){
        buttonDataset.addActionListener(e -> cards.showCard("cardInputData"));
        convertBt.addActionListener(e -> cards.showCard("cardConvertBT"));
        searchBt.addActionListener(e -> cards.showCard("cardSearch"));
        sortBt.addActionListener(e -> cards.showCard("cardSort"));
    }
    //Getters and setters
    public JPanel getSidePanel() {
        return sidePanel;
    }

    public void setSidePanel(JPanel sidePanel) {
        this.sidePanel = sidePanel;
    }

    public JButton getButtonDataset() {
        return buttonDataset;
    }

    public void setButtonDataset(JButton buttonDataset) {
        this.buttonDataset = buttonDataset;
    }
}
