package Hashing;

import java.util.*;

public class HashMapCode {

    // Custom HashMap implementation
    static class HashMap<K, V> {

        // Node class (Linked List node)
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;                 // number of key-value pairs
        private LinkedList<Node>[] buckets; // array of linked lists
        private final int INITIAL_CAPACITY = 4;

        // Constructor
        @SuppressWarnings("unchecked")
        public HashMap() {
            buckets = new LinkedList[INITIAL_CAPACITY];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            size = 0;
        }

        // Hash function
        private int hashFunction(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % buckets.length;
        }

        // Search key in bucket
        private int searchInBucket(K key, int bucketIndex) {
            LinkedList<Node> list = buckets[bucketIndex];
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        // Put (insert/update)
        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInBucket(key, bucketIndex);

            if (dataIndex == -1) {
                buckets[bucketIndex].add(new Node(key, value));
                size++;
            } else {
                buckets[bucketIndex].get(dataIndex).value = value;
            }

            double lambda = (double) size / buckets.length;
            if (lambda > 2.0) {
                rehash();
            }
        }

        // Rehashing
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[oldBuckets.length * 2];

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            size = 0;

            for (LinkedList<Node> list : oldBuckets) {
                for (Node node : list) {
                    put(node.key, node.value);
                }
            }
        }

        // Get value
        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInBucket(key, bucketIndex);

            if (dataIndex == -1) {
                return null;
            }
            return buckets[bucketIndex].get(dataIndex).value;
        }

        // Remove key
        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInBucket(key, bucketIndex);

            if (dataIndex == -1) {
                return null;
            }

            Node removedNode = buckets[bucketIndex].remove(dataIndex);
            size--;
            return removedNode.value;
        }

        // Contains key
        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            return searchInBucket(key, bucketIndex) != -1;
        }

        // Size
        public int size() {
            return size;
        }

        // Is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Key set
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> list : buckets) {
                for (Node node : list) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 150);
        map.put("China", 140);
        map.put("USA", 33);
        map.put("India", 155); // update

        System.out.println(map.get("India"));   // 155
        System.out.println(map.containsKey("USA")); // true
        System.out.println(map.remove("China")); // 140
        System.out.println(map.size()); // 2

        System.out.println(map.keySet()); // keys
    }
}
