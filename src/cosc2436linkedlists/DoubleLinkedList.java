/*
 * Double link list createrd from scratch to study for the cosc2436 midterm.
 * Write Insert, Delete, Display and ReverseDisplay methods.
 */
package cosc2436linkedlists;

/**
 *
 * @author Karl
 */
public class DoubleLinkedList {

    /**
     * Double linked list node contains a value and and fields 
     * for the next node and previous node.
     */
    private class Node
    {
        String value;
        Node next;
        Node prev;
        
        /**
         * Constructor accepts a String to contain the Node value.
         * @param val The value to be contained in the Node.
         */
        private Node(String val)
        {
            this.value = val;
        }
    }
    
    // Create the head and tail reference variables for the list.
    Node head = null;
    Node tail = null;
    
    /**
     * The add method will either create a new list with an initial node
     * or add a new node to the tail such as in a queue.
     * @param val The value to be added to the list.
     */
    private void add(String val)
    {
        // Create the new node.
        Node n = new Node(val);

        // Check to see if there is an existing list.
        if (head == null)
        {
            // Create the new list.
            head = n;
            tail = n;
        }
        else    // There is an existing list.
        {
            // Add new node to the tail (queue)
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
