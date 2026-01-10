public class DeleteNode {

    int[] heap;
    int size;
    int capacity;

    // Constructor
    DeleteNode(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Insert into min heap (heapify-up)
    void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        while (current > 0) {
            int parent = (current - 1) / 2;

            if (heap[current] < heap[parent]) {
                swap(current, parent);
                current = parent;
            } else {
                break;
            }
        }
    }

    // Heapify-down from index i
    void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

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

    // Delete minimum element (root)
    int deleteMin() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);

        return min;
    }

    void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        DeleteNode h = new DeleteNode(10);

        h.insert(10);
        h.insert(4);
        h.insert(15);
        h.insert(20);
        h.insert(1);

        h.printHeap();

        System.out.println("Deleted node: " + h.deleteMin());

        h.printHeap();
    }
}