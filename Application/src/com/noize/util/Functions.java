package com.noize.util;

import com.noize.Datastructures.BinaryTree;
import com.noize.Datastructures.Datastructure;
import com.noize.Datastructures.LinkedList;
import com.noize.Datastructures.Stack;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.regex.Pattern;

public class Functions {
    private ArrayList<Integer> arrayList;
    private BufferedReader reader;
    private File selectedFile;
    private JFileChooser fileChooser;

    //Structures
    private BinaryTree bt;
    private LinkedList linkedList;
    private Stack stack;

    private Datastructure structure;


    public Datastructure getStructure() {
        return this.structure;
    }


    public Stack getStack(){
        return this.stack;
    }

    public LinkedList getLinkedList() {
        return this.linkedList;
    }

    public BinaryTree getBt() {
        return this.bt;
    }



    public Functions() {
        this.arrayList = new ArrayList<>();
        this.fileChooser = new JFileChooser();
    }



    public String createStructure(int pick) {
        if(structure != null){
            System.out.println("Replacing old structure:" + structure.getClass().getSimpleName() + " With:");
        }
        switch (pick){
            case 0:
                this.structure = new BinaryTree();
                break;
            case 1:
                this.structure = new LinkedList();
                break;
            case 2:
                this.structure = new Stack(arrayList.size());
                break;
        }
        if (!(this.arrayList == null)) {
            for (int e : arrayList){
                assert structure != null;
                structure.insert(e);
            }
            System.out.println(structure.print());
        } else {
            System.out.println("Add file please");
        }

        return structure.getClass().getSimpleName();
    }

    public Dictionary searchStructure(String value){
        //Check Input for interger or not
        Dictionary<String, String> d = new Hashtable<>();
        if( Pattern.matches("^\\d*$", value) && !value.isEmpty()){
            if (structure != null) {
                long starttime = System.currentTimeMillis();
                Object output = structure.search(Integer.parseInt(value));
                long timepassed = System.currentTimeMillis() - starttime;
                if (output == null) {
                    d.put("Error", "Value was not found.");
                    d.put("Time", String.valueOf(timepassed));
                } else {
                    d.put("Structure", structure.getClass().getSimpleName());
                    d.put("searched", output.toString());
                    d.put("Time", String.valueOf(timepassed + "mili sec"));
                    d.put("BigO", structure.getBigOSearch());
                }
            } else {
                d.put("Error", "No datastructure. Please pick a structure.");
            }} else {
                d.put("Error", "Input is not an interger.");
            }
        return d;
    }

    public Dictionary sortStructure() throws Exception {
        Dictionary<String, String> d = new Hashtable<>();
        if (structure != null){
            d.put("Before", structure.print());
            long starttime=System.currentTimeMillis();
            structure.sort();
            long timepassed=System.currentTimeMillis()-starttime;
            d.put("Structure", structure.getClass().getSimpleName());
            d.put("Sorted", structure.print());
            d.put("Time", timepassed + "mili sec");
            d.put("BigO", structure.getBigOSort());
        } else {
            d.put("Error", "Structure does not exist. Please convert data to structure.");
        }
        return d;
    }

    public void selectFile() throws IOException {
        int i = fileChooser.showOpenDialog(fileChooser);
        this.arrayList = new ArrayList<>();

        if (i == fileChooser.APPROVE_OPTION) {
            this.selectedFile = fileChooser.getSelectedFile();
            this.reader = new BufferedReader(new FileReader(new File(selectedFile.toURI())));
            String line;
            while ((line = this.reader.readLine()) != null)
                arrayList.add(Integer.valueOf(line));
        }
    }
}
