package Hashing;

import java.util.*;

public class HashMapBasics {

    public static void main(String[] args) {

        // Create HashMap (Key -> Value)
        HashMap<String, Integer> map = new HashMap<>();

        // 1. Insert elements
        map.put("apple", 10);
        map.put("banana", 5);
        map.put("orange", 8);

        // 2. Update value (same key)
        map.put("apple", 15);

        // 3. Get value using key
        System.out.println("Apple: " + map.get("apple"));

        // 4. Check if key exists
        System.out.println("Contains banana? " + map.containsKey("banana"));

        // 5. Remove key
        map.remove("orange");

        // 6. Size of HashMap
        System.out.println("Size: " + map.size());

        // 7. Traverse HashMap
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // 8. Frequency count example (classic)
        int arr[] = {1, 2, 3, 2, 1, 1};

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        System.out.println("Frequency Map:");
        for (int key : freq.keySet()) {
            System.out.println(key + " occurs " + freq.get(key) + " times");
        }
    }
}
