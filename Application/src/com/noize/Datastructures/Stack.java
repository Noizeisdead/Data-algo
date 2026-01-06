package com.noize.Datastructures;

import java.util.Arrays;

public class Stack implements Datastructure{
    private Node root;
    private Integer[] array; // Container for Stack elements
    private int top; // Index of top element
    private final String bigOSearch = "Can not search stack";
    private String bigOSort = "Worst-case time complexity: O(N^2)";

    // Constructor for creating stack of given capacity
    public Stack(int capacity) {
        array = new Integer[capacity];
        top = -1;
    }

    // Method for adding a new element to top of stack
    public void push(int obj) throws Exception {
        if (size() == array.length) {
            throw new Exception("Stack is full!");
        }
        top++; // Advance to next cell
        array[top] = obj; // Add new element
    }

    // Method for removing element from top of stack
    public int pop() throws Exception { //O(1)
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        int toReturn = array[top]; // Element to return
        array[top] = null; // Replace it with null
        top--; // Update top to point to new top
        return toReturn;
    }

    // Method for getting top element without removing it
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return array[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

@Override
    public void sort() throws Exception {
        Stack tmpStack = new Stack(this.size()); //create temp stack  0(1)
        while (!this.isEmpty()) //while the stack isn't empty N * (O(1) + (N * O(1)) + O(1)) +O(1)
        {
            // pop out the first element
            int tmp = this.pop(); //O(1)

            // while a temporary stack is not empty and
            // top of stack is greater than temp.
            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) //N * O(1)
            {
                // pop from a temporary stack and
                // push it to the input stack.
                this.push(tmpStack.pop());
            }

            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        this.array = tmpStack.array;
        this.top = tmpStack.top;
    }

    @Override
    public Object search(int value) {
           return "No search for the stack";
    }

    @Override
    public void insert(int value) {
        if (size() == array.length) {
            System.out.println("Stack is full!");
        }
        top++; // Advance to next cell
        array[top] = value; // Add new element
    }

    @Override
    public String print() {
        return Arrays.toString(this.array);
    }

    @Override
    public String getBigOSearch() {
        return this.bigOSearch;
    }

    public String getBigOSort() {
        return this.bigOSort;
    }

    public void setBigOSort(String bigOSort) {
        this.bigOSort = bigOSort;
    }
}