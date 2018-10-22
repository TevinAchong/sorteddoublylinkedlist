public class SortedDoublyLinkedList implements LinkedList {

    // The head instance variable that will point to the head of the linked list
    Node head; 

    // No constructor specified so a new instance can be created without specifying parameters
    public void insert(Warrior warrior) {
        // We need to insert the new Warrior in descending order according to speed
        
        // Allocating space for the new Warrior (storing it in a Node)
        Node newNode = new Node(warrior); 

        // If the list is empty
        if (this.head == null) {
            this.head = newNode; // Simply setting the head of the list to the new node
        }
        // If the new value is to be placed as the new head (if it is greater than the current head)
        else if(this.head.warrior.getSpeed() <= newNode.warrior.getSpeed()) {
                newNode.next = this.head; 
                this.head.prev = newNode; 
                this.head = newNode; 
        }
        // If the value is less than the current head then the list needs to be traversed
        else {
            // We need to traverse the list until we find the proper place for the new Warrior (based on speed)
            Node curr = this.head.next; 
            while (curr.next != null) {
                if (curr.warrior.getSpeed() <= newNode.warrior.getSpeed()) {
                    newNode.next = curr; 
                    newNode.prev = curr.prev; 
                    curr.prev = newNode; 
                    newNode.prev.next = newNode;
                    return;  
                }
                curr = curr.next; 
            }

            // If we search the list and have not found a place for the new warriror, then the new warrior is the new smallest value
            if (curr.next == null) {
                if (curr.warrior.getSpeed() <= newNode.warrior.getSpeed()) {
                    newNode.next = curr; 
                    newNode.prev = curr.prev; 
                    curr.prev = newNode; 
                    newNode.prev.next = newNode; 
                }
                else {
                    curr.next = newNode; 
                    newNode.prev = curr; 
                }
            }
        }
    }

    public String toString() {
        String stringRep = "[ "; 
        Node curr = this.head; 
        while (curr != null) {
            stringRep += curr.warrior.toString(); 
            stringRep += " ";
            curr = curr.next;
        }
        stringRep += "]"; 
        return stringRep; 
    }

    // Inner class Node, which will store elements in the list
    class Node {
        // We are using a doubly linked list so there is a pointer to the prev and the next
        Warrior warrior; 
        Node next; 
        Node prev; 
        
        // Constructor for the Node class
        public Node(Warrior w) {
            this.warrior = w; 
            this.next = null; 
            this.prev = null; 
        }

    }

}