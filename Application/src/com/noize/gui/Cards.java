package com.noize.gui;

import com.noize.util.Functions;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Dictionary;

public class Cards extends JPanel {

    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);
    JPanel cardInputData = new JPanel();
    JPanel cardConvert = new JPanel();
    JPanel cardSearch = new JPanel(new GridLayout(0, 1));
    JPanel cardSort = new JPanel(new GridLayout(0, 1));
    Functions functions = new Functions();

    //Dataset Input card components
    JLabel titleInput = new JLabel("Input the dataset here");
    JLabel explanationInput = new JLabel("Thank you");
    JButton selectFileBt = new JButton("Select file");

    //Convert card components
    JLabel titleConvert = new JLabel("Convert Dataset here");
    JLabel explanation = new JLabel("Pick which data structure to convert to.");
    JButton ConvertBT = new JButton("Convert");
    String[] convertOptions = { "Binary tree", "Linked list", "Stack"};
    JComboBox convertList = new JComboBox(convertOptions);

    //Search card components
    JLabel titleSearch = new JLabel("Search algorithms");
    JLabel explanationSearch = new JLabel("Search explantation");
    JLabel speedSearch = new JLabel("This is the speed of the used search");
    JTextField inputSearch = new JTextField("Search value...");
    JButton searchBt = new JButton("Search");

    //Sort card components
    JLabel titleSort = new JLabel("Sort algorithms");
    JLabel explanationSort = new JLabel("This is how the sort works");
    JLabel speedSort = new JLabel("This is the speed of the sort");
    JButton sortBt = new JButton("Sort");

    Cards() {
        createDataInputCard();
        createConvertCard();
        createSearchCard();
        createSortCard();
        mainPanel.add(cardInputData, "cardInputData");
        mainPanel.add(cardConvert, "cardConvertBT");
        mainPanel.add(cardSearch, "cardSearch");
        mainPanel.add(cardSort, "cardSort");
        setupListeners();
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public void showCard(String cardName) {
        cardLayout.show(this.mainPanel, cardName);
    }

    private void createDataInputCard() {
        cardInputData.setLayout(new GridLayout(0, 1));
        cardInputData.add(titleInput);
        cardInputData.add(explanationInput);
        cardInputData.add(selectFileBt);
    }

    private void createConvertCard() {
        cardConvert.setLayout(new GridLayout(0, 1));
        cardConvert.add(titleConvert);
        cardConvert.add(explanation);
        convertList.setSelectedIndex(2);
        cardConvert.add(convertList);
        cardConvert.add(ConvertBT);
    }

    private void createSearchCard() {
        cardSearch.add(titleSearch);
        cardSearch.add(explanationSearch);
        cardSearch.add(speedSearch);
        cardSearch.add(inputSearch);
        cardSearch.add(searchBt);
    }

    private void createSortCard() {
        cardSort.add(titleSort);
        cardSort.add(explanationSort);
        cardSort.add(speedSort);
        cardSort.add(sortBt);

    }

    private void setupListeners() {
        searchBt.addActionListener(e -> {
            Dictionary d = functions.searchStructure(inputSearch.getText());
            if (d.get("Error") != null){
                explanationSearch.setText((String) d.get("Error"));
            } else {
                explanationSearch.setText("<html>Searched: " + d.get("Structure") +".<br>" +
                        "Index of value: " + d.get("searched") + ".<br>");
                speedSearch.setText("<html>Time needed: " + d.get("Time") + ".<br>" +
                        "Big O: " + d.get("BigO") + ".<br><");
            }
        });
        sortBt.addActionListener(e -> {
            try {
                Dictionary d = functions.sortStructure();
                if (d.get("Error") != null){
                    explanationSort.setText((String) d.get("Error"));
                    cardSort.updateUI();
                } else {
                    explanationSort.setText("<html>Sorted: " + d.get("Structure") +".<br>" +
                                    "Before: " + d.get("Before") + ".<br>" +
                                    "Sorted: " + d.get("Sorted") + ".<br>");
                    speedSort.setText("<html>Time needed: " + d.get("Time") + ".<br>" +
                                    "Big O: " + d.get("BigO") + ".<br><");
                    cardSort.updateUI();
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        selectFileBt.addActionListener(e -> {
            try {
                functions.selectFile();
                explanationInput.setText("File input successfully");

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        ConvertBT.addActionListener( e -> {

            String output = functions.createStructure(convertList.getSelectedIndex());
            explanation.setText("Converted to: " + output);
        });

    }
}