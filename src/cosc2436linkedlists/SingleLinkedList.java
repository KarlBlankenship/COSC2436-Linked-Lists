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
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
