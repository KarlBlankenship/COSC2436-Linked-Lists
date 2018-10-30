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
        int value;      // Integer value to be held in the node.
        Node left;      // left pointer.
        Node right;     // Right pointer.
        
        private Node(int val)
        {
            this.value = val;
        }
    }
    
    Node root = null;
    
    public Node add(Node current, int val)
    {
        if (current == null)
            return new Node(val);
        else if (val < current.value)
            current.left = add(current.left, val);
        else if (val > current.value)
            current.right = add(current.right, val);
        return current;    
    }
    
    public void addValue()
    {
        root = add(root, 10);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
