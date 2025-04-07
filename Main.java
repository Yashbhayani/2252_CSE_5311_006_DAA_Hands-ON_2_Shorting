public class Main {
    private int capacity;
    private int size;
    private int[] arr;

    public Main(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    public Main() {
        this(2);
    }

    public void add(int value) {
        if (size == capacity) {
            resize(capacity * 2);
        }

        arr[size] = value;
        size++;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }

        if (size == capacity) {
            resize(capacity * 2);
        }

        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = value;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;

        if (size <= capacity / 4 && capacity > 2) {
            resize(Math.max(capacity / 2, 2));
        }
    }

    public void remove() {
        if (size > 0) {
            size--;

            if (size <= capacity / 4 && capacity > 2) {
                resize(Math.max(capacity / 2, 2));
            }
        } else {
            System.out.println("Array is already empty");
        }
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return -1; 
        }

        return arr[index];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private void resize(int newCapacity) {
        int[] newArr = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
        capacity = newCapacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Main dynArr = new Main();
        dynArr.add(1);
        dynArr.add(2);
        dynArr.add(3);
        dynArr.add(4);

        System.out.println("Elements of the array: " + dynArr);
        System.out.println("Size of the array: " + dynArr.getSize());
        System.out.println("Capacity of the array: " + dynArr.getCapacity());

        dynArr.insert(2, 2);
        System.out.println("\nAfter inserting 2 at index 2: " + dynArr);

        dynArr.delete(2);
        System.out.println("\nAfter deleting element at index 2: " + dynArr);

        dynArr.remove();
        System.out.println("\nAfter removing last element");
        System.out.println("Elements of the array: " + dynArr);
        System.out.println("Size of the array: " + dynArr.getSize());
        System.out.println("Capacity of the array: " + dynArr.getCapacity());
        System.out.println();

        dynArr.remove();
        dynArr.remove();
        dynArr.remove();
        dynArr.remove();

        System.out.println("\nAfter removing all elements");
        System.out.println("Elements of the array: " + dynArr);
        System.out.println("Size of the array: " + dynArr.getSize());
        System.out.println("Capacity of the array: " + dynArr.getCapacity());
    }
}
