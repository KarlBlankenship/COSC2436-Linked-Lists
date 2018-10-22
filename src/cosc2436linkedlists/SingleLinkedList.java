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
    
    // Create a push method to push a new node onto the stack,
    // replacing the head.
    /**
     * The push method will create a new node and push it onto
     * the stack replacing the head.
     * @param val The value to be contained in the new node.
     */
    private void push(String val)
    {
        // Create the new node.
        Node n = new Node(val);
        
        // If there is head, the list is empty.
        if (head == null)
        {
            head = n;
            tail = n;
        }
        // Else, there are already elements so add before head.
        else
        {
            n.next = head;
            head = n;
        }
    }
    
    /**
     * The pop method will remove the head of the stack
     * and will return the value that was removed.
     * @return The value of the node that was removed.
     */
    private String pop()
    {
        Node temp = head;  // Set a temporaty Node to return the value.
        head = head.next;  // Remove the head by setting head to the next Node.
        return temp.value; // Return the value that was removed.
    }
    
    /**
     * The peek method will return the value of the head of the 
     * list but will not remove and reassign the head.
     * @return The head value of the list.
     */
    private String peek()
    {
        return head.value;
    }
    
    /**
     * The display method will display the contents of the list.
     */
    private void display()
    {
        // Create a temporary node for cycling through list.
        Node temp = head;
        // Cycle through Nodes and display list values.
        while (temp != null)
        {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }  
    }
    
    /**
     * The counter method will count how many elements are in the 
     * list and return that number as an integer.
     * @return The number of elements in the list.
     */
    private int size()
    {
        // Create a temp node for cycling through the list.
        Node temp = head;
        // Create a counter.
        int counter = 0;
        // Cycle through the list and increment the counter.
        while (temp != null )
        {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    /**
     * The empty method will return true of the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    private boolean empty()
    {
        return (head == null);
    }
    
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
        
        // Check the list empty method prior to adding anything to the list.
        System.out.println("Empty Expected: true\tActual: " + sll.empty());
        System.out.println();
        // Add an element to the new list and verify it has been added.
        sll.add("d");
        System.out.println("Add d:");
        System.out.print(" List Expected: d\tActual: ");
        sll.display(); System.out.println();
        System.out.println(" Head Expected: d\tActual: " + sll.head.value);
        System.out.println(" Tail Expected: d\tActual: " + sll.tail.value);
        System.out.println(" Size Expected: 1\tActual: " + sll.size());
        System.out.println(" Peek Expected: d\tActual: " + sll.peek());
        System.out.println("Empty Expected: false\tActual: " + sll.empty());
        System.out.println();
        
        // Add another element to the new list and verify it has been added.
        sll.add("f");
        System.out.println("Add f:");
        System.out.print(" List Expected: d f\tActual: ");
        sll.display(); System.out.println();
        System.out.println(" Head Expected: d\tActual: " + sll.head.value);
        System.out.println(" Tail Expected: f\tActual: " + sll.tail.value);
        System.out.println(" Size Expected: 2\tActual: " + sll.size());
        System.out.println(" Peek Expected: d\tActual: " + sll.peek());
        System.out.println("Empty Expected: false\tActual: " + sll.empty());
        System.out.println();
        
        // Push an element to the new list and verify it has become the head.
        sll.push("b");
        System.out.println("Push b:");
        System.out.print(" List Expected: b d f\tActual: ");
        sll.display(); System.out.println();
        System.out.println(" Head Expected: b\tActual: " + sll.head.value);
        System.out.println(" Tail Expected: f\tActual: " + sll.tail.value);
        System.out.println(" Size Expected: 3\tActual: " + sll.size());
        System.out.println(" Peek Expected: b\tActual: " + sll.peek());
        System.out.println("Empty Expected: false\tActual: " + sll.empty());
        System.out.println();
        
        // Pop an element from the list.
        sll.pop();
        System.out.println("Pop:");
        System.out.print(" List Expected: d f\tActual: ");
        sll.display(); System.out.println();
        System.out.println(" Head Expected: d\tActual: " + sll.head.value);
        System.out.println(" Tail Expected: f\tActual: " + sll.tail.value);
        System.out.println(" Size Expected: 2\tActual: " + sll.size());
        System.out.println(" Peek Expected: d\tActual: " + sll.peek());
        System.out.println("Empty Expected: false\tActual: " + sll.empty());
        System.out.println();
    }
    
}
