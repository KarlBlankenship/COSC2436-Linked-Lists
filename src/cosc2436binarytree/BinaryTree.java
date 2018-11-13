/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc2436binarytree;

/**
 *
 * @author Karl
 */
public class BinaryTree 
{
    
    private class Node
    {
        int value;  // Value to be stored in the node.
        Node left;  // Reference to the left node.
        Node right; // Reference to the right node.
        
        /**
         * Constructor.
         * @param val 
         */
        private Node(int val)
        {
            this.value = val;
        }
    }
    
    // Create the root node.
    Node root = null;   // Reference variable for the root node.
    
    /**
     * Recursivel adds a new node or creates the root node.
     * @param current
     * @param val 
     */
    public Node add(Node current, int val)
    {
        if(current == null)
            return new Node(val);
        else
        {
            if(val < current.value)
                current.left = add(current.left, val);
            else
                current.right = add(current.right, val);
            return current;
        }
    }

    /**
     * Method to be called from main method to add values.
     */
    public void addValues()
    {
        root = add(root, 20);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BinaryTree bt = new BinaryTree();
        
        bt.addValues();
        
    }
    
}
