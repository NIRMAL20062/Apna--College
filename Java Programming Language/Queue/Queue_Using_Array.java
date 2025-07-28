public class Queue_Using_Array {
    static class Queue {
        int arr[];
        int size;
        int rear = -1;

        // Constructor
        Queue(int size) {
            this.size = size;
            arr = new int[size];
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return rear == -1;
        }

        // Add element to queue
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        // Remove element from queue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            // Shift elements to left
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        // Peek at front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Peek: " + q.peek()); // 10
        System.out.println("Removed: " + q.remove()); // 10
        System.out.println("Peek after remove: " + q.peek()); // 20
    }
}