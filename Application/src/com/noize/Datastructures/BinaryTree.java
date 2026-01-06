package com.noize.Datastructures;

public class BinaryTree implements Datastructure{
    private String BigOSearch = "Worst-case time complexity: O(n) for unbalanced trees, O(log n) for balanced trees.";
    private String BigOSort = "Time complexity is 0(n)";


    // first node
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public String getBigOSearch() {
        return BigOSearch;
    }

    @Override
    public String getBigOSort() {
        return this.BigOSort;
    }

    @Override
    public void sort() {
        String output = String.valueOf(inOrder(root));
    }

    @Override
    public String print(){
//        Node current = root;
        String output = "";
        output += inOrder(root);
        return output;
    }

    @Override
    public Object search(int value) {
        Node current = root;
        int i =0;
        while (current.getValue() != value) // N * O(1)
        {
            if (value < current.getValue()) {
                // Move to the left if searched value is less
                current = current.getLeft();
            } else {
                // Move to the right if searched value is >=
                current = current.getRight();
            }
            if (current == null) {
                return null;
            }
            i++;
        }
        return i;
    }

    @Override
    public void insert(int value) {
        root = insertrec(root, value);
    }

    public Node insertrec(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        // Move to the left if passed value is
        // less than the current node
        if (value < node.getValue()) {
            node.setLeft(insertrec(node.getLeft(), value));
        }
        // Move to the right if passed value is
        // greater than the current node
        else if (value > node.getValue()) {
            node.setRight(insertrec(node.getRight(), value));
        }
        return node;
    }
    public String inOrder(Node node) {
        if (node == null) {
            return "";
        }
        return inOrder(node.getLeft())
                + node.getValue() + " "
                + inOrder(node.getRight());
    }

    // Preorder traversal
    public void preOrder(Node node) {
        if (node != null) {
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    // Postorder traversal
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
        }
    }

    public Node getRoot() {
        return this.root;
    }

}
