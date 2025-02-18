import java.util.Scanner;

public class Main {
    private double[] heap;
    private int size;

    public Main() {
        heap = new double[100];
        size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return (2 * i) + 1;
    }

    private int right(int i) {
        return (2 * i) + 2;
    }

    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    public void buildMinHeap(double[] arr) {
        this.heap = arr;
        this.size = arr.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public double pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        double root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        if (size > 0) {
            heapify(0);
        }

        return root;
    }

    public void insert(double value) {
        if (size == heap.length) {
            resize();
        }

        heap[size] = value;
        int i = size;
        size++;

        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void swap(int i, int j) {
        double temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resize() {
        double[] newHeap = new double[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main minHeap = new Main();

        System.out.println("Welcome to Min-Heap Operations!!");

        while (true) {
            System.out.println("\nChoose an operation which you want to perform:");
            System.out.println("1. Build Min-Heap from an array");
            System.out.println("2. Insert an element into the heap");
            System.out.println("3. Pop the root element from the heap");
            System.out.println("4. Display the heap");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of elements: ");
                    int n = scanner.nextInt();
                    double[] arr = new double[n];
                    System.out.print("Enter the array elements (separated by spaces): ");
                    for (int i = 0; i < n; i++) {
                        arr[i] = scanner.nextDouble();
                    }
                    minHeap.buildMinHeap(arr);
                    System.out.println("Min-Heap built successfully!");
                    minHeap.display();
                    break;
                case 2:
                    System.out.print("Enter the element to insert into the heap: ");
                    double element = scanner.nextDouble();
                    minHeap.insert(element);
                    System.out.println("Inserted " + element + " into the heap.");
                    minHeap.display();
                    break;
                case 3:
                    if (minHeap.size == 0) {
                        System.out.println("Heap is empty!");
                    } else {
                        double popped = minHeap.pop();
                        System.out.println("Popped element: " + popped);
                        minHeap.display();
                    }
                    break;
                case 4:
                    System.out.println("Current Min-Heap:");
                    minHeap.display();
                    break;
                case 5:
                    System.out.println("Exit!!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choose a valid option!");
                    break;
            }
        }
    }
}
