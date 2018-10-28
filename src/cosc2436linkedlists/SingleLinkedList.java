/*
 * This java class will contain an inner private node class as well as
 * defined metheds for creating and manageing a linked list. A main 
 * method will test the class and methods.
 * Methods will include...
 * push, pop, display, peek, empty, size, add, add after a provided value,
 * add after a provided index, remove, remove after a provided value,
 * remove after a provided index.
 * May also include add and remove methods for prior to specified values or
 * indexes and possibly a bubble sort method.
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
     * The remove method will remove the tail item from the list
     * and will return the value.
     * @return The value that was removed from the list.
     */
    public String remove()  // Removes the tail
    {
        // Create a temp node for cycling to the end.
        Node temp = head;
        // Create the return node;
        Node ret = head;
        
        // Check for empty list;
        if (size() == 0)
            return "List is empty";
              
        if (size() == 1)
        {
            head = null;
            tail = null;
            return ret.value;
        }
        else
        {
            // Cycle to the node prior to last and remove last.
            while (temp != tail)
            {
                ret = temp;
                temp = temp.next;
            }
            ret.next = null;
            tail = ret;

            return ret.value;
        }
    }
            
    
    /**
     * The addAfterValue method will add a provided value after 
     * a specified value in the list.
     * @param valToAdd The value to be added to the list.
     * @param afterVal The value in the list where the new element will be
     * placed after.
     */
    private void addAfterValue(String valToAdd, String afterVal)
    {
        // Create a pointer node to cycle through to and mark the desired node.
        Node pointer = head;
        // Create the new node.
        Node node = new Node(valToAdd);
        
        // Check to see if the list is empty and add only node if it is.
        if (empty())
        {
            head = node;
            tail = node;
        }
        else    // There are already existing elements in the list.
        {
            // Cycle through until the desired value is found.
            while (pointer != null)
            {
                if (pointer.value.equals(afterVal))
                {
                    // Check for tail.
                    if (pointer == tail)
                    {
                        tail = node;
                    }
                    node.next = pointer.next;
                    pointer.next = node;
                }
                pointer = pointer.next;
            }
        }
    }        
    
    
    private void addAfterIndex(String value, int index)
    {
        // Create the new Node.
        Node node = new Node(value);
        // Create the temp node to cycle through the list.
        Node temp = head;
        
        // Check that the index is within the list
        if (index < 0 || index >= size())
            System.out.println("Invalis index.");  // Should be an exception.
        else  // Index is within the list.
        {
            for (int i = 0; i < index; i++)  // Cycle to provided index.
            {
                temp = temp.next;
            }
            // Add the new node after temp index.
            node.next = temp.next;
            if(temp == tail)
            {
                tail = node;
            }
            temp.next = node;
        }   
    }
    
//    private void recursiveDisplay()
//    {
//        recursiveDisplay(head);
//    }
//    
//    public void recursiveDisplay(Node hd)
//    {
//        if (hd == null)
//            System.out.println("");
//        else
//            System.out.println(hd.value + recursiveDisplay(hd.next));
//    }
    
    public void displayRecursively()
    {
        displayRecursively(head);
    }
    
    private void displayRecursively(Node current)
    {
        if (current !=  null)
        {
            System.out.print(current.value + " ");
            displayRecursively(current.next);
        }       
        
    }
    
    public void displayReverseRecursively()
    {
        displayReverseRecursively(head);
    }
    
    private void displayReverseRecursively(Node current)
    {
        if (current !=  null)
        {
            
            displayReverseRecursively(current.next);
            System.out.print(current.value + " ");
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
        
        sll.add("d");
        sll.add("c");
        sll.add("b");
        sll.add("a");
        sll.displayRecursively();
        sll.displayReverseRecursively();
    }
    
}
