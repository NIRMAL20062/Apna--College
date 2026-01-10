public class MinHeap {

    int[] heap;
    int size;
    int capacity;

    // Constructor
    MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Insert element into min heap
    void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        // Step 1: place at end
        heap[size] = value;
        int current = size;
        size++;

        // Step 2: heapify up
        while (current > 0) {
            int parent = (current - 1) / 2;

            if (heap[current] < heap[parent]) {
                int temp = heap[current];
                heap[current] = heap[parent];
                heap[parent] = temp;
                current = parent;
            } else {
                break;
            }
        }
    }

    // Print heap
    void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method (same file)
    public static void main(String[] args) {

        MinHeap h = new MinHeap(10);

        h.insert(20);
        h.insert(5);
        h.insert(15);
        h.insert(2);
        h.insert(8);

        h.printHeap();
    }
}
