/*
 * This java class will contain an inner private node class as well as
 * defined metheds for creating and manageing a linked list. A main 
 * method will test the class and methods.
 * Methods will include...
 * push, pop, display, peek, empty, size, add, add after a provided value,
 * add after a provided index, remove, remove after a provided value,
 * remove after a provided index.
 * May also include add and remove methods for prior to specified values or
 * indexes and possible a bubble sort method.
 */
package cosc2436linkedlists;

/**
 * Single Linked List with methods noted above.
 * @author Karl
 */
public class SingleLinkedList 
{
    /**
     * Private inner class to define the blueprint of all nodes.
     */
    private class Node
    {
        String value;   // The value to be stored within a node.
        Node next;      // References the next (linked) node in the list.
        
        /**
         * Constructor that created a node containing a given value.
         * @param val The string that will be stored within the node.
         */
        Node(String val)
        {
            this.value = val;
        }
    }
    
    // Define the head and the tail of the linked list.
    Node head = null;
    Node tail = null;
    
    // Create an add method so that nodes can be added to the list.
    /**
     * The add method will add a new node to the end of the list.
     * If there is no current elements in the list, the new node
     * will be assigned the head and tail position.
     * @param val The value to be added to the new node.
     */
    private void add(String val)
    {
        // Create the new node.
        Node n = new Node(val);
 
        // If there is no head node, assign head and tail to new node. 
        if(head == null)
        {
            head = n;   // Set the head equal to n since its the only node.
            tail = n;   // Set the tail equal to n since its the only node.
        }
        // Else, add node to the end of the list and reassign tail.
        else
        {
            tail.next = n;  // Point the tail node to the new node.
            tail = n;       // Reassign tail reference to the new node.
        }
    }
    
    
    
    
    /**
     * This is the main method which will create the SingleLinkedList object
     * and test the methods.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Create a new SingleLinkedList object.
        SingleLinkedList sll = new SingleLinkedList();
        
        // Add an element to the new list and verify it has been added.
        sll.add("a");
        System.out.println("Head: " + sll.head.value);
        System.out.println("Tail: " + sll.tail.value);
        // Add another element to the new list and verify it has been added.
        System.out.println("\nAdding b usinb add method");
        sll.add("b");
        System.out.println("Head: " + sll.head.value);
        System.out.println("Tail: " + sll.tail.value);
    }
    
}
