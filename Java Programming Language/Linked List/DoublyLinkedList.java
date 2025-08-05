// Doubly Linked List Implementation in Java
public class DoublyLinkedList {

    // Node class: Each node has data, next and prev pointers
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    // Head and tail references
    private Node head;
    private Node tail;

    // 1. Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // 2. Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // 3. Insert at a specific position (0-based index)
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node current = head;

        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Invalid position!");
                return;
            }
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position!");
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }

        current.next = newNode;
    }


    // 4. Delete by value
    public void deleteByValue(int data) {
        if (head == null) return;

        // Case 1: Deleting head
        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                // List had only one element
                tail = null;
            }
            return;
        }

        // Traverse to find the node
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        // Value not found
        if (current == null) {
            System.out.println("Value not found!");
            return;
        }

        // Re-link pointers
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }

    // Optional: Disconnect current node (clean up for clarity)
    current.next = null;
    current.prev = null;

        System.out.println("Deleted: " + data);
        
}


    // 5. Delete by position
    public void deleteByPosition(int position) {
        if (head == null) return;

        if (position == 0) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            return;
        }

        Node current = head;
        for (int i = 0; i < position; i++) {
            if (current == null) {
                System.out.println("Invalid position!");
                return;
            }
            current = current.next;
        }

        if (current == null) return;

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

    // 6. Display list forward
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 7. Display list backward
    public void displayBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // 8. Search
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) return true;
            current = current.next;
        }
        return false;
    }

    // 9. Get size
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Main method to test
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtEnd(10);
        dll.insertAtBeginning(5);
        dll.insertAtEnd(20);
        dll.insertAtPosition(15, 2);

        dll.displayForward();  // 5 <-> 10 <-> 15 <-> 20 <-> null
        dll.displayBackward(); // 20 <-> 15 <-> 10 <-> 5 <-> null

        dll.deleteByValue(15);
        dll.displayForward();  // 5 <-> 10 <-> 20 <-> null

        dll.deleteByPosition(0);
        dll.displayForward();  // 10 <-> 20 <-> null

        System.out.println("Size: " + dll.size());  // 2
        System.out.println("Search 20: " + dll.search(20));  // true
        System.out.println("Search 30: " + dll.search(30));  // false
    }
}
