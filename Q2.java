class Stack {
    private int[] items;
    private int top;
    private int maxSize;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.items = new int[maxSize];
        this.top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(int item) {
        if (top == maxSize) {
            throw new StackOverflowError("Stack overflow");
        }
        items[top++] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack underflow");
        }
        return items[--top];
    }
}

class Queue {
    private int[] items;
    private int head, tail, maxSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.items = new int[maxSize];
        this.head = 0;
        this.tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(int item) {
        if (tail == maxSize) {
            throw new IllegalStateException("Queue overflow");
        }
        items[tail++] = item;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue underflow");
        }
        return items[head++];
    }
}

class Node {
    int data;
    Node next, prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node listSearch(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void listInsert(Node x) {
        x.next = head;
        if (head != null) {
            head.prev = x;
        }
        head = x;
        x.prev = null;
    }

    public void listDelete(Node x) {
        if (x.prev != null) {
            x.prev.next = x.next;
        } else {
            head = x.next;
        }
        if (x.next != null) {
            x.next.prev = x.prev;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());

        Queue queue = new Queue(10);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());

        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        linkedList.listInsert(node1);
        linkedList.listInsert(node2);
        linkedList.listInsert(node3);
        linkedList.listDelete(node2);
        System.out.println(linkedList.listSearch(1).data);
    }
}
