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
     * The remove method will remove the head of the list (queue)
     * and will return the value that was removed.
     * @return The value of the node that was removed.
     */
    private String remove()
    {
        // Check that the list exists and return error if not.
        if (head == null)
        {
            return "Error";
        }
        else    // Remove the head of the list (queue)
        {
            // Create a temp node for returning the removed value.
            Node temp = head;
            // Reassign the head.
            head = head.next;
            head.prev = null;
            // Return the value of the original head.
            return temp.value;
        }
    }
    
    /**
     * The insert method will insert a given value after 
     * a provided value in the list.
     * @param val The value of the new node to be created.
     * @param after The value in the list to add the new node after.
     */
    private void insert(String val, String after)
    {
        // Create the new Node.
        Node n = new Node(val);
        // Create a temporary pointer variable/
        Node pointer = head;
        // Cycle through the list to find the index location.
        while (pointer != null)
        {
            if (pointer.value.equals(after))
            {
                if (pointer == tail)
                {
                    pointer.next = n;
                    n.prev = pointer;
                    tail = n;
                }
                else
                {
                    n.next = pointer.next;
                    pointer.next.prev = n;
                    n.prev = pointer;
                    pointer.next = n;
                }
                break;
            }
            pointer = pointer.next;
        }
    }
    
    /**
     * The push method will push a new node into the head
     * of the list. This is a stack.
     * @param val The value that will be in the new node.
     */
    private void push(String val)
    {
        // Create the new node.
        Node n = new Node(val);
        // Check if the list is empty.
        if (head == null)   // Create new list.
        {
            head = n;
            tail = n;
        }
        else    // Push to the head of the list (stack)
        {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }
    
    
    private String pop()
    {
        // Create a temp node for returning the value popped from the list.
        Node temp = head;
        // Pop the head of the list. Stack - FILO
        head = head.next;
        head.prev = null;
        // Return the value removed from the list.
        return temp.value;
    }
    
    /**
     * The display method will print the element values of the 
     * double link list to the terminal.
     */
    private void display()
    {
        // Create a temporary pointer node and set it equal to head.
        Node point = head;

        // Cycle through the list and display the contents.
        while (point != null)
        {
            System.out.print(point.value + " ");
            point = point.next;
        }
    }
    
    /**
     * The reverseDisplay method will print the element values of the 
     * double link list to the terminal in reverse order.
     */
    private void reverseDisplay()
    {
        // Create a temporary pointer node and set it equal to tail.
        Node point = tail;

        // Cycle through the list and display the contents.
        while (point != null)
        {
            System.out.print(point.value + " ");
            point = point.prev;
        }
    }
    
    public void dispRec()
    {
        dispRec(head);
        System.out.println();
    }
    
    private void dispRec(Node n)
    {
        if (n != null)
        {
            //System.out.print(n.value + " ");  // forward Print
            dispRec(n.next);
            System.out.print(n.value + " ");  // Reverse print.
        }
    }
    
    
    /**
     * The main method will create a double linked list object and 
     * test the various methods.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Create the double linked list object.
        DoubleLinkedList dll = new DoubleLinkedList();
        
        // Add an element a to the list.
        dll.add("a");
        dll.add("b");
        dll.add("c");
        dll.add("c");
        
        dll.display();
        System.out.println();
        dll.reverseDisplay();
        System.out.println();
        
        //dll.remove();
        dll.insert("x", "a");
        dll.insert("y", "c");
        dll.display();
        System.out.println();
        dll.reverseDisplay();
        System.out.println();
        
        dll.push("f");
        dll.push("g");
        dll.display();
        System.out.println();
        dll.reverseDisplay();
        System.out.println();
        
        dll.pop();
        System.out.println();
        dll.display();
        System.out.println();
        
        System.out.println("Recursive print");
        dll.dispRec();
    }
    
}
