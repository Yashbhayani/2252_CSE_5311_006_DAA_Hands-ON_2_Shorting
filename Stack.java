package org.example;

public class Stack {
    private int size;
    private Integer[] stack;
    private int topIndex;

    public Stack(int size) {
        this.size = size;
        this.stack = new Integer[size];
        this.topIndex = -1;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public boolean isFull() {
        return topIndex == size - 1;
    }

    public Integer push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow!");
            return null;
        }

        stack[++topIndex] = value;
        return value;
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return null;
        }

        Integer value = stack[topIndex];
        stack[topIndex--] = null;
        return value;
    }

    public Integer top() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return null;
        }
        return stack[topIndex];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return;
        }

        System.out.print("Stack: ");
        for (int i = 0; i < size; i++) {
            if (stack[i] != null) {
                System.out.print(stack[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        System.out.println("Stack Top: " + stack.top());
        System.out.println("Stack Push: " + stack.push(1));
        System.out.println("Stack Push: " + stack.push(2));
        System.out.println("Stack Push: " + stack.push(3));
        System.out.println("Stack Push: " + stack.push(4));
        stack.display();
        System.out.println("Stack Top: " + stack.top());
        System.out.println("Stack Pop: " + stack.pop());
        stack.display();
        System.out.println("Stack Push: " + stack.push(4));
        System.out.println("Stack Push: " + stack.push(5));
        System.out.println("Stack Push: " + stack.push(6));
        stack.display();
        System.out.println("Stack Top: " + stack.top());
        System.out.println("Stack Pop: " + stack.pop());
        System.out.println("Stack Pop: " + stack.pop());
        System.out.println("Stack Pop: " + stack.pop());
        System.out.println("Stack Pop: " + stack.pop());
        System.out.println("Stack Pop: " + stack.pop());
        System.out.println("Stack Pop: " + stack.pop());
        stack.display();
    }
}

