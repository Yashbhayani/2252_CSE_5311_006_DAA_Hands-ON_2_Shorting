package org.example;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
public class LinkedList {
    Node head;
    int capacity;
    int size;

    public LinkedList(int capacity) {
        this.head = null;
        this.capacity = capacity;
        this.size = 0;
    }

    public int insertAtHead(int value) {
        if (size == capacity) {
            System.out.println("Linked List Overflow!");
            return -1; // Indicating failure to insert
        }

        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;

        return value;
    }

    public Integer removeFromHead() {
        if (head == null) {
            System.out.println("Linked List Underflow!");
            return null; // Indicating failure to remove
        }

        int removedValue = head.value;
        head = head.next;
        size--;

        return removedValue;
    }

    public Integer top() {
        if (head == null) {
            System.out.println("Linked List is Empty!");
            return null; // Indicating the list is empty
        }

        return head.value;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked List is Empty!");
            return;
        }

        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(5);

        System.out.println("Insert at Head: " + linkedList.insertAtHead(1));
        System.out.println("Insert at Head: " + linkedList.insertAtHead(2));
        System.out.println("Insert at Head: " + linkedList.insertAtHead(3));
        System.out.println("Insert at Head: " + linkedList.insertAtHead(4));
        linkedList.display();

        System.out.println("Top Element: " + linkedList.top());

        System.out.println("Remove from Head: " + linkedList.removeFromHead());
        linkedList.display();

        System.out.println("Insert at Head: " + linkedList.insertAtHead(4));
        System.out.println("Insert at Head: " + linkedList.insertAtHead(5));
        System.out.println("Insert at Head: " + linkedList.insertAtHead(6));
        linkedList.display();

        System.out.println("Top Element: " + linkedList.top());

        System.out.println("Remove from Head: " + linkedList.removeFromHead());
        System.out.println("Remove from Head: " + linkedList.removeFromHead());
        System.out.println("Remove from Head: " + linkedList.removeFromHead());
        System.out.println("Remove from Head: " + linkedList.removeFromHead());
        System.out.println("Remove from Head: " + linkedList.removeFromHead());
        System.out.println("Remove from Head: " + linkedList.removeFromHead());
        linkedList.display();
    }
}
