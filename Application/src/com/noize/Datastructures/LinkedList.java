package com.noize.Datastructures;

public class LinkedList implements Datastructure{
    private String bigOSearch = "Time complexity: O(n)";
    private String bigOSort = "Time complexity O(n^2)";
    Node head; // head of list

    public LinkedList() {
        this.head = null;
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list) {
        Node currNode = list.head;


        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node

            // Go to next node
            currNode = currNode.getRight();
        }
    }

    @Override
    public void sort() {
        Node current = null, index = null;
        int temp;
        //Check whether list is empty
        if (head == null) {
            return;
        } else {
            //Current will point to head
            for (current = head; current.getRight() != null; current = current.getRight()) {
                //Index will point to node next to current
                for (index = current.getRight(); index != null; index = index.getRight()) {
                    //If current's data is greater than index's data, swap the data of current and index
                    if (current.getValue() > index.getValue()) {
                        temp = current.getValue();
                        current.setValue(index.getValue());
                        index.setValue(temp);
                    }
                }
            }
        }
    }

    @Override
    public void insert(int data) {
// Create a new node with given data
        Node new_node = new Node(data);


        // If the Linked List is empty,
        // then make the new node as head
        if (this.head == null) {
            this.head = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = this.head;
            while (last.getRight() != null) {
                last = last.getRight();
            }

            // Insert the new_node at last node
            last.setRight(new_node);
        }
    }

    @Override
    public String print() {
        String retStr = "";

        Node current = head;
        while (current != null) {
            retStr += current.getValue() + " ";
            current = current.getRight();

        }

        return retStr;
    }

    @Override
    public String getBigOSearch() {
        return this.bigOSearch;
    }

    @Override
    public String getBigOSort() {
        return this.bigOSort;
    }

    @Override
    public Object search(int target) {
        Node current = this.head;
        int index = 0;
        while (current != null) {
            if (current.getValue() == target) {
                return index;
            }
            current = current.getRight();
            index++;
        }
        return -1;
    }
}