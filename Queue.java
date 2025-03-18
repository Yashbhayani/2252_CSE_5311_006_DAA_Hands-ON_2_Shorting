package org.example;

public class Queue {
    private int size;
    private int[] queue;
    private int front, rear;

    public Queue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        queue[rear] = value;
        System.out.println("Queue Enqueue: " + value);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }

        int value = queue[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return value;
    }

    public int frontValue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }

        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.print("Queue: ");
        for (int i = front; i != rear; i = (i + 1) % size) {
            System.out.print(queue[i] + " ");
        }
        System.out.println(queue[rear]);
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.display();

        System.out.println("Queue Front: " + queue.frontValue());

        System.out.println("Queue Dequeue: " + queue.dequeue());
        queue.display();

        queue.enqueue(5);
        queue.display();

        System.out.println("Queue Front: " + queue.frontValue());

        System.out.println("Queue Dequeue: " + queue.dequeue());
        System.out.println("Queue Dequeue: " + queue.dequeue());
        System.out.println("Queue Dequeue: " + queue.dequeue());
        System.out.println("Queue Dequeue: " + queue.dequeue());
        queue.display();
    }
}
