public class Circular_Queue_Using_Array {
    static class Queue {
        int arr[];
        int size;
        int rear;
        int front;

        // Constructor
        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // Check if queue is full
        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Add element to queue
        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            // First element addition
            if (isEmpty()) {
                front = 0;
                rear = 0;
            } else {
                rear = (rear + 1) % size;
            }
            arr[rear] = data;
        }

        // Remove element from queue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int result = arr[front];

            if (rear == front) { // Single element left
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // Peek at front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        System.out.println("Peek: " + q.peek()); // 10
        System.out.println("Removed: " + q.remove()); // 10
        System.out.println("Peek after remove: " + q.peek()); // 20

        q.add(60); // Circular addition
        System.out.println("Peek after adding 60: " + q.peek()); // 20

        // Testing full condition
        q.add(70); // Should print Queue is full
    }
}