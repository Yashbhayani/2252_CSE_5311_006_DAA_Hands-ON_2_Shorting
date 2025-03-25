class Node {
    int key, value;
    Node next, prev;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private Node first;
    
    public DoublyLinkedList() {
        this.first = null;
    }
    
    public void add(int key, int value) {
        Node newNode = new Node(key, value);
        if (first != null) {
            first.prev = newNode;
            newNode.next = first;
        }
        first = newNode;
    }
    
    public boolean delete(int key) {
        Node temp = first;
        while (temp != null) {
            if (temp.key == key) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                if (temp == first) {
                    first = temp.next;
                }
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    public Integer find(int key) {
        Node temp = first;
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }
    
    public Node getFirst() {
        return first;
    }
}

public class Main {
    private int maxCapacity;
    private int currentSize;
    private DoublyLinkedList[] hashTable;
    private final double CONSTANT = 0.6180339887;
    
    public Main(int initialCapacity) {
        this.maxCapacity = initialCapacity;
        this.currentSize = 0;
        this.hashTable = new DoublyLinkedList[maxCapacity];
        for (int i = 0; i < maxCapacity; i++) {
            hashTable[i] = new DoublyLinkedList();
        }
    }
    
    private int computeHash(int key) {
        double fractionalPart = (key * CONSTANT) % 1;
        return (int) (maxCapacity * fractionalPart);
    }
    
    private void adjustSize(int newCapacity) {
        DoublyLinkedList[] oldTable = hashTable;
        this.maxCapacity = newCapacity;
        this.hashTable = new DoublyLinkedList[maxCapacity];
        this.currentSize = 0;
        for (int i = 0; i < maxCapacity; i++) {
            hashTable[i] = new DoublyLinkedList();
        }
        for (DoublyLinkedList chain : oldTable) {
            Node temp = chain.getFirst();
            while (temp != null) {
                insert(temp.key, temp.value);
                temp = temp.next;
            }
        }
    }
    
    public void insert(int key, int value) {
        if ((double) currentSize / maxCapacity >= 1.0) {
            adjustSize(maxCapacity * 2);
        }
        int index = computeHash(key);
        if (hashTable[index].find(key) == null) {
            currentSize++;
        }
        hashTable[index].add(key, value);
    }
    
    public void remove(int key) {
        int index = computeHash(key);
        if (hashTable[index].delete(key)) {
            currentSize--;
            if (maxCapacity > 3 && currentSize <= maxCapacity / 4) {
                adjustSize(Math.max(3, maxCapacity / 2));
            }
        } else {
            System.out.println("Key " + key + " not found.");
        }
    }
    
    public int search(int key) {
        Integer result = hashTable[computeHash(key)].find(key);
        return result != null ? result : -1;
    }
    
    public void displayTable() {
        for (int i = 0; i < maxCapacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Node temp = hashTable[i].getFirst();
            while (temp != null) {
                System.out.print("(" + temp.key + ", " + temp.value + ") -> ");
                temp = temp.next;
            }
            System.out.println("None");
        }
    }
    
    public static void main(String[] args) {
        Main ht = new Main(3);
        ht.insert(10, 100);
        ht.insert(20, 200);
        ht.insert(30, 300);
        System.out.println("\nHash table with 3 elements.");
        ht.displayTable();
        ht.insert(40, 400);
        System.out.println("\nHash table with 4 elements. (Expanded)");
        ht.displayTable();
        System.out.println("\nSearch for key 20: " + ht.search(20));
        ht.remove(20);
        ht.remove(40);
        System.out.println("\nHash table after deleting some data.");
        ht.displayTable();
        ht.remove(10);
        ht.remove(30);
        System.out.println("\nHash table after deleting all data.");
        ht.displayTable();
    }
}
